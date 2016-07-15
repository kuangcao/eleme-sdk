package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.FoodService;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Food;
import com.jiabangou.eleme.sdk.model.FoodSave;
import okhttp3.OkHttpClient;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 *
 * Created by freeway on 16/7/11.
 */
public class FoodServiceImpl extends BaseServiceImpl implements FoodService {

    private final static String FOOD_FOOD_ID = "/food/${food_id}/";
    private final static String FOOD_BATCH_GET = "/foods/batch_get/";
    private final static String FOOD = "/food/";
    private final static String FOOD_BATCH_DELETE = "/foods/batch_delete/";
    private final static String FOOD_CATEGORY_FOOD_CATEGORY_ID_FOODS = "/food_category/${food_category_id}/foods/";

    public FoodServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage) {
        super(client, configStorage);
    }

    @Override
    public Food getById(Long foodId) throws ElemeErrorException {
        Map<String, String> params = new HashMap<>();
        params.put("food_id", String.valueOf(foodId));
        JSONObject jsonObject = execute(HTTP_METHOD_GET, FOOD_FOOD_ID, params);
        return jsonObject.getObject("food", Food.class);
    }

    @Override
    public List<Food> getsByIds(List<Long> foodIds) throws ElemeErrorException {
        Map<String, String> params = new HashMap<>();
        params.put("food_ids", StringUtils.join(foodIds.stream().map(String::valueOf).collect(toList()), ","));
        return execute(HTTP_METHOD_GET, FOOD_BATCH_GET, params).getJSONArray("foods")
                .stream().map(obj-> TypeUtils.castToJavaBean(obj, Food.class)).collect(toList());
    }

    @Override
    public Long add(FoodSave foodSave) throws ElemeErrorException {
        return execute(HTTP_METHOD_POST, FOOD, foodSave).getLong("food_id");
    }

    @Override
    public void update(FoodSave foodSave) throws ElemeErrorException {
        if (foodSave.getFood_id() == null) {
            throw new ElemeErrorException(-1, "food_id is required.");
        }
        execute(HTTP_METHOD_PUT, FOOD_FOOD_ID, foodSave);
    }

    @Override
    public void remove(Long foodId) throws ElemeErrorException {
        if (foodId == null) {
            throw new ElemeErrorException(-1, "foodId is required.");
        }
        Map<String, String> params = new HashMap<>();
        params.put("food_id", foodId.toString());
        execute(HTTP_METHOD_DELETE, FOOD_FOOD_ID, params);
    }

    @Override
    public void removeAll(List<Long> foodIds) throws ElemeErrorException {
        if (foodIds == null || foodIds.isEmpty()) {
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("food_ids", StringUtils.join(foodIds.stream().map(String::valueOf).collect(toList()), ","));
        execute(HTTP_METHOD_DELETE, FOOD_BATCH_DELETE, params);
    }

    @Override
    public List<Food> getsByFoodCategoryId(Long foodCategoryId) throws ElemeErrorException {

        Map<String, String> params = new HashMap<String, String>() {{
            put("food_category_id", String.valueOf(foodCategoryId));
        }};
        return execute(HTTP_METHOD_GET, FOOD_CATEGORY_FOOD_CATEGORY_ID_FOODS, params).getJSONArray("foods")
                .stream().map(obj-> TypeUtils.castToJavaBean(obj, Food.class)).collect(toList());
    }
}
