package com.jiabangou.eleme.pcsdk.model;

/**
 * 订单对象
 * 对应返回的json
 *
 * Created by freeway on 2016/12/6.
 */
public class RefuseOrder extends Order {

    private String cancelStatus;
    private String cancelOrderDescription;
    private String refundStatus;

    public String getCancelStatus() {
        return cancelStatus;
    }

    public RefuseOrder setCancelStatus(String cancelStatus) {
        this.cancelStatus = cancelStatus;
        return this;
    }

    public String getCancelOrderDescription() {
        return cancelOrderDescription;
    }

    public RefuseOrder setCancelOrderDescription(String cancelOrderDescription) {
        this.cancelOrderDescription = cancelOrderDescription;
        return this;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public RefuseOrder setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
        return this;
    }

    @Override
    public String toString() {
        return "RefuseOrder{" +
                "cancelStatus='" + cancelStatus + '\'' +
                ", cancelOrderDescription='" + cancelOrderDescription + '\'' +
                ", refundStatus='" + refundStatus + '\'' +
                '}';
    }
}
