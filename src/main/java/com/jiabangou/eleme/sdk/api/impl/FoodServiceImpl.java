package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.FoodService;
import com.jiabangou.eleme.sdk.api.LogListener;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.*;
import okhttp3.OkHttpClient;
import org.apache.commons.lang.StringUtils;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 *
 * Created by freeway on 16/7/11.
 */
public class FoodServiceImpl extends BaseServiceImpl implements FoodService {

    private final static String FOOD_FOOD_ID = "/food/${food_id}/";
    private final static String FOOD_BATCH_GET = "/foods/batch_get/";
    private final static String FOOD = "/food/";
    private final static String FOOD_BATCH_DELETE = "/foods/batch_delete/";
    private final static String FOODS_BATCH_UPDATE = "/foods/batch_update/";
    private final static String FOOD_CATEGORY_FOOD_CATEGORY_ID_FOODS = "/food_category/${food_category_id}/foods/";

    private final static String FOODS_TP_FOOD_ID = "/foods/tp_food_id/";
    private final static String FOODS_STOCK = "/foods/stock/";

    public FoodServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage, LogListener logListener) {
        super(client, configStorage, logListener);
    }


    @Override
    public Food getById(Long foodId) throws ElemeErrorException {
        if (foodId == null) {
            throw new ElemeErrorException(-1, "foodId is required.");
        }
        Map<String, String> params = new HashMap<>();
        params.put("food_id", String.valueOf(foodId));
        try {
            return execute(HTTP_METHOD_GET, FOOD_FOOD_ID, params).getObject("food", Food.class);
        } catch (ElemeErrorException e) {
            if (ElemeErrorCode.INVALID_FOOD.getCode() == e.getCode() ||
                    ElemeErrorCode.PERMISSION_DENIED.getCode() == e.getCode()) {
                return null;
            }
            throw e;
        }
    }

    @Override
    public List<Food> getsByIds(List<Long> foodIds) throws ElemeErrorException {
        if (foodIds == null || foodIds.isEmpty()) {
            return Collections.emptyList();
        }
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

    @Override
    public void updateAll(List<FoodSave> foods) throws ElemeErrorException {
        if (foods == null || foods.isEmpty()) {
            return;
        }

        List<JSONObject> jsonObject = foods.stream().map(obj-> (JSONObject)JSON.toJSON(obj)).collect(toList());
        JSONObject requestJsonObject = new JSONObject();
        jsonObject.forEach(j-> {
            String key = j.getString("food_id");
            j.remove("food_id");
            requestJsonObject.put(key, j);
        });

        Map<String, String> params = new HashMap<String, String>() {{
            put("foods_info", requestJsonObject.toJSONString());
        }};
        execute(HTTP_METHOD_PUT, FOODS_BATCH_UPDATE, params);
    }

    @Override
    public List<TpFood> getsByTpFoodIds(List<String> tpFoodIds) throws ElemeErrorException {
        if (tpFoodIds == null || tpFoodIds.isEmpty()) {
            return Collections.emptyList();
        }
        Map<String, String> params = new HashMap<>();
        params.put("tp_food_ids", StringUtils.join(tpFoodIds.stream().map(String::valueOf).collect(toList()), ","));

        JSONObject jsonObject = execute(HTTP_METHOD_GET, FOODS_TP_FOOD_ID, params).getJSONObject("food_ids");
        List<TpFood> tpFoods = new ArrayList<TpFood>();
        for(Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            String tpFoodId = entry.getKey();
            JSONArray jsonArray = (JSONArray)entry.getValue();
            for (Object object : jsonArray) {
                JSONObject tpFoodJson = (JSONObject)object;
                TpFood tpFood = new TpFood();
                tpFood.setFood_id(tpFoodJson.getLong("food_id"));
                tpFood.setRestaurant_id(tpFoodJson.getLong("restaurant_id"));
                tpFood.setTp_food_id(tpFoodId);
                tpFood.setTp_restaurant_id(tpFoodJson.getString("tp_restaurant_id"));
                tpFoods.add(tpFood);
            }
        }
        return tpFoods;
    }

    @Override
    public void updateStocks(List<Stock> stocks) throws ElemeErrorException {
        if (stocks == null || stocks.isEmpty()) {
            return;
        }
        Map<String, List<Stock>> stockMap = stocks.stream().collect(groupingBy(Stock::getTp_restaurant_id));

        Map<String, Map<String, Integer>> stock_info = new HashMap<>(stockMap.size());
        for(Map.Entry<String, List<Stock>> entry : stockMap.entrySet()) {
            stock_info.put(entry.getKey(), entry.getValue().stream().collect(toMap(Stock::getTp_food_id, Stock::getStock)));
        }

        execute(HTTP_METHOD_PUT, FOODS_STOCK, new HashMap<String, String>() {{
            put("stock_info", JSONObject.toJSONString(stock_info));
        }});
    }

    @Override
    public void updateStock(Stock stock) throws ElemeErrorException {
        updateStocks(new ArrayList<Stock>(1) {{add(stock);}});
    }

}
