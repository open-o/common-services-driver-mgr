/*
 * Copyright (c) 2016, Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
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
 * @author Shubham Verma
 * @version SDNO 0.5
 */
public class Services {

    private String serviceUrl;

    private List<SupportSystem> supportSys;

    /**
     * @return Returns the serviceUrl.
     */
    public String getServiceUrl() {
        return serviceUrl;
    }

    /**
     * @param serviceUrl The serviceUrl to set.
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
