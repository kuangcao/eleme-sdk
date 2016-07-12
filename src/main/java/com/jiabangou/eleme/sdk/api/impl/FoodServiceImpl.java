package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.FoodService;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Food;
import com.jiabangou.eleme.sdk.model.FoodAdd;
import okhttp3.OkHttpClient;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 *
 * Created by freeway on 16/7/11.
 */
public class FoodServiceImpl extends BaseServiceImpl implements FoodService {

    private final static String FOOD_FOOD_ID = "/food/${food_id}/";
    private final static String FOOD_BATCH_GET = "/foods/batch_get/";
    private final static String FOOD = "/food/";


    public FoodServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage) {
        super(client, configStorage);
    }

    @Override
    public Food getById(long foodId) throws ElemeErrorException {
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
    public long add(FoodAdd foodAdd) throws ElemeErrorException {
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(foodAdd);
        Map<String, String> params = new HashMap<>();
        for (String key : jsonObject.keySet()) {
            params.put(key, String.valueOf(jsonObject.get(key)));
        }
        return execute(HTTP_METHOD_GET, FOOD, params).getLongValue("food_id");
    }



}
