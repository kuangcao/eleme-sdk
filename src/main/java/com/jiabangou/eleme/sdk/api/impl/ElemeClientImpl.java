package com.jiabangou.eleme.sdk.api.impl;

import com.jiabangou.eleme.sdk.api.*;
import okhttp3.OkHttpClient;

/**
 * 客户端实现
 * Created by freeway on 16/7/13.
 */
public final class ElemeClientImpl implements ElemeClient {

    private ElemeConfigStorage configStorage;
    private OkHttpClient client;
    private FoodService foodService;
    private RestaurantService restaurantService;
    private FoodCategoryService foodCategoryService;
    private ImageService imageService;
    private OrderService orderService;

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

    @Override
    public FoodCategoryService getFoodCategoryService() {
        if (foodCategoryService == null) {
            foodCategoryService = new FoodCategoryServiceImpl(getClient(), configStorage);
        }
        return foodCategoryService;
    }

    @Override
    public RestaurantService getRestaurantService() {
        if (restaurantService == null) {
            restaurantService = new RestaurantServiceImpl(getClient(), configStorage);
        }
        return restaurantService;
    }

    @Override
    public ImageService getImageService() {
        if (imageService == null) {
            imageService = new ImageServiceImpl(getClient(), configStorage);
        }
        return imageService;
    }

    @Override
    public OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderServiceImpl(getClient(), configStorage);
        }
        return orderService;
    }

}
