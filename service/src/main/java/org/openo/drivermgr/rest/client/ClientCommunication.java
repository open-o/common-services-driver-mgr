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

package org.openo.drivermgr.rest.client;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.openo.drivermgr.common.CommonUtil;
import org.openo.drivermgr.constant.Constant;
import org.openo.drivermgr.constant.ErrorCode;
import org.openo.drivermgr.entity.ExtSysInfo;
import org.openo.drivermgr.exception.DriverManagerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class holds the responsibility for connecting the web services to the out sided world which
 * is needed for the driver manager.
 * <br/>
 *
 * @author
 * @version  
 */
public class ClientCommunication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientCommunication.class);

    private static ClientCommunication instance = new ClientCommunication();

    /**
     * 
     * Constructor<br/>
     * <p>
     * </p>
     * 
     * @since   
     */
    private ClientCommunication() {
    }

    /**
     * Singleton Class, returns the instance of <tt>TokenServiceClient</tt>
     * <br/>
     * 
     * @return instance : Returns the instance of <tt>TokenServiceClient</tt>
     * @since  
     */
    public static ClientCommunication getInstance() {
        return instance;
    }
    
    /**
     * get the extra system information from the id.
     * <br/>
     * 
     * @param id
     * @return
     * @since   
     */
    public ExtSysInfo getExtSysInfo(String id) {
        return getExtSysInfoFromLocal(id);
    }
    
    /**
     * initial the web client.
     * <br/>
     * 
     * @return
     * @since   
     */
    private WebClient initializeClient() {

        final List<Object> providers = new ArrayList<Object>();

        JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();

        providers.add(jacksonJsonProvider);

        LOGGER.info("Connecting Client ...");

        return WebClient.create("http://msb.openo.org:80", providers);
    }
    
    /**
     * get the extsys info.
     * <br/>
     * 
     * @param id
     * @return
     * @since   
     */
    public ExtSysInfo getExtSysInfoFromZTE(String id) {
      WebClient client = initializeClient();
      Response userResponse = null;
      
      if(null != client) { 
          
          client.type(Constant.MEDIA_TYPE_JSON);
          client.accept(Constant.MEDIA_TYPE_JSON);
          client.path(Constant.EXT_SYS_URL + id);
          
          LOGGER.info("Current URI -> " + client.getCurrentURI());
          
          try {
              userResponse = client.get();
          } catch(Exception e) {
              LOGGER.error("Exception Caught while connecting client ... " + e);
              throw new DriverManagerException(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, ErrorCode.COMMUNICATION_ERROR);
          }
      } else {
          LOGGER.error("Exception Caught while connecting client as client returned null ... ");
          throw new DriverManagerException(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, ErrorCode.COMMUNICATION_ERROR);
      }

      InputStream responseBody = (InputStream)userResponse.getEntity();
      return CommonUtil.getInstance().getExtSysInfo(responseBody);
    }
    
    /**
     * get the extsys info form the local. 
     * <br/>
     * 
     * @param id
     * @return
     * @since   
     */
    public static ExtSysInfo getExtSysInfoFromLocal(String id) {
        // test code.
        ExtSysInfo ext = new ExtSysInfo();
        String[] typeVersion = id.split(",");
        ext.setType(typeVersion[0]);
        ext.setVersion(typeVersion[1]);
        return ext;
    }
}
