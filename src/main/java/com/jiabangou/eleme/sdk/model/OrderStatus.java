package com.jiabangou.eleme.sdk.model;

/**
 * 订单状态
 * Created by freeway on 16/7/18.
 */
public class OrderStatus {

    /**
     * 订单已取消
     */
    public final static Short STATUS_CODE_INVALID = -1;
    /**
     * 订单未处理
     */
    public final static Short STATUS_CODE_UNPROCESSED = 0;
    /**
     * 订单等待餐厅确认
     */
    public final static Short STATUS_CODE_PROCESSING = 1;
    /**
     * 订单已处理
     */
    public final static Short STATUS_CODE_PROCESSED_AND_VALID = 2;

    /**
     * 订单已完成
     */
    public final static Short STATUS_CODE_FINISHED = 9;

}
