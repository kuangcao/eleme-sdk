package com.jiabangou.eleme.pcsdk.api.impl;

import java.util.Map;

/**
 * api 定义
 * Created by freeway on 2016/12/4.
 */
public enum API {

    LOGIN_SERVICE_LOGIN_BY_USERNAME("arena/invoke/", "LoginService", "loginByUsername"),
    FOOD_SERVICE_GET_FOODS_BY_CATEGORY_ID("goods/invoke/", "food", "getFoodsByCategoryId"),
    FOOD_SERVICE_GET_CATEGORIES("goods/invoke/", "food", "getMainView"),
    FOOD_SERVICE_BATCH_UPDATE_FOODS("goods/invoke/", "food", "batchUpdateFoods"),

    ;

    public static final String BASE_URL = "https://app-api.shop.ele.me/";

    private String url;
    private String service;
    private String method;

    API(String url, String service, String method) {
        this.url = BASE_URL + url + "?method=" + service + "." + method;
        this.service = service;
        this.method = method;
    }

    public String getService() {
        return service;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

}
