package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.FoodCategoryService;
import com.jiabangou.eleme.sdk.api.LogListener;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.ElemeErrorCode;
import com.jiabangou.eleme.sdk.model.FoodCategory;
import com.jiabangou.eleme.sdk.model.FoodCategoryDetailSave;
import com.jiabangou.eleme.sdk.model.FoodCategorySave;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * 食物分类
 * Created by freeway on 16/7/13.
 */
public class FoodCategoryServiceImpl extends BaseServiceImpl implements FoodCategoryService {


    private final static String FOOD_CATEGORY_FOOD_CATEGORY_ID = "/food_category/${food_category_id}/";

    private final static String FOOD_CATEGORY = "/food_category/";

    private final static String CATEGORY_FOOD_BATCH_ADD = "/category_food/batch_add/";

    private final static String RESTAURANT_RESTAURANT_ID_FOOD_CATEGORIES = "/restaurant/${restaurant_id}/food_categories/";

    public FoodCategoryServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage, LogListener logListener) {
        super(client, configStorage, logListener);
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
            if (ElemeErrorCode.INVALID_FOOD_CATEGORY.getCode() == e.getCode() ||
                    ElemeErrorCode.PERMISSION_DENIED.getCode() == e.getCode()) {
                return null;
            }
            throw e;
        }
    }

    @Override
    public List<FoodCategory> getsByRestaurantId(Long restaurantId) throws ElemeErrorException {
        if (restaurantId == null) {
            throw new ElemeErrorException(-1, "restaurantId is required.");
        }

        JSONObject jsonObject = execute(HTTP_METHOD_GET, RESTAURANT_RESTAURANT_ID_FOOD_CATEGORIES,
                new HashMap<String, String>() {{
                    put("restaurant_id", String.valueOf(restaurantId));
                }});
        return jsonObject.getJSONArray("food_categories").stream()
                .map(obj -> TypeUtils.castToJavaBean(obj, FoodCategory.class)).collect(toList());
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

    private void quietRemove(Long foodCategoryId) {
        try {
            remove(foodCategoryId);
        } catch (ElemeErrorException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeAll(Long restaurantId) throws ElemeErrorException {
        List<FoodCategory> foodCategories = getsByRestaurantId(restaurantId);
        try {
            foodCategories.parallelStream().map(FoodCategory::getFood_category_id).forEach(this::quietRemove);
        } catch (RuntimeException e) {
            if (e.getCause() instanceof ElemeErrorException) {
                throw (ElemeErrorException) e.getCause();
            }
            throw e;
        }

    }

    @Override
    public Map<Long, List<Long>> addCategoryAndFoods(List<FoodCategoryDetailSave> categoryFoods) throws ElemeErrorException {
        if (categoryFoods == null || categoryFoods.isEmpty()) {
            throw new ElemeErrorException(-1, "categoryFoods is required.");
        }

        JSONObject jsonObject = execute(HTTP_METHOD_POST, CATEGORY_FOOD_BATCH_ADD, new HashMap<String, String>() {{
            put("category_food_info", JSONObject.toJSONString(categoryFoods, false));
        }});
        JSONArray jsonArray = jsonObject.getJSONArray("category_food_ids");
        Map<Long, List<Long>> result = new HashMap<>();
        for (Object object : jsonArray) {
            JSONObject subJson = (JSONObject) object;
            result.put(subJson.getLong("food_category_id"), subJson.getJSONArray("food_ids").stream().map(i -> Long.valueOf(i.toString())).collect(toList()));
        }
        return result;
    }


}
