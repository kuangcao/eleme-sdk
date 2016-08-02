package com.jiabangou.eleme.sdk.model;

/**
 * 退单状态
 * Created by freeway on 16/7/19.
 */
public interface RefundStatus {

    /**
     * (未申请退单)
     */
    short REFUND_STATUS_NO_REFUND = 0;
    /**
     * (用户申请退单)
     */
    short REFUND_STATUS_LATER_REFUND_REQUEST = 2;
    /**
     * （餐厅不同意退单）
     */
    short REFUND_STATUS_LATER_REFUND_RESPONSE = 3;
    /**
     * (退单仲裁中)
     */
    short REFUND_STATUS_LATER_REFUND_ARBITRATING = 4;
    /**
     * (退单失败)
     */
    short REFUND_STATUS_LATER_REFUND_FAIL = 5;
    /**
     * (退单成功)
     */
    short REFUND_STATUS_LATER_REFUND_SUCCESS = 6;
}
