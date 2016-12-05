package com.jiabangou.eleme.pcsdk.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.pcsdk.ElemePCConfigStorage;
import com.jiabangou.eleme.pcsdk.PCLogListener;
import com.jiabangou.eleme.pcsdk.api.FoodService;
import com.jiabangou.eleme.pcsdk.model.Category;
import com.jiabangou.eleme.pcsdk.model.Food;
import okhttp3.OkHttpClient;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 菜品服务实现
 * Created by freeway on 2016/12/5.
 */
public class FoodServiceImpl extends PcBaseServiceImpl implements FoodService {

    public FoodServiceImpl(OkHttpClient client, ElemePCConfigStorage configStorage, PCLogListener logListener) {
        super(client, configStorage, logListener);
    }

    @Override
    public List<Food> getFoodsByCategoryId(Long categoryId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("categoryId", categoryId);
        JSONArray jsonArray = (JSONArray) execute(API.FOOD_SERVICE_GET_FOODS_BY_CATEGORY_ID, jsonObject);
        return jsonArray.stream().map(json -> TypeUtils.castToJavaBean(json, Food.class)).collect(toList());
    }

    @Override
    public List<Category> getCategories(Long restaurantId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("restaurantId", restaurantId);
        JSONObject result = (JSONObject) execute(API.FOOD_SERVICE_GET_CATEGORIES, jsonObject);
        JSONArray jsonArray = result.getJSONArray("categories");
        return jsonArray.stream().map(json -> TypeUtils.castToJavaBean(json, Category.class)).collect(toList());
    }
}
