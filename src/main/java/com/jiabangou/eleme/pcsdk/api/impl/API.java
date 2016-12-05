package com.jiabangou.eleme.pcsdk.api.impl;

import java.util.Map;

/**
 * api 定义
 * Created by freeway on 2016/12/4.
 */
public enum API {

    LOGIN_SERVICE_LOGIN_BY_USERNAME("LoginService", "loginByUsername");

    private String service;
    private String method;

    API(String service, String method) {
        this.service = service;
        this.method = method;
    }

    public String getService() {
        return service;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, String> toMap() {
        Map<String>
    }
}
