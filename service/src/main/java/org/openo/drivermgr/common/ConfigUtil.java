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

package org.openo.drivermgr.common;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.openo.drivermgr.constant.Constant;
import org.openo.drivermgr.constant.ErrorCode;
import org.openo.drivermgr.entity.Configuration;
import org.openo.drivermgr.exception.DriverManagerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class <tt>ConfigUtil<tt> deals with the functionality of loading the
 * configuration for the service for Driver Manager <br/>
 * 
 * 
 * <blockquote>
 * 
 * <pre>
 * Example :
 * IP=1.1.1.1 - IP Address where MSB needs to be configured.
 * </blockquote>
 * </pre>
 * 
 * @author
 * @version
 */
public class ConfigUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigUtil.class);

    /**
     * Constructor<br/>
     * <p>
     * </p>
     * 
     * @since
     */
    private ConfigUtil() {
    }

    /**
     * This api loads the service configuration for the driver manager service. <br/>
     * 
     * @return conf : Instance of <tt> Configuration </tt> class, which holds
     *         the configuration values provided by user in the
     *         <tt> auth_service.properties </tt>/
     * @since
     */
    private static Configuration loadConfigProperties() {

        Configuration conf = new Configuration();

        LOGGER.info("Loading... " + Constant.DRIVER_MGR_PROPERTIES);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        Properties properties = new Properties();

        try {

            properties.load(classLoader.getResourceAsStream(Constant.DRIVER_MGR_PROPERTIES));

        } catch (IOException e) {

            LOGGER.error("Exception Caught : " + e);
            throw new DriverManagerException(HttpServletResponse.SC_BAD_REQUEST, ErrorCode.DRIVER_LOAD_FAILED);

        }

        conf.setIpAddr(properties.getProperty(Constant.DRIVER_MGR_IP));

        conf.setPort(properties.getProperty(Constant.DRIVER_MGR_PORT));

        return conf;
    }

    public static String createBaseURL() {
        
        Configuration config = loadConfigProperties();

        String ip = config.getIpAddr();

        String port = config.getPort();

        LOGGER.info("ip = " + ip + " port = " + port);
        
        return "http://" + ip + ":" + port;
    }

}
