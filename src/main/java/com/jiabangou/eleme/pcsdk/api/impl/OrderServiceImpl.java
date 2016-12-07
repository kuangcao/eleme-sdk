package com.jiabangou.eleme.pcsdk.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.pcsdk.ElemePCConfigStorage;
import com.jiabangou.eleme.pcsdk.PCLogListener;
import com.jiabangou.eleme.pcsdk.api.OrderService;
import com.jiabangou.eleme.pcsdk.model.Order;
import com.jiabangou.eleme.pcsdk.model.RefuseOrder;
import com.jiabangou.eleme.pcsdk.model.RefuseReason;
import okhttp3.OkHttpClient;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 订单服务实现
 * Created by freeway on 2016/12/6.
 */
public class OrderServiceImpl extends PCBaseServiceImpl implements OrderService {

    public OrderServiceImpl(OkHttpClient client, ElemePCConfigStorage configStorage, PCLogListener logListener) {
        super(client, configStorage, logListener);
    }

    @Override
    public List<Long> getNewOrderIds() {
        JSONObject params = new JSONObject();
        params.put("shopId", configStorage.getShopId());
        JSONObject json = (JSONObject)execute(API.POLLING_SERVICE_POLLING_FOR_HIGH_FREQUENCY, params);
        return json.getJSONArray("newOrderIds").stream().map(obj->Long.parseLong(obj.toString())).collect(toList());
    }

    @Override
    public List<Order> getUnprocessedOrders() {
        JSONObject params = new JSONObject();
        params.put("shopId", configStorage.getShopId());
        params.put("orderFilter", "UNPROCESSED_ORDERS");
        params.put("condition", new JSONObject());
        JSONArray json = (JSONArray)execute(API.ORDER_SERVICE_QUERY_ORDER, params);
        return json.stream().map(obj-> TypeUtils.castToJavaBean(obj, Order.class)).collect(toList());
    }

    @Override
    public void confirm(Long orderId) {
        JSONObject params = new JSONObject();
        params.put("orderId", orderId);
        execute(API.ORDER_SERVICE_CONFIRM_ORDER, params);
    }

    @Override
    public RefuseOrder refuse(Long orderId, RefuseReason refuseReason, String remark) {
        JSONObject params = new JSONObject();
        params.put("orderId", orderId);
        params.put("remark", remark);
        params.put("typeCode", refuseReason.getTypeCode());
        return TypeUtils.castToJavaBean(execute(API.ORDER_SERVICE_INVALIDATE_ORDER, params), RefuseOrder.class);
    }
}
