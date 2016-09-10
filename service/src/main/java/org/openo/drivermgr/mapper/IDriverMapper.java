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

package org.openo.drivermgr.mapper;

import java.util.List;
import java.util.Set;

import org.openo.drivermgr.entity.DriverInstance;
import org.openo.drivermgr.entity.DriverJsonMapper;
import org.openo.drivermgr.entity.DriverProperties;
import org.openo.drivermgr.entity.DriverService;
import org.openo.drivermgr.entity.DriverServicesMapper;

/**
 * Mapper Interface exposed to perform database operations for Driver Manager.
 * <br/>
 * 
 * @author
 * @version  
 */
public interface IDriverMapper {

    /**
     * 
     * <br/>
     * 
     * @param driver
     * @return
     * @since   
     */
    boolean saveDriverJson(DriverJsonMapper driver);

    /**
     * 
     * <br/>
     * 
     * @param driver
     * @return
     * @since   
     */
    boolean saveDriverServices(List<DriverServicesMapper> driver);

    /**
     * 
     * <br/>
     * 
     * @param instanceId
     * @return
     * @since   
     */
    boolean deleteDriverJson(String instanceId);

    /**
     * 
     * <br/>
     * 
     * @param instanceId
     * @return
     * @since   
     */
    boolean deleteDriverServices(String instanceId);

    /**
     * 
     * <br/>
     * 
     * @return
     * @since   
     */
    Set<DriverProperties> getDetails();

    /**
     * 
     * <br/>
     * 
     * @param id
     * @return
     * @since   
     */
    DriverProperties getDetails(String id);

    /**
     * 
     * <br/>
     * 
     * @param dirverInstance
     * @since   
     */
    void saveDriverInstance(DriverInstance dirverInstance);

    /**
     * 
     * <br/>
     * 
     * @param driverService
     * @since   
     */
    void saveDriverService(DriverService driverService);

    /**
     * 
     * <br/>
     * 
     * @param instanceId
     * @since   
     */
    void deleteDriverInstance(String instanceId);

    /**
     * 
     * <br/>
     * 
     * @param instanceId
     * @since   
     */
    void deleteDriverService(String instanceId);

    /**
     * 
     * <br/>
     * 
     * @param instanceId
     * @return
     * @since   
     */
    DriverInstance getDriverInstance(String instanceId);

    /**
     * 
     * <br/>
     * 
     * @param serviceUrl
     * @return
     * @since   
     */
    List<DriverService> getDriverServiceByUrl(String serviceUrl);

    /**
     * 
     * <br/>
     * 
     * @return
     * @since   
     */
    List<DriverInstance> getAllDriverInstance();

}
