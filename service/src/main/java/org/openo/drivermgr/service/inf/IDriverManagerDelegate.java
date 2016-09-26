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

package org.openo.drivermgr.service.inf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Interfaces to operated for Driver Manager.
 * <br/>
 * 
 * @author
 * @version  
 */
public interface IDriverManagerDelegate {

    /**
     * register the driver info to the driver management.
     * <br/>
     * 
     * @param request
     * @param response
     * @since   
     */
    void register(HttpServletRequest request, HttpServletResponse response);

    /**
     * unregister the driver info from the driver management.
     * <br/>
     * 
     * @param request
     * @param response
     * @param instanceId
     * @since   
     */
    void unregister(HttpServletRequest request, HttpServletResponse response, String instanceId);

    /**
     * get the driver info from the management.
     * <br/>
     * 
     * @param request
     * @param response
     * @param serviceUrl
     * @param systemId
     * @return
     * @since   
     */
    String getDriverDetails(HttpServletRequest request, HttpServletResponse response, String serviceUrl,
            String systemId);
}
