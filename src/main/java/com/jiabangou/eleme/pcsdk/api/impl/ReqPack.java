package com.jiabangou.eleme.pcsdk.api.impl;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

/**
 * 请求payload
 * Created by freeway on 2016/12/4.
 */
public class ReqPack implements Serializable {

    public static final String APP_NAME = "melody";
    public static final String APP_VERSION = "4.4.0";
    public static final String NCP = "2.0.0";

    private String id;
    private String service;
    private String method;
    private String ncp;
    private JSONObject params;
    private Metas metas;

    public static ReqPack build(API api, JSONObject params) {
        return new ReqPack()
                .setService(api.getService())
                .setMethod(api.getMethod())
                .setNcp(NCP)
                .setMetas(Metas.build())
                .setParams(params)
                .setId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    public ReqPack setId(String id) {
        this.id = id;
        return this;
    }

    public String getService() {
        return service;
    }

    public ReqPack setService(String service) {
        this.service = service;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public ReqPack setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getNcp() {
        return ncp;
    }

    public ReqPack setNcp(String ncp) {
        this.ncp = ncp;
        return this;
    }

    public JSONObject getParams() {
        return params;
    }

    public ReqPack setParams(JSONObject params) {
        this.params = params;
        return this;
    }

    public Metas getMetas() {
        return metas;
    }

    public ReqPack setMetas(Metas metas) {
        this.metas = metas;
        return this;
    }

    public static class Metas {
        private String appName;
        private String appVersion;
        private String ksid;

        public static Metas build() {
            return new Metas().setAppName(APP_NAME).setAppVersion(APP_VERSION);
        }

        public String getAppName() {
            return appName;
        }

        public Metas setAppName(String appName) {
            this.appName = appName;
            return this;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public Metas setAppVersion(String appVersion) {
            this.appVersion = appVersion;
            return this;
        }

        public String getKsid() {
            return ksid;
        }

        public Metas setKsid(String ksid) {
            this.ksid = ksid;
            return this;
        }
    }

    @Override
    public String toString() {
        return "ReqPack{" +
                "id='" + id + '\'' +
                ", service='" + service + '\'' +
                ", method='" + method + '\'' +
                ", ncp='" + ncp + '\'' +
                ", params=" + params +
                ", metas=" + metas +
                '}';
    }
}
