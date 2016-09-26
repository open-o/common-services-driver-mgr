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

package org.openo.drivermgr.entity;

import java.util.List;

/**
 * POJO For Driver Manager Service.
 * <br/>
 * 
 * @author
 * @version  
 */
public class DriverInfo {

    private String driverName;

    private String instanceID;

    private String ip;

    private String port;

    private String protocol;

    private List<Services> services;

    /**
     * the getter of the model attribute driverName.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * the setter of the model attribute driverName.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * the getter of the model attribute instanceID.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getInstanceID() {
        return instanceID;
    }

    /**
     * the setter of the model attribute instanceId.
     * <br/> 
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setInstanceID(String instanceId) {
        this.instanceID = instanceId;
    }

    /**
     * the getter of the model attribute ip. 
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getIp() {
        return ip;
    }

    /**
     * the setter of the model attribute ip.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * the getter of the model attribute port.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getPort() {
        return port;
    }

    /**
     * the setter of the model attribute port.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * the getter of the model attribute protocol.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * the setter of the model attribute protocol.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * the getter of the model attribute services.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public List<Services> getServices() {
        return services;
    }

    /**
     * the setter of the model attribute services.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setServices(List<Services> services) {
        this.services = services;
    }
}
