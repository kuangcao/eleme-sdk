package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;

/**
 * Created by freeway on 16/7/19.
 */
public class ResultMessage implements Serializable {

    private String message;

    public ResultMessage(String message)  {
        this.message = message;
    }

    public static ResultMessage buildOk() {
        return new ResultMessage("ok");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
