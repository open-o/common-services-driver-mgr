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

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * POJO For Driver Manager Service.
 * <br/>
 * 
 * @author
 * @version  
 */
public class Services {

    @JsonProperty("service_url")
    private String serviceUrl;

    @JsonProperty("support_sys")
    private List<SupportSystem> supportSys;

    /**
     * the getter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public String getServiceUrl() {
        return serviceUrl;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    /**
     * the getter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public List<SupportSystem> getSupportSys() {
        return supportSys;
    }

    /**
     * the setter of the model attribute.
     * <br/>
     * 
     * @return
     * @since  SDNO 0.5
     */
    public void setSupportSys(List<SupportSystem> supportSys) {
        this.supportSys = supportSys;
    }

}
