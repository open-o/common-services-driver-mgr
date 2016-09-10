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
     * @return Returns the serviceUrl.
     */
    public String getServiceUrl() {
        return serviceUrl;
    }

    /**
     * 
     * <br/>
     * 
     * @param serviceUrl
     * @since   
     */
    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    /**
     * @return Returns the supportSys.
     */
    public List<SupportSystem> getSupportSys() {
        return supportSys;
    }

    /**
     * @param supportSys The supportSys to set.
     */
    public void setSupportSys(List<SupportSystem> supportSys) {
        this.supportSys = supportSys;
    }

}
