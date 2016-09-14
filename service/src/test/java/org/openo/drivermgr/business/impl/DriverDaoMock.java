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

import org.openo.drivermgr.common.CommonUtil;
import org.openo.drivermgr.dao.impl.DriverManagerDaoImpl;
import org.openo.drivermgr.entity.DriverInfo;
import org.openo.drivermgr.entity.DriverInstance;
import org.openo.drivermgr.entity.DriverService;
import org.openo.drivermgr.entity.Services;
import org.openo.drivermgr.entity.SupportSystem;

import mockit.Mock;
import mockit.MockUp;

public class DriverDaoMock {
    
    private static DriverInstance driverInstance = new DriverInstance();

    private static List<DriverService> driverServiceList = new ArrayList<DriverService>();

    static List<DriverInstance> driverInstanceLIst = new ArrayList<DriverInstance>();
    
    public static List<DriverInstance> getDriverInstanceLIst() {
        return driverInstanceLIst;
    }

    private static DriverService driverService = new DriverService();

    static DriverInfo driverInfo = new DriverInfo();
    
    public static DriverInstance getDriverInstance() {
        return driverInstance;
    }

    public static DriverManagerDaoImpl mockDriverManagerDaoImpl() {
        
        return new MockUp<DriverManagerDaoImpl>() {
            
            @Mock
            public void saveDriverInstance(DriverInstance dirverInstance) {
                return;
            }
            
            @Mock
            public void saveDriverService(DriverService driverService) {
                return;
            }
            
            @Mock
            public void deleteDriverInstance(String instanceId) {
                return;
            }
            
            @Mock
            public void deleteDriverService(String instanceId) {
                return;
            }
            
            @Mock
            public List<DriverInstance> getAllDriverInstance() {
                return driverInstanceLIst;
            }
            
            @Mock
            public DriverInstance getDriverByInstanceId(String instanceId) {
                
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
                
                driverInfo.setInstanceID("instanceID");
                driverInfo.setServices(services);
                driverInfo.setIp("ip");
                driverInfo.setPort("port");
                driverInfo.setProtocol("http");
                
                driverInstance.setModel(CommonUtil.getInstance().driverInfoJson(driverInfo));
                return driverInstance;
            }
            
            @Mock
            public List<DriverService> getDriverServiceByUrl(String serviceUrl) {
                driverService.setInstanceId("instanceId");
                driverServiceList.add(driverService);
                return driverServiceList;
            }
        }.getMockInstance();
    }

}
