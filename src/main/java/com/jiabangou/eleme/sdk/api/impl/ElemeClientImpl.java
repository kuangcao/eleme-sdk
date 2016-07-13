package com.jiabangou.eleme.sdk.api.impl;

import com.jiabangou.eleme.sdk.api.ElemeClient;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.FoodService;
import okhttp3.OkHttpClient;

/**
 * 客户端实现
 * Created by freeway on 16/7/13.
 */
public final class ElemeClientImpl implements ElemeClient {

    private ElemeConfigStorage configStorage;
    private OkHttpClient client;
    private FoodService foodService;

    public ElemeClientImpl(ElemeConfigStorage configStorage) {
        this.configStorage = configStorage;
    }


    @Override
    public void setBaiduWaimaiConfigStorage(ElemeConfigStorage configStorage) {
        this.configStorage = configStorage;
    }

    private OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient();
        }
        return client;
    }

    @Override
    public FoodService getFoodService() {
        if (foodService == null) {
            foodService = new FoodServiceImpl(getClient(), configStorage);
        }
        return foodService;
    }
}
