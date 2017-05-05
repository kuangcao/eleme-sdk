package com.jiabangou.eleme.sdk.api.impl;

import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.LogListener;
import com.jiabangou.eleme.sdk.api.NewFoodService;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.ElemeErrorCode;
import com.jiabangou.eleme.sdk.model.NewFood;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 新菜品服务实现
 * Created by wanglei on 16-10-20.
 */
public class NewFoodServiceImpl extends BaseServiceImpl implements NewFoodService {

    private final static String NEW_FOOD_FOOD_ID = "/new_food/${food_id}/";
    private final static String NEW_FOOD = "/new_food/";

    public NewFoodServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage, LogListener logListener) {
        super(client, configStorage, logListener);
    }


    @Override
    public NewFood getById(Long foodId) throws ElemeErrorException {
        if (foodId == null) {
            throw new ElemeErrorException(-1, "foodId is required.");
        }
        Map<String, String> params = new HashMap<>();
        params.put("food_id", String.valueOf(foodId));
        try {
            return execute(HTTP_METHOD_GET, NEW_FOOD_FOOD_ID, params).getObject("food", NewFood.class);
        } catch (ElemeErrorException e) {
            if (ElemeErrorCode.INVALID_FOOD.getCode() == e.getCode() ||
                    ElemeErrorCode.PERMISSION_DENIED.getCode() == e.getCode()) {
                return null;
            }
            throw e;
        }
    }

    @Override
    public Long add(NewFood food) throws ElemeErrorException {
        return execute(HTTP_METHOD_POST, NEW_FOOD, food).getLong("food_id");
    }

    @Override
    public void update(NewFood food) throws ElemeErrorException {
        if (food.getFood_id() == null) {
            throw new ElemeErrorException(-1, "food_id is required.");
        }
        execute(HTTP_METHOD_PUT, NEW_FOOD_FOOD_ID, food);
    }

    @Override
    public void remove(Long foodId) throws ElemeErrorException {
        if (foodId == null) {
            throw new ElemeErrorException(-1, "foodId is required.");
        }
        Map<String, String> params = new HashMap<>();
        params.put("food_id", foodId.toString());
        execute(HTTP_METHOD_DELETE, NEW_FOOD_FOOD_ID, params);
    }

    @Override
    public void onShelf(Long foodId) throws ElemeErrorException {
        NewFood food = getById(foodId);
        if (food != null) {
            food.setOn_shelf(NewFood.ON_SHELF);
        }
        update(food);
    }

    @Override
    public void offShelf(Long foodId) throws ElemeErrorException {
        NewFood food = getById(foodId);
        if (food != null) {
            food.setOn_shelf(NewFood.OFF_SHELF);
        }
        update(food);
    }
}
