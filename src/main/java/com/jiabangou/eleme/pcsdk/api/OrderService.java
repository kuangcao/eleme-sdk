package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.pcsdk.model.Order;
import com.jiabangou.eleme.pcsdk.model.RefuseOrder;
import com.jiabangou.eleme.pcsdk.model.RefuseReason;

import java.util.List;

/**
 * 订单服务
 * Created by freeway on 2016/12/6.
 */
public interface OrderService {

    /**
     * 新订单id
     * @return
     */
    List<Long> getNewOrderIds();

    /**
     * 未接单列表
     * @return
     */
    List<Order> getUnprocessedOrders();

    /**
     * 接单
     * @param orderId 订单号
     */
    void confirm(Long orderId);

    /**
     * 拒绝接单、取消订单, 即便接单后也可以取消
     * @param orderId 订单号
     * @param refuseReason 拒绝理由
     * @param remark 备注
     */
    RefuseOrder refuse(Long orderId, RefuseReason refuseReason, String remark);
}
