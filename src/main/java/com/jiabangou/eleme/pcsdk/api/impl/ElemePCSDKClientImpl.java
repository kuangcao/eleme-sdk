package com.jiabangou.eleme.pcsdk.api.impl;

import com.jiabangou.eleme.pcsdk.ElemePCConfigStorage;
import com.jiabangou.eleme.pcsdk.ElemePCSDKClient;
import com.jiabangou.eleme.pcsdk.PCLogListener;
import com.jiabangou.eleme.pcsdk.api.CommentService;
import com.jiabangou.eleme.pcsdk.api.FoodService;
import com.jiabangou.eleme.pcsdk.api.LoginService;
import com.jiabangou.eleme.pcsdk.api.OrderService;
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
    private OrderService orderService;
    private CommentService commentService;


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

    @Override
    public OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderServiceImpl(getClient(), configStorage, logListener);
        }
        return orderService;
    }

    @Override
    public CommentService getCommentService() {
        if (commentService == null) {
            commentService = new CommentServiceImpl(getClient(), configStorage, logListener);
        }
        return commentService;
    }

}
