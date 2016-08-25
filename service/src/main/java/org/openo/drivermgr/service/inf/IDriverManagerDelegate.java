/*
 * Copyright (c) 2016, Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
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
import javax.ws.rs.core.Response;

/**
 * Interfaces to operated for Driver Manager.
 * <br/>
 * 
 * @author Shubham Verma
 * @version SDNO 0.5
 */
public interface IDriverManagerDelegate {

    void register(HttpServletRequest request, HttpServletResponse response);

    void unregister(HttpServletRequest request, HttpServletResponse response, String instanceId);

    Response getDriverDetails(HttpServletRequest request, HttpServletResponse response);
}
