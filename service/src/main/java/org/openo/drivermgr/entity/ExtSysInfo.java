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
public class ExtSysInfo {

    private String instanceId;

    private String category;

    private String name;

    private String description;

    private String version;

    private String vendor;

    private String type;

    private String createTime;
    
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
    public String getCategory() {
        return category;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * the getter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getName() {
        return name;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * the getter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getDescription() {
        return description;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * the getter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getVersion() {
        return version;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * the getter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * the getter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getType() {
        return type;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * the getter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
