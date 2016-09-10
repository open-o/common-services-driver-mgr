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

package org.openo.drivermgr.constant;

/**
 * <p>
 * This class which holds the all the constant values for the Driver Manager.
 * </p>
 * <br/>
 * 
 * @author
 * @version  
 */
public final class Constant {

    public static final String TYPE_POST = "POST";

    public static final String TYPE_DELETE = "DELETE";

    public static final String TYPE_HEAD = "HEAD";

    public static final String TYPE_GET = "GET";

    public static final String TYPE_PATCH = "PATCH";

    public static final String MEDIA_TYPE_JSON = "application/json";
    
    public static final String EXT_SYS_URL = "/openoapi/extsys/v1/common/";
    
    public static final String HTTP_SEPARATOR = "://";
    
    public static final String PORT_SEPARATOR = ":";
    
    public static final String PATH_SEPARATOR = "/";
    
    public static final String SYSTEM_ID_PARAM = "extSysID";

    private Constant() {
    }
}
