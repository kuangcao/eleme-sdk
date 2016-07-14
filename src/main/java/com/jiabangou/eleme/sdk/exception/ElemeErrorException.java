package com.jiabangou.eleme.sdk.exception;

import com.jiabangou.eleme.sdk.model.ElemeError;

import java.util.Map;

/**
 * Created by freeway on 16/7/11.
 */
public class ElemeErrorException extends Exception {

    protected int code;
    protected String responseString;
    protected String requestUrl;
    protected Map<String, String> requestParams;

    public ElemeErrorException(int code, String message, String requestUrl, Map<String, String> requestParams, String responseString) {
        super(message);
        this.code = code;
        this.responseString = responseString;
        this.requestUrl = requestUrl;
        this.requestParams = requestParams;
    }

    public ElemeErrorException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ElemeErrorException(ElemeError error) {
        super(error.getErrorMsg());
        this.code = error.getErrorCode();
    }


    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ElemeErrorException{" +
                "code=" + code + "\n" +
                ", message=" + getMessage() + "\n" +
                ", responseString='" + responseString + '\'' + "\n" +
                ", requestUrl='" + requestUrl + '\'' + "\n" +
                ", requestParams=" + requestParams +
                '}';
    }
}
