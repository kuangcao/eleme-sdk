package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.pcsdk.PCServiceTest;
import com.jiabangou.eleme.pcsdk.model.RefuseReason;
import org.junit.Test;

/**
 * 获取新订单列表
 * Created by freeway on 2016/12/6.
 */
public class OrderServiceTest extends PCServiceTest {

    @Test
    public void testGetNewOrderIds() {
        System.out.println(elemeClient.getOrderService().getNewOrderIds());
    }

    @Test
    public void testConfirm() {
        elemeClient.getOrderService().confirm(101716227291104580L);
    }

    @Test
    public void testRefuse() {
        elemeClient.getOrderService().refuse(101716227291104580L, RefuseReason.DELIVERY_FAULT, "hehe");
    }

    @Test
    public void testGetUnprocessedOrders() {
        System.out.println(elemeClient.getOrderService().getUnprocessedOrders());
    }

}
