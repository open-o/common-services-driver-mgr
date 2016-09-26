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
 * POJO For Driver Manager Service.
 * <br/>
 * 
 * @author
 * @version  
 */
public class SupportSystem {

    private String type;

    private String version;

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

}
