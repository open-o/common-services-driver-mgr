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

package org.openo.drivermgr.dao.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openo.drivermgr.entity.DriverInstance;
import org.openo.drivermgr.entity.DriverService;
import org.openo.drivermgr.exception.DriverManagerException;


public class TestDriverManagerDaoImpl {

    private DriverManagerDaoImpl impl;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSaveDriverInstance() {
        boolean status = true;
        try {
            MapperMock.mockConnectionUtil();
            impl = new DriverManagerDaoImpl();
            DriverInstance driverInstance = new DriverInstance();
            impl.saveDriverInstance(driverInstance);
        } catch (DriverManagerException ex) {
            status = false;
        }
        Assert.assertTrue(status);
    }

    @Test
    public void testSaveDriverInstanceException() {
        impl = new DriverManagerDaoImpl();
        DriverInstance dirverInstance = new DriverInstance();
        try {
            impl.saveDriverInstance(dirverInstance);
        } catch (DriverManagerException e) {
            Assert.assertEquals("HTTP 500 Internal Server Error", e.getMessage());
        }
    }

    @Test
    public void testSaveDriverService() {
        boolean status = true;
        try {
            MapperMock.mockConnectionUtil();
            impl = new DriverManagerDaoImpl();
            DriverService driverService = new DriverService();
            impl.saveDriverService(driverService);
        } catch (DriverManagerException ex) {
            status = false;
        }
        Assert.assertTrue(status);
    }

    @Test
    public void testSaveDriverServiceException() {
        try {
            impl = new DriverManagerDaoImpl();
            DriverService driverService = new DriverService();
            impl.saveDriverService(driverService);
        } catch (DriverManagerException e) {
            Assert.assertEquals("HTTP 500 Internal Server Error", e.getLocalizedMessage());
        }
    }

    @Test
    public void testDeleteDriverInstance() {
        boolean status = false;
        try {
            String instanceId = "instanceId";
            MapperMock.mockConnectionUtil();
            impl = new DriverManagerDaoImpl();
            impl.deleteDriverInstance(instanceId);
        } catch (DriverManagerException ex) {
            status = true;
        }
        Assert.assertFalse(status);
    }

    @Test
    public void testDeleteDriverInstanceException() {
        try {
            String instanceId = "instanceId";
            impl = new DriverManagerDaoImpl();
            impl.deleteDriverInstance(instanceId);
        } catch (DriverManagerException e) {
            Assert.assertEquals("HTTP 500 Internal Server Error", e.getLocalizedMessage());
        }
    }

    @Test
    public void testDeleteDriverService() {
        boolean status = false;

        try {
            String instanceId = "instanceId";
            MapperMock.mockConnectionUtil();
            impl = new DriverManagerDaoImpl();
            impl.deleteDriverService(instanceId);
        } catch (DriverManagerException ex) {
            status = true;
        }
        Assert.assertFalse(status);

    }

    @Test
    public void testDeleteDriverServiceException() {
        try {
            String instanceId = "instanceId";
            impl = new DriverManagerDaoImpl();
            impl.deleteDriverService(instanceId);
        } catch (DriverManagerException e) {
            Assert.assertEquals("HTTP 500 Internal Server Error", e.getLocalizedMessage());
        }
    }

    @Test
    public void testGetDriverByInstanceId() {
        String instanceId = "instanceId";
        MapperMock.mockConnectionUtil();
        impl = new DriverManagerDaoImpl();
        Assert.assertEquals(MapperMock.getDriverInstance(), impl.getDriverByInstanceId(instanceId));
    }

    @Test
    public void testGetDriverByInstanceIdException() {
        boolean status = false;
        String instanceId = "instanceId";
        impl = new DriverManagerDaoImpl();
        try {
            impl.getDriverByInstanceId(instanceId);
        } catch (DriverManagerException e) {
            Assert.assertEquals("HTTP 500 Internal Server Error", e.getLocalizedMessage());
            status = true;
        }
        Assert.assertTrue(status);
    }

    @Test
    public void testGetDriverServiceByUrl() {
        String serviceUrl = "serviceUrl";
        MapperMock.mockConnectionUtil();
        impl = new DriverManagerDaoImpl();
        Assert.assertEquals(MapperMock.getDriverServiceList(), impl.getDriverServiceByUrl(serviceUrl));
    }

    @Test
    public void testGetDriverServiceByUrlException() {
        String serviceUrl = "serviceUrl";
        impl = new DriverManagerDaoImpl();
        try {
            impl.getDriverServiceByUrl(serviceUrl);
        } catch (DriverManagerException e) {
            Assert.assertEquals("HTTP 500 Internal Server Error", e.getMessage());
        }
    }

    @Test
    public void testGetAllDriverInstance() {
        MapperMock.mockConnectionUtil();
        impl = new DriverManagerDaoImpl();
        Assert.assertEquals(MapperMock.getDriverServiceList(), impl.getAllDriverInstance());
    }

    @Test
    public void testGetAllDriverInstanceException() {
        impl = new DriverManagerDaoImpl();
        try {
            impl.getAllDriverInstance();
        } catch (Exception e) {
            Assert.assertEquals("HTTP 500 Internal Server Error", e.getMessage());
        }
    }
}
