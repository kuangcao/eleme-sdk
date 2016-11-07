package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.LogListener;
import com.jiabangou.eleme.sdk.api.OrderService;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Order;
import com.jiabangou.eleme.sdk.model.OrderDelivery;
import com.jiabangou.eleme.sdk.model.OrderStatus;
import okhttp3.OkHttpClient;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by freeway on 16/7/18.
 */
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

    private final static String ORDER_ELEME_ORDER_ID_STATUS = "/order/${eleme_order_id}/status/";

    private final static String ORDER_ELEME_ORDER_ID = "/order/${eleme_order_id}/";
    private final static String ORDER_ELEME_ORDER_ID_AGREE_REFUND = "/order/${eleme_order_id}/agree_refund/";
    private final static String ORDER_ELEME_ORDER_ID_DISAGREE_REFUND = "/order/${eleme_order_id}/disagree_refund/";
    private final static String ORDER_NEW = "/order/new/";
    private final static String ORDERS_BATCH_GET = "/orders/batch_get/";
    private final static String ORDER_DELIVERY = "/order/delivery/";

    public OrderServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage, LogListener logListener) {
        super(client, configStorage, logListener);
    }


    @Override
    public Order get(Long elemeOrderId) throws ElemeErrorException {

        if (elemeOrderId == null) {
            throw new ElemeErrorException(-1, "eleme_order_id is required.");
        }

        JSONObject jsonObject = execute(HTTP_METHOD_GET, ORDER_ELEME_ORDER_ID, new HashMap<String, String>() {{
            put("eleme_order_id", String.valueOf(elemeOrderId));
            put("tp_id", "1");
        }});

        return TypeUtils.castToJavaBean(jsonObject, Order.class);
    }

    @Override
    public void cancel(Long elemeOrderId, String reason) throws ElemeErrorException {
        if (elemeOrderId == null) {
            throw new ElemeErrorException(-1, "eleme_order_id is required.");
        }
        execute(HTTP_METHOD_PUT, ORDER_ELEME_ORDER_ID_STATUS, new HashMap<String, String>() {{
            put("eleme_order_id", String.valueOf(elemeOrderId));
            put("status", String.valueOf(OrderStatus.STATUS_CODE_INVALID));
            put("reason", reason);
        }});
    }


    @Override
    public void confirm(Long elemeOrderId) throws ElemeErrorException {
        if (elemeOrderId == null) {
            throw new ElemeErrorException(-1, "eleme_order_id is required.");
        }
        execute(HTTP_METHOD_PUT, ORDER_ELEME_ORDER_ID_STATUS, new HashMap<String, String>() {{
            put("eleme_order_id", String.valueOf(elemeOrderId));
            put("status", String.valueOf(OrderStatus.STATUS_CODE_PROCESSED_AND_VALID));
        }});
    }

    @Override
    public void complete(Long elemeOrderId) throws ElemeErrorException {
        if (elemeOrderId == null) {
            throw new ElemeErrorException(-1, "eleme_order_id is required.");
        }
        execute(HTTP_METHOD_PUT, ORDER_ELEME_ORDER_ID_STATUS, new HashMap<String, String>() {{
            put("eleme_order_id", String.valueOf(elemeOrderId));
            put("status", String.valueOf(OrderStatus.STATUS_CODE_FINISHED));
        }});
    }


    @Override
    public List<Long> getNewOrderIds() throws ElemeErrorException {
        return getNewOrderIdsByRestaurantId(null);
    }

    @Override
    public List<Long> getNewOrderIdsByRestaurantId(Long restaurantId) throws ElemeErrorException {
        Map<String, String> params = new HashMap<String, String>();
        if (restaurantId != null) {
            params.put("restaurant_id", String.valueOf(restaurantId));
        }
        return execute(HTTP_METHOD_GET, ORDER_NEW, params).getJSONArray("order_ids")
                .stream().map(s -> Long.valueOf(s.toString())).collect(Collectors.toList());
    }

    @Override
    public List<Long> getOrderIdsByStatus(Long restaurantId, String day, Set<Short> statuses) throws ElemeErrorException {

        if (restaurantId == null) {
            throw new ElemeErrorException(-1, "restaurantId is required.");
        }
        if (day == null) {
            throw new ElemeErrorException(-1, "day is required.");
        }
        if (statuses == null || statuses.isEmpty()) {
            throw new ElemeErrorException(-1, "statuses is required.");
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("restaurant_id", String.valueOf(restaurantId));
        params.put("day", day);
        params.put("statuses", StringUtils.join(statuses.stream().map(String::valueOf).collect(Collectors.toList()), ","));
        return execute(HTTP_METHOD_GET, ORDERS_BATCH_GET, params).getJSONArray("order_ids")
                .stream().map(s -> Long.valueOf(s.toString())).collect(Collectors.toList());
    }

    @Override
    public void agreeRefund(Long elemeOrderId) throws ElemeErrorException {
        if (elemeOrderId == null) {
            throw new ElemeErrorException(-1, "eleme_order_id is required.");
        }
        execute(HTTP_METHOD_PUT, ORDER_ELEME_ORDER_ID_AGREE_REFUND, new HashMap<String, String>() {{
            put("eleme_order_id", String.valueOf(elemeOrderId));
        }});
    }

    @Override
    public void disagreeRefund(Long elemeOrderId, String reason) throws ElemeErrorException {
        if (elemeOrderId == null) {
            throw new ElemeErrorException(-1, "eleme_order_id is required.");
        }
        execute(HTTP_METHOD_PUT, ORDER_ELEME_ORDER_ID_DISAGREE_REFUND, new HashMap<String, String>() {{
            put("eleme_order_id", String.valueOf(elemeOrderId));
            if (reason != null) {
                put("reason", reason);
            }
        }});
    }

    @Override
    public List<OrderDelivery> getOrderDeliveriesByOrderIds(List<Long> elemeOrderIds) throws ElemeErrorException {
        if (elemeOrderIds == null || elemeOrderIds.isEmpty()) {
            return Collections.emptyList();
        }
        JSONArray jsonArray = executeToJSONArray(HTTP_METHOD_GET, ORDER_DELIVERY, new HashMap<String, String>() {{
            put("eleme_order_ids", StringUtils.join(elemeOrderIds, ","));
        }});
        return jsonArray.stream().map(s->TypeUtils.castToJavaBean(s, OrderDelivery.class))
                .filter(s->s.getEleme_order_id()!=null).collect(Collectors.toList());
    }
}
