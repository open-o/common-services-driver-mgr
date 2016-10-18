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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.openo.drivermgr.entity.DriverInfo;
import org.openo.drivermgr.service.impl.DriverMgrServiceImpl;
import org.openo.drivermgr.service.inf.IDriverManagerDelegate;

import mockit.Mock;
import mockit.MockUp;

public class DriverServiceMockInstance {

    private static DriverInfo dirverInfo = new DriverInfo();

    private static List<DriverInfo> driverInfoList = new ArrayList<DriverInfo>();

    public static DriverInfo getDirverInfo() {
        return dirverInfo;
    }

    public static List<DriverInfo> getDriverInfoList() {
        return driverInfoList;
    }

    public static IDriverManagerDelegate mockDriverMgrServiceImpl() {

        return new MockUp<DriverMgrServiceImpl>() {

            @Mock
            public void register(HttpServletRequest request, HttpServletResponse response) {
                return;
            }

            @Mock
            public void unregister(@Context HttpServletRequest request, @Context HttpServletResponse response,
                    @PathParam("instanceid") String instanceId) {
                return;
            }

            @Mock
            private String getDriverDetail(HttpServletRequest request, HttpServletResponse response, String serviceUrl,
                    String systemId) {
                return "special_one";
            }

            @Mock
            private List<DriverInfo> getDriverDetails(HttpServletRequest request, HttpServletResponse response) {
                return driverInfoList;
            }

            @Mock
            public String getDriverDetails(HttpServletRequest request, HttpServletResponse response, String serviceUrl,
                    String systemId) {
                return "special_one";
            }

        }.getMockInstance();
    }

}
