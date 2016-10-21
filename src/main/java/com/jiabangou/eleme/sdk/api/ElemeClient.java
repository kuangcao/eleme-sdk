package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.model.ResultMessage;

import java.util.Map;

/**
 * Created by freeway on 16/7/11.
 */
public interface ElemeClient {

    void setElemeConfigStorage(ElemeConfigStorage configStorage);

    void setLogListener(LogListener logListener);

    void setPushConsumer(PushConsumer pushConsumer);

    ResultMessage pushHandle(String url, Map<String, String> params);

    FoodService getFoodService();

    FoodCategoryService getFoodCategoryService();

    RestaurantService getRestaurantService();

    ImageService getImageService();

    OrderService getOrderService();

    CommentService getCommentService();

    NewFoodService getNewFoodService();

    NewFoodCategoryService getNewFoodCategoryService();

}
