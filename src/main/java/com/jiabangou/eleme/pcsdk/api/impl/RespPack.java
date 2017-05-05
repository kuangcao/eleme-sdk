package com.jiabangou.eleme.pcsdk.api.impl;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 *
 * Created by freeway on 2016/12/4.
 */
public class RespPack implements Serializable {

    private Error error;
    private String id;
    private String ncp;
    private JSON result;

    public Error getError() {
        return error;
    }

    public RespPack setError(Error error) {
        this.error = error;
        return this;
    }

    public String getId() {
        return id;
    }

    public RespPack setId(String id) {
        this.id = id;
        return this;
    }

    public String getNcp() {
        return ncp;
    }

    public RespPack setNcp(String ncp) {
        this.ncp = ncp;
        return this;
    }

    public JSON getResult() {
        return result;
    }

    public RespPack setResult(JSON result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return "RespPack{" +
                "error=" + error +
                ", id='" + id + '\'' +
                ", ncp='" + ncp + '\'' +
                ", result=" + result +
                '}';
    }

    public static class Error {
        private String code;
        private String data;
        private String message;
        private String type;
        private String verbose;

        public String getCode() {
            return code;
        }

        public Error setCode(String code) {
            this.code = code;
            return this;
        }

        public String getData() {
            return data;
        }

        public Error setData(String data) {
            this.data = data;
            return this;
        }

        public String getMessage() {
            return message;
        }

        public Error setMessage(String message) {
            this.message = message;
            return this;
        }

        public String getType() {
            return type;
        }

        public Error setType(String type) {
            this.type = type;
            return this;
        }

        public String getVerbose() {
            return verbose;
        }

        public Error setVerbose(String verbose) {
            this.verbose = verbose;
            return this;
        }

        @Override
        public String toString() {
            return "Error{" +
                    "verbose='" + verbose + '\'' +
                    ", type='" + type + '\'' +
                    ", message='" + message + '\'' +
                    ", data='" + data + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }
    }


}
