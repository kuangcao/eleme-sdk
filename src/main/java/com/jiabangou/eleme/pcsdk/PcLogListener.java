package com.jiabangou.eleme.pcsdk;

/**
 * Created by freeway on 16/7/23.
 */
public interface PCLogListener {

    void requestEvent(String cmd, String method, boolean isSuccess, String request, String response);

}
