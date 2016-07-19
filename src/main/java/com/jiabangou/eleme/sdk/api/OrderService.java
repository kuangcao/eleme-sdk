package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 订单服务
 * Created by freeway on 16/7/11.
 */
public interface OrderService {


    /**
     * 获取饿了么订单
     * @param elemeOrderId
     * @return
     * @throws ElemeErrorException
     */
    Order get(Long elemeOrderId) throws ElemeErrorException;

    /**
     * 查询总账号的新订单
     * @return
     * @throws ElemeErrorException
     */
    List<Long> getNewOrderIds() throws ElemeErrorException;

    /**
     * 查询对应餐厅的新订单
     * @param restaurantId
     * @return
     * @throws ElemeErrorException
     */
    List<Long> getNewOrderIdsByRestaurantId(Long restaurantId) throws ElemeErrorException;

    /**
     * 根据餐厅，日期，状态批量获取订单id
     *
     * @param restaurantId
     * @param day
     * @param statuses see OrderStatus
     * @return
     * @throws ElemeErrorException
     */
    List<Long> getOrderIdsByStatus(Long restaurantId, String day, Set<Short> statuses) throws ElemeErrorException;

    /**
     * 取消订单
     * @param elemeOrderId
     * @param reason 理由
     * @throws ElemeErrorException
     */
    void cancel(Long elemeOrderId, String reason) throws ElemeErrorException;

    /**
     * 确认订单
     * @param elemeOrderId
     * @throws ElemeErrorException
     */
    void confirm(Long elemeOrderId) throws ElemeErrorException;

    /**
     *
     * @param elemeOrderId
     * @throws ElemeErrorException
     */
    void agreeRefund(Long elemeOrderId) throws ElemeErrorException;

    /**
     *
     * @param elemeOrderId
     * @param reason
     * @throws ElemeErrorException
     */
    void disagreeRefund(Long elemeOrderId, String reason) throws ElemeErrorException;

    /**
     * 批量获取订单的配送信息
     * @param elemeOrderIds
     * @return
     * @throws ElemeErrorException
     */
    List<OrderDelivery> getOrderDeliveriesByOrderIds(List<Long> elemeOrderIds) throws ElemeErrorException;
}
