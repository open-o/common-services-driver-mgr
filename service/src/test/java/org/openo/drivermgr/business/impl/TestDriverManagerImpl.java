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

package org.openo.drivermgr.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openo.drivermgr.dao.inf.IDriverManagerDao;
import org.openo.drivermgr.entity.DriverInfo;
import org.openo.drivermgr.entity.DriverProperties;
import org.openo.drivermgr.entity.Services;
import org.openo.drivermgr.entity.SupportSystem;

public class TestDriverManagerImpl {

    private DriverManagerImpl impl;

    private IDriverManagerDao driverManagerDao;

    @Before
    public void setUp() throws Exception {
        impl = new DriverManagerImpl();
        driverManagerDao = DriverDaoMock.mockDriverManagerDaoImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetDriverManagerDao() {
        impl.setDriverManagerDao(driverManagerDao);
        Assert.assertEquals(driverManagerDao, impl.getDriverManagerDao());
    }

    @Test
    public void testRegisterDriver() {

        driverManagerDao = DriverDaoMock.mockDriverManagerDaoImpl();
        impl.setDriverManagerDao(driverManagerDao);

        SupportSystem supportsys = new SupportSystem();
        supportsys.setType("type");
        supportsys.setVersion("version");

        List<SupportSystem> supportSys = new ArrayList<SupportSystem>();
        supportSys.add(supportsys);

        Services service = new Services();
        service.setServiceUrl("url");
        service.setSupportSys(supportSys);

        List<Services> services = new ArrayList<Services>();
        services.add(service);

        DriverInfo driverInfo = new DriverInfo();
        driverInfo.setInstanceID("instanceID");
        driverInfo.setServices(services);

        DriverProperties driver = new DriverProperties();
        driver.setDriverInfo(driverInfo);

        Assert.assertEquals(true, impl.registerDriver(driver));

    }

    @Test
    public void testUnregisterDriver() {

        driverManagerDao = DriverDaoMock.mockDriverManagerDaoImpl();
        impl.setDriverManagerDao(driverManagerDao);

        Assert.assertEquals(true, impl.unregisterDriver("instanceId"));
    }

    @Test
    public void testGetDriverByInstanceId() {

        driverManagerDao = DriverDaoMock.mockDriverManagerDaoImpl();
        impl.setDriverManagerDao(driverManagerDao);

        Assert.assertEquals(DriverDaoMock.getDriverInstance(), impl.getDriverByInstanceId("instanceId"));
    }

    @Test
    public void testGetDriverInfo() {

        driverManagerDao = DriverDaoMock.mockDriverManagerDaoImpl();
        impl.setDriverManagerDao(driverManagerDao);
        String url = "/openoapi/test/v1/test1";
        String fullUrl = "http://ip:port" + url;

        Assert.assertEquals(fullUrl, impl.getDriverInfo(url, "type", "version"));
    }

    @Test
    public void testGetDriverInfoNoBeginThree() {

        driverManagerDao = DriverDaoMock.mockDriverManagerDaoImpl();
        impl.setDriverManagerDao(driverManagerDao);
        String url = "openoapi/test/v1/test1";
        String fullUrl = "http://ip:port" + url;

        Assert.assertEquals(fullUrl, impl.getDriverInfo(url, "type", "version"));
    }

    @Test
    public void testGetDriverInfoTwoOne() {

        driverManagerDao = DriverDaoMock.mockDriverManagerDaoImpl();
        impl.setDriverManagerDao(driverManagerDao);
        String url = "/openoapi/test";
        String fullUrl = "http://ip:port" + url;

        Assert.assertEquals(fullUrl, impl.getDriverInfo(url, "type", "version"));
    }

    @Test
    public void testGetDriverInfoNoBeginTwoUrl() {

        driverManagerDao = DriverDaoMock.mockDriverManagerDaoImpl();
        impl.setDriverManagerDao(driverManagerDao);
        String url = "openoapi/test";
        String fullUrl = "http://ip:port" + url;

        Assert.assertEquals(fullUrl, impl.getDriverInfo(url, "type", "version"));
    }

    @Test
    public void testGetAllDriverInstance() {

        driverManagerDao = DriverDaoMock.mockDriverManagerDaoImpl();
        impl.setDriverManagerDao(driverManagerDao);

        Assert.assertEquals(DriverDaoMock.getDriverInstanceLIst(), impl.getAllDriverInstance());
    }

}
