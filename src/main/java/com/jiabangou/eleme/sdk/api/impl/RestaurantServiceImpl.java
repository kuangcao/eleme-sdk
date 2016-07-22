package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.RestaurantService;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.*;
import okhttp3.OkHttpClient;
import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * 餐厅服务
 * Created by freeway on 16/7/14.
 */
public class RestaurantServiceImpl extends BaseServiceImpl implements RestaurantService {

    private final static String RESTAURANT_RESTAURANT_ID_MENU = "/restaurant/${restaurant_id}/menu/";
    private final static String RESTAURANT_RESTAURANT_ID = "/restaurant/${restaurant_id}/";
    private final static String RESTAURANT_BINDING = "/restaurant/binding/";
    private final static String RESTAURANT_OWN = "/restaurant/own/";
    private final static String RESTAURANT_RESTAURANT_ID_INFO = "/restaurant/${restaurant_id}/info/";
    private final static String RESTAURANT_RESTAURANT_ID_BUSINESS_STATUS = "/restaurant/${restaurant_id}/business_status/";
    private final static String RESTAURANT_RESTAURANT_ID_ORDER_MODE = "/restaurant/${restaurant_id}/order_mode/";
    private final static String RESTAURANTS_BATCH_STATUS = "/restaurants/batch_status/";
    private final static String RESTAURANT_RESTAURANT_ID_PRODUCT_PROFILE = "/restaurant/${restaurant_id}/product_profile/";

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
        return jsonArray.stream().map(obj -> TypeUtils.castToJavaBean(obj, FoodCategoryDetail.class)).collect(toList());
    }

    @Override
    public Restaurant get(Long restaurantId) throws ElemeErrorException {
        if (restaurantId == null) {
            throw new ElemeErrorException(-1, "restaurant_id is required.");
        }
        Restaurant restaurant = execute(HTTP_METHOD_GET, RESTAURANT_RESTAURANT_ID,
                new HashMap<String, String>() {{
                    put("restaurant_id", String.valueOf(restaurantId));
                }}).getObject("restaurant", Restaurant.class);
        restaurant.setId(restaurantId);
        return restaurant;
    }

    @Override
    public void binding(Long restaurantId, String tpRestaurantId) throws ElemeErrorException {
        Map<String, String> params = getBindingParams(restaurantId, tpRestaurantId);
        execute(HTTP_METHOD_POST, RESTAURANT_BINDING, params);
    }


    @Override
    public void rebinding(Long restaurantId, String tpRestaurantId) throws ElemeErrorException {
        Map<String, String> params = getBindingParams(restaurantId, tpRestaurantId);
        execute(HTTP_METHOD_PUT, RESTAURANT_BINDING, params);
    }

    private Map<String, String> getBindingParams(Long restaurantId, String tpRestaurantId) throws ElemeErrorException {
        if (restaurantId == null) {
            throw new ElemeErrorException(-1, "restaurant_id is required.");
        }
        if (tpRestaurantId == null) {
            throw new ElemeErrorException(-1, "tp_restaurant_id is required.");
        }
        Map<String, String> params = new HashMap<>();
        params.put("restaurant_id", String.valueOf(restaurantId));
        params.put("tp_restaurant_id", String.valueOf(tpRestaurantId));
        return params;
    }

    @Override
    public Long getIdByTpRestaurantId(String tpRestaurantId) throws ElemeErrorException {
        Map<String, String> params = new HashMap<>();
        params.put("tp_restaurant_id", String.valueOf(tpRestaurantId));
        try {
            return execute(HTTP_METHOD_GET, RESTAURANT_BINDING, params).getLong("restaurant_id");
        } catch (ElemeErrorException e) {
            if (e.getCode() == 1004) {
                return null;
            }
            throw e;
        }
    }

    @Override
    public List<Long> getIds() throws ElemeErrorException {
        return execute(HTTP_METHOD_GET, RESTAURANT_OWN, new HashMap<>())
                .getJSONArray("restaurants").stream().map(s -> TypeUtils.castToLong(s)).collect(Collectors.toList());
    }

    @Override
    public void update(RestaurantSave restaurantSave) throws ElemeErrorException {
        execute(HTTP_METHOD_PUT, RESTAURANT_RESTAURANT_ID_INFO, restaurantSave);
    }

    @Override
    public void setIsOpen(Long restaurantId, boolean isOpen) throws ElemeErrorException {
        if (restaurantId == null) {
            throw new ElemeErrorException(-1, "restaurant_id is required.");
        }
        Map<String, String> params = new HashMap<>();
        params.put("restaurant_id", String.valueOf(restaurantId));
        params.put("is_open", isOpen ? "1" : "0");
        execute(HTTP_METHOD_PUT, RESTAURANT_RESTAURANT_ID_BUSINESS_STATUS, params);
    }

    @Override
    public void updateOrderMode(Long restaurantId, Short orderMode) throws ElemeErrorException {
        if (restaurantId == null) {
            throw new ElemeErrorException(-1, "restaurant_id is required.");
        }
        if (orderMode == null) {
            throw new ElemeErrorException(-1, "order_mode is required.");
        }
        Map<String, String> params = new HashMap<>();
        params.put("restaurant_id", String.valueOf(restaurantId));
        params.put("order_mode", String.valueOf(orderMode));
        execute(HTTP_METHOD_PUT, RESTAURANT_RESTAURANT_ID_ORDER_MODE, params);
    }

    @Override
    public List<RestaurantStatus> getStatus(List<Long> restaurantIds) throws ElemeErrorException {
        if (restaurantIds == null || restaurantIds.isEmpty()) {
            return Collections.emptyList();
        }
        Map<String, String> params = new HashMap<>();
        params.put("restaurant_ids", StringUtils.join(restaurantIds.stream().map(String::valueOf).collect(toList()), ","));

        JSONObject jsonObject = execute(HTTP_METHOD_GET, RESTAURANTS_BATCH_STATUS, params).getJSONObject("batch_status");
        return jsonObject.entrySet().stream().filter(o->o.getValue() instanceof JSONObject).map(o-> {
            RestaurantStatus status = new RestaurantStatus();
            status.setRestaurant_id(Long.valueOf(o.getKey()));
            JSONObject json = (JSONObject)o.getValue();
            status.setIs_open(json.getShort("is_open"));
            status.setIs_valid(json.getShort("is_valid"));
            status.setOrder_mode(json.getShort("order_mode"));
            return status;
        }).collect(toList());
    }

    @Override
    public RestaurantProductProfile getProductProfile(Long restaurantId) throws ElemeErrorException {
        if (restaurantId == null) {
            return null;
        }
        Map<String, String> params = new HashMap<>();
        params.put("restaurant_id", String.valueOf(restaurantId));
        try {
            JSONObject jsonObject = execute(HTTP_METHOD_GET, RESTAURANT_RESTAURANT_ID_PRODUCT_PROFILE, params);
            return jsonObject.getObject("restaurant_product_profile", RestaurantProductProfile.class);
        } catch (ElemeErrorException e) {
            if (e.getCode() == 1004) {
                return null;
            }
            throw e;
        }
    }

}
