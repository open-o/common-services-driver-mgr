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

/**
 * 
 * <br/>
 * <p>
 * </p>
 * 
 * @author
 * @version   
 */
public class DriverInstance {

    private String instanceId;
    
    private String driverName;
    
    private String model;
    
    private String extendInfo;

    /**
     * the getter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * the getter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * the getter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getModel() {
        return model;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * the getter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getExtendInfo() {
        return extendInfo;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setExtendInfo(String extendInfo) {
        this.extendInfo = extendInfo;
    }
}
