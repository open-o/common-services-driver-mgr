/*
 * Copyright 2016 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openo.drivermgr.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.openo.drivermgr.business.inf.IDriverManager;
import org.openo.drivermgr.common.CheckDriverParameter;
import org.openo.drivermgr.common.CommonUtil;
import org.openo.drivermgr.constant.Constant;
import org.openo.drivermgr.constant.ErrorCode;
import org.openo.drivermgr.entity.DriverInfo;
import org.openo.drivermgr.entity.DriverInstance;
import org.openo.drivermgr.entity.DriverProperties;
import org.openo.drivermgr.entity.DriverUrl;
import org.openo.drivermgr.entity.ExtSysInfo;
import org.openo.drivermgr.exception.DriverManagerException;
import org.openo.drivermgr.rest.client.ClientCommunication;
import org.openo.drivermgr.service.inf.IDriverManagerDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service Implementation for analysis and fulfilling the request by giving control to the manager
 * layer for Driver Manager.
 * <br/>
 * 
 * @author
 * @version  
 */
public class DriverMgrServiceImpl implements IDriverManagerDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverMgrServiceImpl.class);

    @Autowired
    IDriverManager driverManager;

    /**
     * @return Returns the driverManager.
     */
    public IDriverManager getDriverManager() {
        return driverManager;
    }

    /**
     * @param driverManager The driverManager to set.
     */
    public void setDriverManager(IDriverManager driverManager) {
        this.driverManager = driverManager;
    }

    /**
     * Register the driver info to the db.
     * <br/>
     * 
     * @param request : HttpServletRequest Object
     * @param response : HttpServletResponse Object
     * @since  
     */
    public void register(HttpServletRequest request, HttpServletResponse response) {

        LOGGER.info("Going to Register Driver");

        DriverProperties driverProp = CommonUtil.getInstance().getDriverInfo(request);

        CheckDriverParameter.getInstance().checkParameter(driverProp.getDriverInfo());

        String instanceId = driverProp.getDriverInfo().getInstanceID();

        if(driverManager.getDriverByInstanceId(instanceId) != null) {
            throw new DriverManagerException(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, ErrorCode.DUPLICATE_ID);
        }

        if(driverManager.registerDriver(driverProp)) {
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            throw new DriverManagerException(HttpServletResponse.SC_FORBIDDEN, ErrorCode.FAILURE_INFORMATION);
        }
    }

    /**
     * unregister the driver info from the DB.
     * <br/>
     * 
     * @param request : HttpServletRequest Object
     * @param response : HttpServletResponse Object
     * @since  
     */
    public void unregister(HttpServletRequest request, HttpServletResponse response, String instanceId) {

        LOGGER.info("Going to UnRegister Driver");

        if(driverManager.getDriverByInstanceId(instanceId) == null) {
            throw new DriverManagerException(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
                    ErrorCode.INVALID_PARAMETERS);
        }

        if(driverManager.unregisterDriver(instanceId)) {
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            throw new DriverManagerException(HttpServletResponse.SC_FORBIDDEN, ErrorCode.FAILURE_INFORMATION);
        }
    }

    /**
     * get the driver info from the driver managerment.
     * <br/>
     * 
     * @param request
     * @param response
     * @param serviceUrl
     * @param systemId
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonGenerationException
     * @since  
     */
    public String getDriverDetails(HttpServletRequest request, HttpServletResponse response, String serviceUrl,
            String systemId) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if(null == serviceUrl && null == systemId) {
                return mapper.writeValueAsString(getDriverDetails(request, response));
            } else {
                if(StringUtils.isBlank(systemId)) {
                    throw new DriverManagerException(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
                            ErrorCode.INVALID_PARAMETERS);
                }

                String driverUrl = getDriverDetail(request, response, serviceUrl, getSystemID(systemId));
                return mapper.writeValueAsString(new DriverUrl(driverUrl));

            }
        } catch(IOException e) {
            LOGGER.error("IO Exception Occuered", e);
            throw new DriverManagerException(HttpServletResponse.SC_REQUEST_TIMEOUT, ErrorCode.COMMUNICATION_ERROR);
        }
    }

    /**
     * get the driver info from the driver managerment.
     * <br/>
     * 
     * @param request
     * @param response
     * @param serviceUrl
     * @param systemId
     * @return
     * @since  
     */
    private String getDriverDetail(HttpServletRequest request, HttpServletResponse response, String serviceUrl,
            String systemId) {

        LOGGER.info("Going to get driver info by systemid = " + systemId);
        ExtSysInfo extSysInfo = ClientCommunication.getInstance().getExtSysInfo(systemId);

        String type = extSysInfo.getType();
        String version = extSysInfo.getVersion();

        LOGGER.info("Information from ESR + Name =" + extSysInfo.getName() + ", Type=" + type
        + " , Version = " + version);
        
        String path = driverManager.getDriverInfo(serviceUrl, type, version);
        if(StringUtils.isNotEmpty(path)) {
            return path;
        } else {
            LOGGER.error("No match driver info is found.");
            throw new DriverManagerException(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
                    ErrorCode.INVALID_PARAMETERS);
        }
    }

    /**
     *get the driver info from the driver managerment.
     * <br/>
     * 
     * @param request
     * @param response
     * @return
     * @since  
     */
    private List<DriverInfo> getDriverDetails(HttpServletRequest request, HttpServletResponse response) {

        List<DriverInstance> driverInstances = driverManager.getAllDriverInstance();
        List<DriverInfo> driverInfos = new ArrayList<DriverInfo>();

        for(DriverInstance driverInstance : driverInstances) {
            driverInfos.add(CommonUtil.getInstance().getDriverInfo(driverInstance.getModel()));
        }

        return driverInfos;
    }

    private String getSystemID(String systemID) {

        String sysID = "";
        if(StringUtils.isNotBlank(systemID) && systemID.contains("=")) {
            String[] values = systemID.split("=");
            if(values[0].equals(Constant.SYSTEM_ID_PARAM)) {
                sysID = values[1];
            }
        } else {
            throw new DriverManagerException(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
                    ErrorCode.INVALID_PARAMETERS);
        }
        if(!StringUtils.isNotBlank(sysID)) {
            throw new DriverManagerException(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
                    ErrorCode.INVALID_PARAMETERS);
        }
        return sysID;
    }
}
