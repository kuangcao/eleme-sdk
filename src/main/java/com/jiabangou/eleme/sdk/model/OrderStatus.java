package com.jiabangou.eleme.sdk.model;

/**
 * 订单状态
 * Created by freeway on 16/7/18.
 */
public enum OrderStatus {

    /**
     * 订单已取消
     */
    STATUS_CODE_INVALID(-1),
    /**
     * 订单未处理
     */
    STATUS_CODE_UNPROCESSED(0),
    /**
     * 订单等待餐厅确认
     */
    STATUS_CODE_PROCESSING(1),
    /**
     * 订单已处理
     */
    STATUS_CODE_PROCESSED_AND_VALID(4);

    private int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
