package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.RestaurantService;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.FoodCategoryDetail;
import com.jiabangou.eleme.sdk.model.Restaurant;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Created by freeway on 16/7/14.
 */
public class RestaurantServiceImpl extends BaseServiceImpl implements RestaurantService {

    private final static String RESTAURANT_RESTAURANT_ID_MENU = "/restaurant/${restaurant_id}/menu/";
    private final static String RESTAURANT_RESTAURANT_ID = "/restaurant/${restaurant_id}/";

    public RestaurantServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage) {
        super(client, configStorage);
    }

    @Override
    public List<FoodCategoryDetail> getMenu(Long restaurantId) throws ElemeErrorException {

        Map<String, String> params = new HashMap<>();
        params.put("restaurant_id", String.valueOf(restaurantId));
        params.put("tp_id", String.valueOf(1));
        JSONArray jsonArray = execute(HTTP_METHOD_GET, RESTAURANT_RESTAURANT_ID_MENU, params)
                .getJSONArray("restaurant_menu");
        return jsonArray.stream().map(obj-> TypeUtils.castToJavaBean(obj, FoodCategoryDetail.class)).collect(toList());
    }

    @Override
    public Restaurant get(Long restaurantId) throws ElemeErrorException {

        return execute(HTTP_METHOD_GET, RESTAURANT_RESTAURANT_ID,
                new HashMap<String, String>() {{
                    put("restaurant_id", String.valueOf(restaurantId));
                }}).getObject("restaurant", Restaurant.class);
    }

}
