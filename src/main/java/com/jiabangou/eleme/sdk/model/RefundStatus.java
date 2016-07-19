package com.jiabangou.eleme.sdk.model;

/**
 * 退单状态
 * Created by freeway on 16/7/19.
 */
public class RefundStatus {

    /**
     * (未申请退单)
     */
    public final static Short REFUND_STATUS_NO_REFUND = 0;
    /**
     * (用户申请退单)
     */
    public final static Short REFUND_STATUS_LATER_REFUND_REQUEST = 2;
    /**
     * （餐厅不同意退单）
     */
    public final static Short REFUND_STATUS_LATER_REFUND_RESPONSE = 3;
    /**
     * (退单仲裁中)
     */
    public final static Short REFUND_STATUS_LATER_REFUND_ARBITRATING = 4;
    /**
     * (退单失败)
     */
    public final static Short REFUND_STATUS_LATER_REFUND_FAIL = 5;
    /**
     * (退单成功)
     */
    public final static Short REFUND_STATUS_LATER_REFUND_SUCCESS = 6;
}
