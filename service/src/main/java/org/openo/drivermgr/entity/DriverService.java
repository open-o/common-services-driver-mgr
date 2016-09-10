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
 * <br/>
 * <p>
 * </p>
 * 
 * @author
 * @version  
 */
public class DriverService {

    private String serviceUrl;

    private String instanceId;

    private String extendInfo;

    /**
     * Constructor<br/>
     * <p>
     * </p>
     * 
     * @since  
     */
    public DriverService() {
        super();
    }

    /**
     * Constructor<br/>
     * <p>
     * </p>
     * 
     * @param serviceUrl
     * @param instanceId
     * @param extendInfo
     * @since  
     */
    public DriverService(String serviceUrl, String instanceId, String extendInfo) {
        this.serviceUrl = serviceUrl;
        this.instanceId = instanceId;
        this.extendInfo = extendInfo;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(String extendInfo) {
        this.extendInfo = extendInfo;
    }

}
