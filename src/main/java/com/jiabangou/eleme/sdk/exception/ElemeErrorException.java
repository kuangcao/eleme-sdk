package com.jiabangou.eleme.sdk.exception;

import com.jiabangou.eleme.sdk.model.ElemeError;

/**
 * Created by freeway on 16/7/11.
 */
public class ElemeErrorException extends Exception {

    protected int code;

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
        return "BdWmErrorException{" +
                "code=" + code +
                ", message=" + getMessage() +
                "} " + super.toString();
    }

}
