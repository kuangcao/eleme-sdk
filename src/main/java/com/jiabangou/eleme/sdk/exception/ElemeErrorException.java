package com.jiabangou.eleme.sdk.exception;

import com.jiabangou.eleme.sdk.model.ElemeError;

/**
 * Created by freeway on 16/7/11.
 */
public class ElemeErrorException extends Exception {

    protected int code;
    protected String jsonString;

    public ElemeErrorException(int code, String message, String jsonString) {
        super(message);
        this.code = code;
        this.jsonString = jsonString;
    }

    public ElemeErrorException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ElemeErrorException(ElemeError error) {
        super(error.getErrorMsg());
        this.code = error.getErrorCode();
    }

    public String getJsonString() {
        return jsonString;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ElemeErrorException{" +
                "code=" + code +
                ", message=" + getMessage() +
                ", jsonString='" + jsonString + '\'' +
                '}';
    }
}
