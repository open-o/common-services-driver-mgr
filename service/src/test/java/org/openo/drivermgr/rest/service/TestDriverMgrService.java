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

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openo.drivermgr.entity.DriverUrl;
import org.openo.drivermgr.exception.DriverManagerException;
import org.openo.drivermgr.service.inf.IDriverManagerDelegate;
import org.openo.drivermgr.ut.common.CommonMock;



public class TestDriverMgrService {

    private DriverMgrService impl;

    private IDriverManagerDelegate driverDelegate;

    private HttpServletRequest request;

    private HttpServletResponse response;

    private String instanceId;

    private String serviceUrl;

    private String systemId;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        impl = new DriverMgrService();
        driverDelegate = DriverServiceMockInstance.mockDriverMgrServiceImpl();
        request = CommonMock.mockHttpServletRequest();
        response = CommonMock.mockHttpServletResponse();
        instanceId = "instanceId";
        serviceUrl = "/serviceUrl";
        systemId = "systemId";

        impl.setDriverDelegate(driverDelegate);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSetDriverDelegate() {
        impl.setDriverDelegate(driverDelegate);
        Assert.assertEquals(driverDelegate, impl.getDriverDelegate());
    }

    @Test
    public void testRegister() {
        boolean status = false;
        try {
            DriverServiceMockInstance.mockDriverMgrServiceImpl();
            impl.register(request, response);
        } catch (DriverManagerException ex) {
            status = true;
        }
        Assert.assertFalse(status);
    }

    @Test
    public void testUnregister() {
        boolean status = false;
        try {
            DriverServiceMockInstance.mockDriverMgrServiceImpl();
            impl.unregister(request, response, instanceId);
        } catch (DriverManagerException ex) {
            status = true;
        }
        Assert.assertFalse(status);
    }

    @Test
    public void testGetDriverDetails() {
        try {
            DriverServiceMockInstance.mockDriverMgrServiceImpl();
            Assert.assertEquals(new DriverUrl("special_one").getUrl(),
                    impl.getDriverDetails(request, response, serviceUrl, systemId));
        } catch (IOException e) {
        }
    }

    @Test
    public void testGetDriverDetailsException() {
        try {
            DriverServiceMockInstance.mockDriverMgrServiceImpl();
            Assert.assertEquals(impl.getDriverDetails(request, response, "", null), "special_one");
        } catch (Exception e) {
            Assert.assertEquals("HTTP 415 Unsupported Media Type", e.getMessage());
        }

    }
}
