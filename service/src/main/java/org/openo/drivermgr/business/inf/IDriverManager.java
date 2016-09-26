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

package org.openo.drivermgr.business.inf;

import java.util.List;

import org.openo.drivermgr.entity.DriverInstance;
import org.openo.drivermgr.entity.DriverProperties;

/**
 * An interface layer for the manager implementation of Manager Layer.
 * <br/>
 * 
 * @author
 * @version  
 */
public interface IDriverManager {

    /**
     * the register driver interface.
     * <br/>
     * 
     * @param driver
     * @return
     * @since   
     */
    boolean registerDriver(DriverProperties driver);

    /**
     * the unregister driver interface.
     * <br/>
     * 
     * @param id
     * @return
     * @since   
     */
    boolean unregisterDriver(String id);

    /**
     * get the driver instace by the instaceid.
     * <br/>
     * 
     * @param instanceId
     * @return
     * @since   
     */
    Object getDriverByInstanceId(String instanceId);

    /**
     * get the full url mathc the url,type, and version.
     * <br/>
     * 
     * @param serviceUrl
     * @param type
     * @param version
     * @return
     * @since   
     */
    String getDriverInfo(String serviceUrl, String type, String version);

    /**
     * get all the driver info , and return a list.
     * <br/>
     * 
     * @return
     * @since   
     */
    List<DriverInstance> getAllDriverInstance();
}
