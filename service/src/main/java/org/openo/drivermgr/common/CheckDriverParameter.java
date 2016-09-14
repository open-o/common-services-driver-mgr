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

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.openo.drivermgr.constant.ErrorCode;
import org.openo.drivermgr.entity.DriverInfo;
import org.openo.drivermgr.exception.DriverManagerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <br/>
 * <p>
 * </p>
 * 
 * @author
 * @version   
 */
public class CheckDriverParameter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckDriverParameter.class);

    private static CheckDriverParameter instance = new CheckDriverParameter();

    /**
     * 
     * Constructor<br/>
     * <p>
     * </p>
     * 
     * @since   
     */
    private CheckDriverParameter() {

    }
    
    /**
     * 
     * <br/>
     * 
     * @return
     * @since   
     */
    public static CheckDriverParameter getInstance() {
        return instance;
    }
    
    /**
     * 
     * <br/>
     * 
     * @param driver
     * @since   
     */
    public void checkParameter(DriverInfo driver) {
        checkIpNotNull(driver.getIp());
        checkPortNotNull(driver.getPort());
    }

    /**
     * 
     * <br/>
     * 
     * @param port
     * @since   
     */
    private void checkPortNotNull(String port) {
        if(StringUtils.isBlank(port)) {
            LOGGER.error("The port is illeagl");
            throw new DriverManagerException(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
                    ErrorCode.INVALIDAT_PARAMETERS);
        }
    }

    /**
     * 
     * <br/>
     * 
     * @param ip
     * @since   
     */
    private void checkIpNotNull(String ip) {
        if(StringUtils.isBlank(ip)) {
            LOGGER.error("The ip is illeagl");
            throw new DriverManagerException(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
                    ErrorCode.INVALIDAT_PARAMETERS);
        }
    }
    
}
