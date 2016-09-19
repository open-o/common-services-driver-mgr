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

package org.openo.drivermgr.business.impl;

import java.util.List;

import org.openo.drivermgr.business.inf.IDriverManager;
import org.openo.drivermgr.common.CommonUtil;
import org.openo.drivermgr.constant.Constant;
import org.openo.drivermgr.dao.inf.IDriverManagerDao;
import org.openo.drivermgr.entity.DriverInfo;
import org.openo.drivermgr.entity.DriverInstance;
import org.openo.drivermgr.entity.DriverProperties;
import org.openo.drivermgr.entity.DriverService;
import org.openo.drivermgr.entity.Services;
import org.openo.drivermgr.entity.SupportSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class will take care of the managerial operations for the DriverManager Service.
 * <br/>
 * 
 * @author
 * @version  
 */
public class DriverManagerImpl implements IDriverManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverManagerImpl.class);

    private static final int MAX_URL_MATCH_LENGTH = 3;

    private static final String URL_SEPARATOR = "/";

    @Autowired
    IDriverManagerDao driverManagerDao;

    /**
     * @return Returns the driverManagerDao.
     */
    public IDriverManagerDao getDriverManagerDao() {
        return driverManagerDao;
    }

    /**
     * @param driverManagerDao The driverManagerDao to set.
     */
    public void setDriverManagerDao(IDriverManagerDao driverManagerDao) {
        this.driverManagerDao = driverManagerDao;
    }

    /**
     * <br/>
     * 
     * @param driver
     * @return
     * @since
     */
    @Override
    public boolean registerDriver(DriverProperties driver) {

        LOGGER.info("Register Driver");

        String instanceId = driver.getDriverInfo().getInstanceID();

        DriverInstance dirverInstance = CommonUtil.getInstance().driverInfoToDriverInstance(driver.getDriverInfo());

        driverManagerDao.saveDriverInstance(dirverInstance);

        List<Services> services = driver.getDriverInfo().getServices();

        for (Services item : services) {
            driverManagerDao.saveDriverService(new DriverService(item.getServiceUrl(), instanceId, ""));
        }
        return true;
    }

    /**
     * <br/>
     * 
     * @param id
     * @return
     * @since  
     */
    @Override
    public boolean unregisterDriver(String instanceId) {

        driverManagerDao.deleteDriverInstance(instanceId);

        driverManagerDao.deleteDriverService(instanceId);

        return true;
    }

    /**
     * <br/>
     * 
     * @param instanceId
     * @return
     * @since  
     */
    @Override
    public DriverInstance getDriverByInstanceId(String instanceId) {
        return driverManagerDao.getDriverByInstanceId(instanceId);
    }

    /**
     * <br/>
     * 
     * @param serviceUrl
     * @param type
     * @param version
     * @return
     * @since  
     */
    @Override
    public String getDriverInfo(String serviceUrl, String type, String version) {
        
        String matchUrl = getFirstTreePath(serviceUrl);

        List<DriverService> drivers = driverManagerDao.getDriverServiceByUrl(matchUrl);

        DriverInfo goalDriverInfo = null;

        for(DriverService driver : drivers) {

            String instanceId = driver.getInstanceId();

            DriverInstance driverInstance = driverManagerDao.getDriverByInstanceId(instanceId);

            DriverInfo driverInfo = CommonUtil.getInstance().getDriverInfo(driverInstance.getModel());

            List<Services> services = driverInfo.getServices();

            for(Services service : services) {
                List<SupportSystem> systems = service.getSupportSys();
                for(SupportSystem system : systems) {
                    if(system.getType().equalsIgnoreCase(type) && system.getVersion().equalsIgnoreCase(version)) {
                        goalDriverInfo = driverInfo;
                        break;
                    }
                }
                if (goalDriverInfo != null) {
                    break;
                }
            }
            if (goalDriverInfo != null) {
                break;
            }
        }

        if(null != goalDriverInfo) {
            return goalDriverInfo.getProtocol() + Constant.HTTP_SEPARATOR + goalDriverInfo.getIp()
                    + Constant.PORT_SEPARATOR + goalDriverInfo.getPort() + serviceUrl;
        }

        return "";
    }

    /**
     * 
     * <br/>
     * 
     * @return
     * @since    
     */
    @Override
    public List<DriverInstance> getAllDriverInstance() {
        return driverManagerDao.getAllDriverInstance();
    }

    /**
     * 
     * <br/>
     * 
     * @param serviceUrl
     * @return
     * @since   
     */
    private String getFirstTreePath(String serviceUrl) {
        String[] stringGroup = serviceUrl.split(URL_SEPARATOR);
        if (!serviceUrl.startsWith(URL_SEPARATOR)) {
            if (stringGroup.length <= MAX_URL_MATCH_LENGTH) {
                return serviceUrl;
            } else {
                return stringGroup[0] + URL_SEPARATOR + stringGroup[1] + URL_SEPARATOR + stringGroup[2];
            }
        } else {
            if (stringGroup.length <= MAX_URL_MATCH_LENGTH + 1) {
                return serviceUrl;
            } else {
                return stringGroup[0] + URL_SEPARATOR + stringGroup[1] + URL_SEPARATOR + stringGroup[2] + URL_SEPARATOR + stringGroup[3];
            } 
        }
    }
}
