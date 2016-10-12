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
import org.junit.Before;
import org.junit.Test;
import org.openo.drivermgr.entity.DriverInstance;
import org.openo.drivermgr.entity.DriverService;
import org.openo.drivermgr.exception.DriverManagerException;

import junit.framework.Assert;

public class TestDriverManagerDaoImpl {
    
    DriverManagerDaoImpl impl;
    
    @Before
    public void setUp() throws Exception { 
    }

    @After
    public void tearDown() throws Exception {
        
    }
    
    @Test
    public void testsaveDriverInstance() {
        MapperMock.mockConnectionUtil();
        impl = new DriverManagerDaoImpl();
        DriverInstance dirverInstance = new DriverInstance();
        impl.saveDriverInstance(dirverInstance );
    }
    
    @Test
    public void testsaveDriverInstanceException() {
        impl = new DriverManagerDaoImpl();
        DriverInstance dirverInstance = new DriverInstance();
        try {
            impl.saveDriverInstance(dirverInstance );
        } catch(DriverManagerException e) {
            Assert.assertEquals("HTTP 500 Internal Server Error", e.getMessage());
        }
    }
    
    @Test
    public void testsaveDriverService() {
        MapperMock.mockConnectionUtil();
        impl = new DriverManagerDaoImpl();
        DriverService driverService = new DriverService();
        impl.saveDriverService(driverService );
    }
    
    @Test
    public void testsaveDriverServiceException() {
        impl = new DriverManagerDaoImpl();
        DriverService driverService = new DriverService();
        impl.saveDriverService(driverService );
    }
    
    @Test
    public void testdeleteDriverInstance() {
        String instanceId = "instanceId";
        MapperMock.mockConnectionUtil();
        impl = new DriverManagerDaoImpl();
        impl.deleteDriverInstance(instanceId );
    }
    
    @Test
    public void testdeleteDriverInstanceException() {
        String instanceId = "instanceId";
        impl = new DriverManagerDaoImpl();
        impl.deleteDriverInstance(instanceId );
    }
    
    @Test
    public void testdeleteDriverService() {
        String instanceId = "instanceId";
        MapperMock.mockConnectionUtil();
        impl = new DriverManagerDaoImpl();
        impl.deleteDriverService(instanceId);
    }

    @Test
    public void testdeleteDriverServiceException() {
        String instanceId = "instanceId";
        impl = new DriverManagerDaoImpl();
        impl.deleteDriverService(instanceId);
    }
    
    @Test
    public void testgetDriverByInstanceId() {
        String instanceId = "instanceId";
        MapperMock.mockConnectionUtil();
        impl = new DriverManagerDaoImpl();
        Assert.assertEquals(MapperMock.getDriverInstance(), impl.getDriverByInstanceId(instanceId));
    }
    
    @Test
    public void testgetDriverByInstanceIdException() {
        String instanceId = "instanceId";
        impl = new DriverManagerDaoImpl();
        try {
            impl.getDriverByInstanceId(instanceId);
        } catch(DriverManagerException e) {
            Assert.assertEquals("HTTP 500 Internal Server Error", e.getLocalizedMessage());
        }
    }
    
    @Test
    public void testgetDriverServiceByUrl() {
        String serviceUrl = "serviceUrl";
        MapperMock.mockConnectionUtil();
        impl = new DriverManagerDaoImpl();
        Assert.assertEquals(MapperMock.getDriverServiceList(), impl.getDriverServiceByUrl(serviceUrl));
    }
    
    @Test
    public void testgetDriverServiceByUrlException() {
        String serviceUrl = "serviceUrl";
        impl = new DriverManagerDaoImpl();
        impl.getDriverServiceByUrl(serviceUrl);
    }
    
    @Test
    public void testgetAllDriverInstance() {
        String serviceUrl = "serviceUrl";
        MapperMock.mockConnectionUtil();
        impl = new DriverManagerDaoImpl();
        Assert.assertEquals(MapperMock.getDriverServiceList(), impl.getAllDriverInstance());
    }

    @Test
    public void testgetAllDriverInstanceException() {
        String serviceUrl = "serviceUrl";
        impl = new DriverManagerDaoImpl();
        impl.getAllDriverInstance();
    }
}
