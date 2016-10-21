package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.OrderStatus;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by freeway on 16/7/19.
 */
public class OrderServiceTest extends ServiceTest {

    @Test
    public void testGetNewOrderIds() throws ElemeErrorException {
        System.out.println(elemeClient.getOrderService().getNewOrderIds());
        System.out.println(elemeClient.getOrderService().getNewOrderIdsByRestaurantId(804622L));
    }

    @Test
    public void testGetOrderIdsByStatus() throws ElemeErrorException {
        Set<Short> statuses = new HashSet<Short>() {{
            add(OrderStatus.STATUS_CODE_INVALID);
            add(OrderStatus.STATUS_CODE_PROCESSED_AND_VALID);
            add(OrderStatus.STATUS_CODE_PROCESSING);
            add(OrderStatus.STATUS_CODE_UNPROCESSED);
        }};
        String day = "2016-07-08";
        System.out.println(elemeClient.getOrderService().getOrderIdsByStatus(804622L, day, statuses));

        statuses = new HashSet<Short>() {{
            add(OrderStatus.STATUS_CODE_INVALID);
        }};
        System.out.println(elemeClient.getOrderService().getOrderIdsByStatus(804622L, day, statuses));


        statuses = new HashSet<Short>() {{
            add(OrderStatus.STATUS_CODE_PROCESSED_AND_VALID);
        }};
        System.out.println(elemeClient.getOrderService().getOrderIdsByStatus(804622L, day, statuses));
    }

    @Test
    public void testCancel() throws ElemeErrorException {
        elemeClient.getOrderService().cancel(100902308048030522L, "测试");
    }

    @Test
    public void testAgreeRefund() throws ElemeErrorException {
        elemeClient.getOrderService().agreeRefund(100902308048030522L);
    }

    @Test
    public void testDisagreeRefund() throws ElemeErrorException {
        elemeClient.getOrderService().disagreeRefund(100902308048030522L, "测试");
    }

    @Test
    public void testGetOrderDeliveriesByOrderIds() throws ElemeErrorException {
        OrderService orderService = elemeClient.getOrderService();
        Set<Short> statuses = new HashSet<Short>() {{
            add(OrderStatus.STATUS_CODE_INVALID);
        }};
        String day = "2016-07-08";
        System.out.println(orderService.getOrderDeliveriesByOrderIds(
                orderService.getOrderIdsByStatus(804622L, day, statuses)));
    }

    @Test
    public void testGet() throws ElemeErrorException {
        OrderService orderService = elemeClient.getOrderService();
        System.out.println(orderService.get(101078974172647476L));
    }


}
