package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.LogListener;
import com.jiabangou.eleme.sdk.api.NewFoodCategoryService;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.ElemeErrorCode;
import com.jiabangou.eleme.sdk.model.NewFood;
import com.jiabangou.eleme.sdk.model.NewFoodCategory;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * 食物分类
 * Created by freeway on 16/7/13.
 */
public class NewFoodCategoryServiceImpl extends BaseServiceImpl implements NewFoodCategoryService {


    private final static String NEW_FOOD_CATEGORY_FOOD_CATEGORY_ID = "/new_food_category/${food_category_id}/";

    private final static String NEW_FOOD_CATEGORY_FOOD_CATEGORY_ID_FOODS = "/new_food_category/${food_category_id}/foods";

    private final static String NEW_FOOD_CATEGORY = "/new_food_category/";

    private final static String RESTAURANT_RESTAURANT_ID_FOOD_CATEGORIES = "/restaurant/${restaurant_id}/food_categories/";

    public NewFoodCategoryServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage, LogListener logListener) {
        super(client, configStorage, logListener);
    }


    @Override
    public NewFoodCategory getById(Long foodCategoryId) throws ElemeErrorException {
        if (foodCategoryId == null) {
            throw new ElemeErrorException(-1, "foodCategoryId is required.");
        }
        Map<String, String> params = new HashMap<>();
        params.put("food_category_id", String.valueOf(foodCategoryId));
        try {
            JSONObject jsonObject = execute(HTTP_METHOD_GET, NEW_FOOD_CATEGORY_FOOD_CATEGORY_ID, params);
            return jsonObject.getObject("food_category", NewFoodCategory.class);
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
    public List<NewFood> getFoodsById(Long foodCategoryId) throws ElemeErrorException {
        if (foodCategoryId == null) {
            throw new ElemeErrorException(-1, "foodCategoryId is required.");
        }
        Map<String, String> params = new HashMap<>();
        params.put("food_category_id", String.valueOf(foodCategoryId));
        JSONObject jsonObject = execute(HTTP_METHOD_GET, NEW_FOOD_CATEGORY_FOOD_CATEGORY_ID_FOODS, params);
        return jsonObject.getJSONArray("foods").stream()
                .map(obj -> TypeUtils.castToJavaBean(obj, NewFood.class)).collect(toList());
    }

    @Override
    public Long add(NewFoodCategory newFoodCategory) throws ElemeErrorException {
        if (newFoodCategory.getRestaurant_id() == null) {
            throw new ElemeErrorException(-1, "Restaurant_id is required.");
        }
        return execute(HTTP_METHOD_POST, NEW_FOOD_CATEGORY, newFoodCategory).getLong("food_category_id");
    }

    @Override
    public void update(NewFoodCategory newFoodCategory) throws ElemeErrorException {
        if (newFoodCategory.getRestaurant_id() == null) {
            throw new ElemeErrorException(-1, "Restaurant_id is required.");
        }

        execute(HTTP_METHOD_PUT, NEW_FOOD_CATEGORY, newFoodCategory);
    }

    @Override
    public void remove(Long foodCategoryId) throws ElemeErrorException {
        if (foodCategoryId == null) {
            throw new ElemeErrorException(-1, "Restaurant_id is required.");
        }
        Map<String, String> params = new HashMap<>();
        params.put("food_category_id", String.valueOf(foodCategoryId));
        execute(HTTP_METHOD_DELETE, NEW_FOOD_CATEGORY_FOOD_CATEGORY_ID, params);
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
        List<NewFoodCategory> newFoodCategories = getsByRestaurantId(restaurantId);
        try {
            newFoodCategories.parallelStream().map(NewFoodCategory::getFood_category_id).forEach(this::quietRemove);
        } catch (RuntimeException e) {
            if (e.getCause() instanceof ElemeErrorException) {
                throw (ElemeErrorException) e.getCause();
            }
            throw e;
        }
    }

    @Override
    public List<NewFoodCategory> getsByRestaurantId(Long restaurantId) throws ElemeErrorException {
        if (restaurantId == null) {
            throw new ElemeErrorException(-1, "restaurantId is required.");
        }

        JSONObject jsonObject = execute(HTTP_METHOD_GET, RESTAURANT_RESTAURANT_ID_FOOD_CATEGORIES,
                new HashMap<String, String>() {{
                    put("restaurant_id", String.valueOf(restaurantId));
                }});
        return jsonObject.getJSONArray("food_categories").stream()
                .map(obj -> TypeUtils.castToJavaBean(obj, NewFoodCategory.class)).collect(toList());
    }
}
