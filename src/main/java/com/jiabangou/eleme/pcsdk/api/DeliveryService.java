package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.pcsdk.model.RiderLocation;

/**
 * 配送服务
 * Created by freeway on 2016/12/12.
 */
public interface DeliveryService {

    /**
     * 获取骑士的地理位置
     * @param orderId 订单id
     * @return 骑士地理位置
     */
    RiderLocation getRiderLocation(Long orderId);

}
