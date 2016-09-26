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

package org.openo.drivermgr.rest.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.openo.drivermgr.service.inf.IDriverManagerDelegate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <br/>
 * <p>
 * </p>
 * 
 * @author
 * @version  
 */
@Path("/")
public class DriverMgrService {

    @Autowired
    IDriverManagerDelegate driverDelegate;

    /**
     * the getter .
     * <br/>
     * 
     * @return
     * @since  
     */
    public IDriverManagerDelegate getDriverDelegate() {
        return driverDelegate;
    }

    /**
     * the setter .
     * <br/>
     * 
     * @param driverDelegate
     * @since  
     */
    public void setDriverDelegate(IDriverManagerDelegate driverDelegate) {
        this.driverDelegate = driverDelegate;
    }

    /**
     * Register the driver info to the db. 
     * <br/>
     * 
     * @param request
     * @param response
     * @since  
     */
    @POST
    @Consumes({"application/json"})
    public void register(@Context HttpServletRequest request, @Context HttpServletResponse response) {
        driverDelegate.register(request, response);
    }

    /**
     * unregister the driver info from the DB.
     * <br/>
     * 
     * @param request
     * @param response
     * @param instanceId
     * @since  
     */
    @DELETE
    @Path("/{instanceid}")
    public void unregister(@Context HttpServletRequest request, @Context HttpServletResponse response,
            @PathParam("instanceid") String instanceId) {
        driverDelegate.unregister(request, response, instanceId);
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
     * @since  
     */
    @GET
    @Produces("application/json")
    @Consumes({"application/json"})
    public String getDriverDetails(@Context HttpServletRequest request, @Context HttpServletResponse response,
            @QueryParam("service_url") String serviceUrl, @QueryParam("X-Driver-Parameter") String systemId)
            throws IOException {
        return driverDelegate.getDriverDetails(request, response, serviceUrl, systemId);
    }

}
