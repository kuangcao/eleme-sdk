package com.jiabangou.eleme.sdk.model;

/**
 * Created by freeway on 16/7/19.
 */
public class DeliveryStatus {

    /**
     * 待分配（物流系统已生成运单，待分配配送商）
     */
    public final static Short TO_BE_ASSIGNED_MERCHANT = 1;
    /**
     * 待分配（配送系统已接单，待分配配送员）
     */
    public final static Short TO_BE_ASSIGNED_COURIER = 2;
    /**
     * 待取餐（已分配给配送员，配送员未取餐）
     */
    public final static Short TO_BE_FETCHED = 3;
    /**
     * 配送中（配送员已取餐，正在配送）
     */
    public final static Short DELIVERING = 4;
    /**
     * 配送成功（配送员配送完成）
     */
    public final static Short COMPLETED = 5;
    /**
     * 配送取消（商家可以重新发起配送）
     */
    public final static Short CANCELLED = 6;
    /**
     * 配送异常
     */
    public final static Short EXCEPTION = 7;

}
