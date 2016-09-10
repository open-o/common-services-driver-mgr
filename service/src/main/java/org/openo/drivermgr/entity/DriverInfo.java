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

import org.openo.drivermgr.common.CommonUtil;

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
     * @return Returns the driverName.
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * @param driverName The driverName to set.
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * @return Returns the instanceId.
     */
    public String getInstanceID() {
        return instanceID;
    }

    /**
     * @param instanceId The instanceId to set.
     */
    public void setInstanceID(String instanceId) {
        this.instanceID = instanceId;
    }

    /**
     * @return Returns the ip.
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip The ip to set.
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return Returns the port.
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port The port to set.
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return Returns the protocol.
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * @param protocol The protocol to set.
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * @return Returns the services.
     */
    public List<Services> getServices() {
        return services;
    }

    /**
     * @param services The services to set.
     */
    public void setServices(List<Services> services) {
        this.services = services;
    }
    

    
    /**
     * 
     * <br/>
     * 
     * @return
     * @since   
     */
    public DriverInstance toDriverInstance() {
        
        DriverInstance driverInstance = new DriverInstance();
        
        driverInstance.setInstanceId(this.getInstanceID());
        
        driverInstance.setDriverName(this.getDriverName());
        
        String modelJson = CommonUtil.getInstance().driverInfoJson(this);
        
        driverInstance.setModel(modelJson);
        
        driverInstance.setExtendInfo("");
        
        return driverInstance;
    }

}
