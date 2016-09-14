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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openo.drivermgr.business.impl.DriverManagerImpl;
import org.openo.drivermgr.common.CommonUtil;
import org.openo.drivermgr.entity.DriverInfo;
import org.openo.drivermgr.entity.DriverInstance;
import org.openo.drivermgr.entity.DriverProperties;

import mockit.Mock;
import mockit.MockUp;

public class ServiceImplMock {
    
    static DriverProperties driverProperties = new DriverProperties();
    
    static DriverInstance driverInstance = new DriverInstance();
    
    static List<DriverInstance> driverInstancelIst = new ArrayList<DriverInstance>();
    
    
    public static List<DriverInstance> getDriverInstancelIst() {
        return driverInstancelIst;
    }

    public static DriverProperties getDriverProperties() {
        return driverProperties;
    }

    public static DriverManagerImpl mockDriverManagerImplNull() {
        return new MockUp<DriverManagerImpl>() {
            @Mock
            public DriverInstance getDriverByInstanceId(String instanceId) {
                return null;
            }
            
            @Mock
            public boolean registerDriver(DriverProperties driver) {
                return true;
            }
        }.getMockInstance();
    }
    
    public static DriverManagerImpl mockDriverManagerImplNullFalse() {
        return new MockUp<DriverManagerImpl>() {
            @Mock
            public DriverInstance getDriverByInstanceId(String instanceId) {
                return null;
            }
            
            @Mock
            public boolean registerDriver(DriverProperties driver) {
                return false;
            }
        }.getMockInstance();
    }
    
    public static DriverManagerImpl mockDriverManagerImpl() {
        DriverInfo driverInfo = new DriverInfo();
        driverInstance.setInstanceId("instanceId");
        driverInstance.setModel(CommonUtil.getInstance().driverInfoJson(driverInfo));
        driverInstancelIst.add(driverInstance);
        driverInstancelIst.add(driverInstance);
        return new MockUp<DriverManagerImpl>() {
            @Mock 
            public DriverInstance getDriverByInstanceId(String instanceId) {
                return driverInstance;
            }
            
            @Mock
            public boolean unregisterDriver(String instanceId) { 
                return true;
            }
            
            @Mock
            public String getDriverInfo(String serviceUrl, String type, String version) {
                return "driverInfo";
            }
            
            @Mock
            public List<DriverInstance> getAllDriverInstance() {
                return driverInstancelIst;
            }
            
        }.getMockInstance();
    }
    
    public static DriverManagerImpl mockDriverManagerImplFalse() {
        DriverInfo driverInfo = new DriverInfo();
        driverInstance.setInstanceId("instanceId");
        driverInstance.setModel(CommonUtil.getInstance().driverInfoJson(driverInfo));
        driverInstancelIst.add(driverInstance);
        driverInstancelIst.add(driverInstance);
        return new MockUp<DriverManagerImpl>() {
            @Mock 
            public DriverInstance getDriverByInstanceId(String instanceId) {
                return driverInstance;
            }
            
            @Mock
            public boolean unregisterDriver(String instanceId) { 
                return false;
            }
            
            @Mock
            public String getDriverInfo(String serviceUrl, String type, String version) {
                return "driverInfo";
            }
            
            @Mock
            public List<DriverInstance> getAllDriverInstance() {
                return driverInstancelIst;
            }
            
        }.getMockInstance();
    }

    public static void mockgetDriverInfo() {
        DriverInfo driverInfo = new DriverInfo();
        driverInfo.setInstanceID("id");
        driverInfo.setIp("ip");
        driverInfo.setPort("port");
        driverProperties.setDriverInfo(driverInfo);
        
        new MockUp<CommonUtil>() {
            @Mock
            public DriverProperties getDriverInfo(HttpServletRequest request) {
                return driverProperties;
            }
        };
        
    }
}
