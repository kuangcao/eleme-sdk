package com.jiabangou.eleme.pcsdk.api.impl;

import com.jiabangou.eleme.pcsdk.ElemePCConfigStorage;
import com.jiabangou.eleme.pcsdk.ElemePCSDKClient;
import com.jiabangou.eleme.pcsdk.PCLogListener;
import com.jiabangou.eleme.pcsdk.api.FoodService;
import com.jiabangou.eleme.pcsdk.api.LoginService;
import okhttp3.OkHttpClient;

/**
 * pc 版 sdk 客户端实现
 * Created by freeway on 2016/12/4.
 */
public class ElemePCSDKClientImpl implements ElemePCSDKClient {

    private ElemePCConfigStorage configStorage;
    private PCLogListener logListener;
    private OkHttpClient client;

    private LoginService loginService;
    private FoodService foodService;

    public ElemePCSDKClientImpl(ElemePCConfigStorage elemePCConfigStorage) {
        this.configStorage = elemePCConfigStorage;
    }

    @Override
    public void setElemePCConfigStorage(ElemePCConfigStorage configStorage) {
        this.configStorage = configStorage;
    }

    @Override
    public void setPCLogListener(PCLogListener logListener) {
        this.logListener = logListener;
    }

    private OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient();
        }
        return client;
    }

    @Override
    public LoginService getLoginService() {
        if (loginService == null) {
            loginService = new LoginServiceImpl(getClient(), configStorage, logListener);
        }
        return loginService;
    }

    @Override
    public FoodService getFoodService() {
        if (foodService == null) {
            foodService = new FoodServiceImpl(getClient(), configStorage, logListener);
        }
        return foodService;
    }

}
