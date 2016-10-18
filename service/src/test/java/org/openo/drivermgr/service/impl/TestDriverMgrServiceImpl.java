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

package org.openo.drivermgr.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openo.drivermgr.business.inf.IDriverManager;
import org.openo.drivermgr.ut.common.CommonMock;

import mockit.Deencapsulation;

public class TestDriverMgrServiceImpl {

    private IDriverManager driverManager;

    private DriverMgrServiceImpl impl;

    private HttpServletRequest request;

    private HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        impl = new DriverMgrServiceImpl();
        request = CommonMock.mockHttpServletRequest();
        response = CommonMock.mockHttpServletResponse();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetDriverManager() {
        impl.setDriverManager(driverManager);
        Assert.assertEquals(driverManager, impl.getDriverManager());
    }

    @Test
    public void testRegister() {
        boolean status = false;
        ServiceImplMock.mockgetDriverInfo();
        try {
            driverManager = ServiceImplMock.mockDriverManagerImplNull();
            impl.setDriverManager(driverManager);
            impl.register(request, response);
        } catch (Exception e) {
            status = true;
        }
        Assert.assertFalse(status);
    }

    @Test
    public void testRegisterExceptionUnsupportedMedia() {
        ServiceImplMock.mockgetDriverInfo();
        try {
            driverManager = ServiceImplMock.mockDriverManagerImpl();
            impl.setDriverManager(driverManager);
            impl.register(request, response);
        } catch (Exception e) {
            Assert.assertEquals("HTTP 415 Unsupported Media Type", e.getMessage());
        }
    }

    @Test
    public void testRegisterExceptionForbidden() {
        ServiceImplMock.mockgetDriverInfo();
        try {
            driverManager = ServiceImplMock.mockDriverManagerImplNullFalse();
            impl.setDriverManager(driverManager);
            impl.register(request, response);
        } catch (Exception e) {
            Assert.assertEquals("HTTP 403 Forbidden", e.getMessage());
        }
    }

    @Test
    public void testUnregister() {
        boolean status = false;
        try {
            driverManager = ServiceImplMock.mockDriverManagerImpl();
            impl.setDriverManager(driverManager);
            impl.unregister(request, response, "instanceId");
        } catch (Exception e) {
            status = true;
        }
        Assert.assertFalse(status);
    }

    @Test
    public void testUnregisterExceptionForbidden() {
        try {
            driverManager = ServiceImplMock.mockDriverManagerImplFalse();
            impl.setDriverManager(driverManager);
            impl.unregister(request, response, "instanceId");
        } catch (Exception e) {
            Assert.assertEquals("HTTP 403 Forbidden", e.getMessage());
        }
    }

    @Test
    public void testUnregisterException() {
        boolean status = false;
        try {
            driverManager = ServiceImplMock.mockDriverManagerImplFalse();
            impl.setDriverManager(driverManager);
            impl.unregister(request, response, "instanceId");
        } catch (Exception e) {
            status = true;
        }
        Assert.assertTrue(status);
    }

    @Test
    public void testGetDriverDetails() {
        ServiceImplMock.mockgetDriverInfo();
        try {
            driverManager = ServiceImplMock.mockDriverManagerImpl();
            impl.setDriverManager(driverManager);
            Assert.assertEquals("driverInfo", impl.getDriverDetails(request, response, "serviceUrl", "type,version"));
            ;
        } catch (Exception e) {
        }
    }

    @Test
    public void testGetAllDriverInfo() {
        ServiceImplMock.mockgetDriverInfo();
        try {
            driverManager = ServiceImplMock.mockDriverManagerImpl();
            impl.setDriverManager(driverManager);
            Assert.assertNotNull(Deencapsulation.invoke(impl, "getDriverDetails", request, response));
        } catch (Exception e) {
        }
    }

}
