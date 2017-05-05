package com.jiabangou.eleme.pcsdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.pcsdk.ElemePCConfigStorage;
import com.jiabangou.eleme.pcsdk.PCLogListener;
import com.jiabangou.eleme.pcsdk.api.DeliveryService;
import com.jiabangou.eleme.pcsdk.model.RiderLocation;
import okhttp3.OkHttpClient;

/**
 * 配送服务实现
 * Created by freeway on 2016/12/12.
 */
public class DeliveryServiceImpl extends PCBaseServiceImpl implements DeliveryService {

    public DeliveryServiceImpl(OkHttpClient client, ElemePCConfigStorage configStorage, PCLogListener logListener) {
        super(client, configStorage, logListener);
    }

    @Override
    public RiderLocation getRiderLocation(Long orderId) {
        JSONObject params = new JSONObject();
        params.put("orderId", orderId);
        return TypeUtils.castToJavaBean(execute(API.DELIVERY_SERVICE_GET_RIDER_LOCATION, params), RiderLocation.class);
    }

}
