package com.jiabangou.eleme.pcsdk.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.pcsdk.ElemePCConfigStorage;
import com.jiabangou.eleme.pcsdk.PCLogListener;
import com.jiabangou.eleme.pcsdk.api.FoodService;
import com.jiabangou.eleme.pcsdk.model.Category;
import com.jiabangou.eleme.pcsdk.model.Food;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 菜品服务实现
 * Created by freeway on 2016/12/5.
 */
public class FoodServiceImpl extends PCBaseServiceImpl implements FoodService {

    public FoodServiceImpl(OkHttpClient client, ElemePCConfigStorage configStorage, PCLogListener logListener) {
        super(client, configStorage, logListener);
    }

    @Override
    public void fillStock(Long foodId) {
        fillStock(new ArrayList<Long>() {{
            add(foodId);
        }});
    }

    @Override
    public void fillStock(List<Long> foodIds) {
        JSONObject params = new JSONObject();
        params.put("batchUpdate", new HashMap<String, Boolean>() {{
            put("fillStock", true);
        }});
        JSONArray foodsWithSpecId = new JSONArray();
        for (Long foodId : foodIds) {
            foodsWithSpecId.add(new HashMap<String, Object>() {{
                put("foodId", foodId);
                put("foodSpecIds", new ArrayList(0));
            }});
        }
        params.put("foodsWithSpecId", foodsWithSpecId);

        execute(API.FOOD_SERVICE_BATCH_UPDATE_FOODS, params);
    }

    @Override
    public void clearStock(Long foodId) {
        clearStock(new ArrayList<Long>() {{
            add(foodId);
        }});
    }

    @Override
    public void clearStock(List<Long> foodIds) {
        JSONObject params = new JSONObject();
        params.put("batchUpdate", new HashMap<String, Boolean>() {{
            put("clearStock", true);
        }});
        JSONArray foodsWithSpecId = new JSONArray();
        for (Long foodId : foodIds) {
            foodsWithSpecId.add(new HashMap<String, Object>() {{
                put("foodId", foodId);
                put("foodSpecIds", new ArrayList(0));
            }});
        }
        params.put("foodsWithSpecId", foodsWithSpecId);

        execute(API.FOOD_SERVICE_BATCH_UPDATE_FOODS, params);
    }

    private void batchUpdateFoods(JSONObject controlType, List<Long> foodIds) {

    }

    @Override
    public List<Food> getFoodsByCategoryId(Long categoryId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("categoryId", categoryId);
        JSONArray jsonArray = (JSONArray) execute(API.FOOD_SERVICE_GET_FOODS_BY_CATEGORY_ID, jsonObject);
        return jsonArray.stream().map(json -> TypeUtils.castToJavaBean(json, Food.class)).collect(toList());
    }

    @Override
    public Food getFood(Long foodId) {
        JSONObject params = new JSONObject();
        params.put("foodId", foodId);
        JSONObject result = (JSONObject) execute(API.FOOD_SERVICE_GET_FOOD_VIEW, params);
        return result.getObject("food", Food.class);
    }

    @Override
    public String uploadFoodImage(String url, MediaType mediaType) {
        String type = "napos.food.foodImage";
        JSONObject result = (JSONObject)uploadFile(url, type, mediaType);
        return result.getString("imageUrl");
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
