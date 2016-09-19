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

package org.openo.drivermgr.common;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.openo.drivermgr.constant.ErrorCode;
import org.openo.drivermgr.entity.DriverInfo;
import org.openo.drivermgr.entity.DriverInstance;
import org.openo.drivermgr.entity.DriverProperties;
import org.openo.drivermgr.entity.ExtSysInfo;
import org.openo.drivermgr.exception.DriverManagerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * This class <tt>CommonUtil</tt> deals with the common utilities for the Driver Manager.
 * </p>
 * 
 * @author
 * @version  
 */
public class CommonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

    private static CommonUtil instance = new CommonUtil();

    /**
     * 
     * Constructor<br/>
     * <p>
     * </p>
     * 
     * @since   
     */
    private CommonUtil() {

    }

    /**
     * This class persists Singleton design pattern so this method return the instance of the
     * <tt> CommonUtil<tt> class.
     * <br/>
     * 
     * @return instance : Instance of the <tt>CommonUtil</tt> class.
     * 
     * @since  
     */
    public static CommonUtil getInstance() {
        return instance;
    }

    /**
     * 
     * <br/>
     * 
     * @param request
     * @return
     * @since   
     */
    public DriverProperties getDriverInfo(HttpServletRequest request) {

        try {
            LOGGER.info("getUserInfo");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(request.getInputStream(), DriverProperties.class);
        } catch(IOException e) {
            LOGGER.error("Exception Caught : " ,e);
            throw new DriverManagerException(HttpServletResponse.SC_BAD_REQUEST, ErrorCode.FAILURE_INFORMATION);
        }
    }
    
    /**
     * 
     * <br/>
     * 
     * @param responseBody
     * @return
     * @since   
     */
    public ExtSysInfo getExtSysInfo(InputStream responseBody) {
        try {
            LOGGER.info("get the ExtSysInfo.");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseBody, ExtSysInfo.class);
        } catch(IOException e) {
            LOGGER.error("Exception Caught : " ,e);
            throw new DriverManagerException(HttpServletResponse.SC_BAD_REQUEST, ErrorCode.FAILURE_INFORMATION);
        }
    }
    
    /**
     * 
     * <br/>
     * 
     * @param content
     * @return
     * @since   
     */
    public DriverInfo getDriverInfo(String content) {
        try {
            LOGGER.info("getUserInfo");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(content, DriverInfo.class);
        } catch(IOException e) {
            LOGGER.error("Exception Caught : " ,e);
            throw new DriverManagerException(HttpServletResponse.SC_BAD_REQUEST, ErrorCode.FAILURE_INFORMATION);
        }
    }

    /**
     * 
     * <br/>
     * 
     * @param driverInfo
     * @return
     * @since   
     */
    public String driverInfoJson(DriverInfo driverInfo) {

        String jsonInString = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(driverInfo);
            LOGGER.info("jsonInString : " + jsonInString);
        } catch(Exception e) {
            LOGGER.error("Exception Caught : " + e);
            throw new DriverManagerException(HttpServletResponse.SC_BAD_REQUEST, ErrorCode.FAILURE_INFORMATION);
        }
        return jsonInString;
    }
    
    /**
     * DriverInfo is converted to DriverInstance
     * 
     * @param driverInfo
     *            driver info
     * @return DriverInstance
     */
    public DriverInstance driverInfoToDriverInstance(DriverInfo driverInfo) {

        DriverInstance driverInstance = new DriverInstance();

        driverInstance.setInstanceId(driverInfo.getInstanceID());

        driverInstance.setDriverName(driverInfo.getDriverName());

        String modelJson = driverInfoJson(driverInfo);

        driverInstance.setModel(modelJson);

        driverInstance.setExtendInfo("");

        return driverInstance;
    }

}
