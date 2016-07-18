package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.FoodCategoryService;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.FoodCategory;
import com.jiabangou.eleme.sdk.model.FoodCategorySave;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by freeway on 16/7/13.
 */
public class FoodCategoryServiceImpl extends BaseServiceImpl implements FoodCategoryService {


    private final static String FOOD_CATEGORY_FOOD_CATEGORY_ID = "/food_category/${food_category_id}/";

    private final static String FOOD_CATEGORY = "/food_category/";

    private final static String CATEGORY_FOOD_BATCH_ADD = "/category_food/batch_add/";

    public FoodCategoryServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage) {
        super(client, configStorage);
    }

    @Override
    public FoodCategory getById(Long foodCategoryId) throws ElemeErrorException {
        if (foodCategoryId == null) {
            throw new ElemeErrorException(-1, "foodCategoryId is required.");
        }
        Map<String, String> params = new HashMap<>();
        params.put("food_category_id", String.valueOf(foodCategoryId));
        try {
            JSONObject jsonObject = execute(HTTP_METHOD_GET, FOOD_CATEGORY_FOOD_CATEGORY_ID, params);
            return jsonObject.getObject("food_category", FoodCategory.class);
        } catch (ElemeErrorException e) {
            //没有这个分类
            if (e.getCode() == 1019) {
                return null;
            }
            throw e;
        }
    }

    @Override
    public Long add(FoodCategorySave foodCategorySave) throws ElemeErrorException {
        if (foodCategorySave.getRestaurant_id() == null) {
            throw new ElemeErrorException(-1, "Restaurant_id is required.");
        }
        return execute(HTTP_METHOD_POST, FOOD_CATEGORY, foodCategorySave).getLong("food_category_id");
    }

    @Override
    public void update(FoodCategorySave foodCategorySave) throws ElemeErrorException {
        if (foodCategorySave.getRestaurant_id() == null) {
            throw new ElemeErrorException(-1, "Restaurant_id is required.");
        }

        execute(HTTP_METHOD_PUT, FOOD_CATEGORY_FOOD_CATEGORY_ID, foodCategorySave);

    }


    @Override
    public void remove(Long foodCategoryId) throws ElemeErrorException {
        if (foodCategoryId == null) {
            throw new ElemeErrorException(-1, "Restaurant_id is required.");
        }
        Map<String, String> params = new HashMap<>();
        params.put("food_category_id", String.valueOf(foodCategoryId));
        execute(HTTP_METHOD_DELETE, FOOD_CATEGORY_FOOD_CATEGORY_ID, params);
    }

}
