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

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.openo.drivermgr.dao.connection.ConnectionUtil;
import org.openo.drivermgr.dao.inf.IDriverManagerDao;
import org.openo.drivermgr.entity.DriverInstance;
import org.openo.drivermgr.entity.DriverService;
import org.openo.drivermgr.mapper.IDriverMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is the implementation for the DAO Layer for Driver Manager.
 * <br/>
 * 
 * @author
 * @version  
 */
public class DriverManagerDaoImpl implements IDriverManagerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverManagerDaoImpl.class);

    private SqlSessionFactory sqlSessionFactory = null;

    /**
     * 
     * Constructor<br/>
     * <p>
     * </p>
     * 
     * @since   
     */
    public DriverManagerDaoImpl() {
        sqlSessionFactory = ConnectionUtil.getSession();
    }

    /**
     * 
     * <br/>
     * 
     * @param dirverInstance
     * @since    
     */
    @Override
    public void saveDriverInstance(DriverInstance dirverInstance) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IDriverMapper mapper = session.getMapper(IDriverMapper.class);
            mapper.saveDriverInstance(dirverInstance);
            session.commit();
        } catch(PersistenceException e) {
            LOGGER.error("Exception caught" + e);
        } finally {
            session.close();
        }
    }
    
    /**
     * 
     * <br/>
     * 
     * @param driverService
     * @since    
     */
    @Override
    public void saveDriverService(DriverService driverService) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IDriverMapper mapper = session.getMapper(IDriverMapper.class);
            mapper.saveDriverService(driverService);
            session.commit();
        } catch(PersistenceException e) {
            LOGGER.error("Exception caught" + e);
        } finally {
            session.close();
        }
    }
    
    /**
     * 
     * <br/>
     * 
     * @param instanceId
     * @since    
     */
    @Override
    public void deleteDriverInstance(String instanceId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IDriverMapper mapper = session.getMapper(IDriverMapper.class);
            mapper.deleteDriverInstance(instanceId);
            session.commit();
        } catch(PersistenceException e) {
            LOGGER.error("Exception caught" + e);
        } finally {
            session.close();
        }
    }

    /**
     * 
     * <br/>
     * 
     * @param instanceId
     * @since    
     */
    @Override
    public void deleteDriverService(String instanceId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IDriverMapper mapper = session.getMapper(IDriverMapper.class);
            mapper.deleteDriverService(instanceId);
            session.commit();
        } catch(PersistenceException e) {
            LOGGER.error("Exception caught" + e);
        } finally {
            session.close();
        }
    }
    
    /**
     * 
     * <br/>
     * 
     * @param instanceId
     * @return
     * @since    
     */
    @Override 
    public DriverInstance getDriverByInstanceId(String instanceId) {
        SqlSession session = sqlSessionFactory.openSession();
        DriverInstance driverInstance = null; 
        try {
            IDriverMapper mapper = session.getMapper(IDriverMapper.class);
            driverInstance = mapper.getDriverInstance(instanceId);
            session.commit();
        } catch(PersistenceException e) {
            LOGGER.error("Exception caught" + e);
        } finally {
            session.close();
        }
        return driverInstance;
    }
 
    /**
     * 
     * <br/>
     * 
     * @param url
     * @return
     * @since    
     */
    @Override
    public List<DriverService> getDriverServiceByUrl(String serviceUrl) {
        SqlSession session = sqlSessionFactory.openSession();
        List<DriverService> drivers = null; 
        try {
            IDriverMapper mapper = session.getMapper(IDriverMapper.class);
            drivers = mapper.getDriverServiceByUrl(serviceUrl);
            session.commit();
        } catch(PersistenceException e) {
            LOGGER.error("Exception caught" + e);
        } finally {
            session.close();
        }
        return drivers;
    }
    
    /**
     * 
     * <br/>
     * 
     * @return
     * @since    
     */
    @Override
    public List<DriverInstance> getAllDriverInstance() {
        SqlSession session = sqlSessionFactory.openSession();
        List<DriverInstance> drivers = null; 
        try {
            IDriverMapper mapper = session.getMapper(IDriverMapper.class);
            drivers = mapper.getAllDriverInstance();
            session.commit();
        } catch(PersistenceException e) {
            LOGGER.error("Exception caught" + e);
        } finally {
            session.close();
        }
        return drivers;
    }
    
}
