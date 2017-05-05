package com.jiabangou.eleme.pcsdk.exception;

import com.jiabangou.eleme.pcsdk.api.impl.RespPack.Error;
/**
 * 饿了么异常
 * Created by freeway on 2016/12/4.
 */
public class ElemePCErrorException extends RuntimeException {

    private String code;
    private String data;
    private String message;
    private String type;
    private String verbose;

    public ElemePCErrorException(Error error) {
        this.code = error.getCode();
        this.data = error.getData();
        this.message = error.getMessage();
        this.type = error.getType();
        this.verbose = error.getVerbose();
    }

    public String getCode() {
        return code;
    }

    public String getData() {
        return data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public String getVerbose() {
        return verbose;
    }
}
