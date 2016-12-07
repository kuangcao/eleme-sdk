package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.pcsdk.PCServiceTest;
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
    public void testGetUnprocessedOrders() {
        System.out.println(elemeClient.getOrderService().getUnprocessedOrders());
    }

}
