package com.jiabangou.eleme.sdk.model;

/**
 * 配送子状态(当配送状态为CANCELLED或者EXCEPTION使用)
 * Created by freeway on 16/7/19.
 */
public class DeliverySubStatus {
    /**
     * 商家取消
     */
    public final static Short MERCHANT_REASON = 1;
    /**
     * 配送商取消
     */
    public final static Short CARRIER_REASON = 2;
    /**
     * 用户取消
     */
    public final static Short USER_REASON = 3;
    /**
     * 物流系统取消
     */
    public final static Short SYSTEM_REASON = 4;
    /**
     * 呼叫配送晚
     */
    public final static Short MERCHANT_CALL_LATE_ERROR = 5;
    /**
     * 餐厅出餐问题
     */
    public final static Short MERCHANT_FOOD_ERROR = 6;
    /**
     * 商户中断配送
     */
    public final static Short MERCHANT_INTERRUPT_DELIVERY_ERROR = 7;
    /**
     * 用户不接电话
     */
    public final static Short USER_NOT_ANSWER_ERROR = 8;
    /**
     * 用户退单
     */
    public final static Short USER_RETURN_ORDER_ERROR = 9;
    /**
     * 用户地址错误
     */
    public final static Short USER_ADDRESS_ERROR = 10;
    /**
     * 超出服务范围
     */
    public final static Short DELIVERY_OUT_OF_SERVICE = 11;
    /**
     * 骑手标记异常
     */
    public final static Short CARRIER_REMARK_EXCEPTION_ERROR = 12;
    /**
     * 系统自动标记异常–订单超过3小时未送达
     */
    public final static Short SYSTEM_MARKED_ERROR = 13;
    /**
     * 其他异常
     */
    public final static Short OTHER_ERROR = 14;

}
