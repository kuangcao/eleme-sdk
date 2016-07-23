package com.jiabangou.eleme.sdk.api;

/**
 * Created by freeway on 16/7/23.
 */
public interface LogListener {

    void requestEvent(String cmd, boolean isSuccess, String request, String response);

}
