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

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.openo.drivermgr.dao.connection.ConnectionUtil;
import org.openo.drivermgr.entity.DriverInstance;
import org.openo.drivermgr.entity.DriverService;
import org.openo.drivermgr.mapper.IDriverMapper;

import mockit.Mock;
import mockit.MockUp;

public class MapperMock {

    private static DriverInstance driverInstance = new DriverInstance();

    private static List<DriverService> driverServiceList = new ArrayList<DriverService>();

    private static List<DriverInstance> driverInstanceList = new ArrayList<DriverInstance>();

    public List<DriverInstance> getDriverInstanceList() {
        return driverInstanceList;
    }

    public static List<DriverService> getDriverServiceList() {
        return driverServiceList;
    }

    public static DriverInstance getDriverInstance() {
        return driverInstance;
    }

    public static void mockIDriverMapper() {

        new MockUp<IDriverMapper>() {

            @Mock
            public void saveDriverInstance(DriverInstance dirverInstance) {
                return;
            }
        };
    }

    public static void mockConnectionUtil() {
        new MockUp<ConnectionUtil>() {

            @Mock
            public SqlSessionFactory getSession() {
                return new MockUp<SqlSessionFactory>() {

                    @Mock
                    public SqlSession openSession() {
                        return new MockUp<SqlSession>() {

                            @Mock
                            public <T> IDriverMapper getMapper(Class<T> type) {
                                return new MockUp<IDriverMapper>() {

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
                                    public DriverInstance getDriverInstance(String instanceId) {
                                        return driverInstance;
                                    }

                                    @Mock
                                    public List<DriverService> getDriverServiceByUrl(String serviceUrl) {
                                        return driverServiceList;
                                    }

                                    @Mock
                                    public List<DriverInstance> getAllDriverInstance() {
                                        return driverInstanceList;
                                    }
                                }.getMockInstance();
                            }
                        }.getMockInstance();
                    }
                }.getMockInstance();
            }
        };
    }

}
