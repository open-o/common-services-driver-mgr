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

package org.openo.drivermgr.dao.inf;

import java.util.List;

import org.openo.drivermgr.entity.DriverInstance;
import org.openo.drivermgr.entity.DriverService;

/**
 * DAO Layer for the Driver Manager Service.
 * <br/>
 * 
 * @author
 * @version  
 */
public interface IDriverManagerDao {

    /**
     * saving the driver instance object to the DB using the mybaties.
     * <br/>
     * 
     * @param dirverInstance
     * @since   
     */
    void saveDriverInstance(DriverInstance dirverInstance);

    /**
     * saving the driver service object to the DB using the mybaties.
     * <br/>
     * 
     * @param driverService
     * @since   
     */
    void saveDriverService(DriverService driverService);

    /**
     * delete the driver instance object from the DB 
     * <br/>
     * 
     * @param instanceId
     * @since   
     */
    void deleteDriverInstance(String instanceId);

    /**
     * delete the driver service by instanceid 
     * <br/>
     * 
     * @param instanceId
     * @since   
     */
    void deleteDriverService(String instanceId);

    /**
     * get the driver instance object by the instanceId.
     * <br/>
     * 
     * @param instanceId
     * @return
     * @since   
     */
    DriverInstance getDriverByInstanceId(String instanceId);

    /**
     * get the driver service object by the serviceUrl
     * <br/>
     * 
     * @param serviceUrl
     * @return
     * @since   
     */
    List<DriverService> getDriverServiceByUrl(String serviceUrl);

    /**
     * get all driver instance.
     * <br/>
     * 
     * @return
     * @since   
     */
    List<DriverInstance> getAllDriverInstance();

}
