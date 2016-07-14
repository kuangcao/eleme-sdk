package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.FoodCategoryService;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Food;
import com.jiabangou.eleme.sdk.model.FoodCategory;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by freeway on 16/7/13.
 */
public class FoodCategoryServiceImpl extends BaseServiceImpl implements FoodCategoryService {


    private final static String FOOD_CATEGORY_FOOD_CATEGORY_ID = "/food_category/${food_category_id}/";

    public FoodCategoryServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage) {
        super(client, configStorage);
    }

    @Override
    public FoodCategory getById(Long foodCategoryId) throws ElemeErrorException {
        Map<String, String> params = new HashMap<>();
        params.put("food_category_id", String.valueOf(foodCategoryId));
        JSONObject jsonObject = execute(HTTP_METHOD_GET, FOOD_CATEGORY_FOOD_CATEGORY_ID, params);
        return jsonObject.getObject("food_category", FoodCategory.class);
    }


}
