package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.model.Order;

import java.util.List;

/**
 * 推送处理接口, 需要业务自己实现推送后的处理
 * Created by freeway on 16/7/19.
 */
public interface PushProcessor {

    /**
     * 收到新订单
     * @param orders
     */
    void newOrder(List<Order> orders);

    /**
     * 订单状态变更推送接收
     *
     * @param order
     * @param tpOrderId
     * @param newStatus
     * @param extra
     */
    void orderStatusUpdate(Order order, String tpOrderId, Short newStatus, String extra);

    /**
     * 退单状态推送
     * @param order
     * @param refundtatus 参考 http://merchant.openapi.eleme.io/appendix/enums.html#enum-refund-order-status
     */
    void refundOrder(Order order, Short refundtatus);

    /**
     * 订单配送状态推送
     * @param order
     * @param statusCode
     * @param subStatusCode
     * @param name
     * @param phone
     * @param updatedAt
     */
    void delivery(Order order, Short statusCode, Short subStatusCode, String name, String phone, Long updatedAt);
}
