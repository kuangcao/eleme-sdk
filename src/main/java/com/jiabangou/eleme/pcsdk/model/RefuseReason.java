package com.jiabangou.eleme.pcsdk.model;

/**
 * 拒绝理由
 * Created by freeway on 2016/12/7.
 */
public enum RefuseReason {

    FOOD_SOLD_OUT("FOOD_SOLD_OUT", "商品已经售完"),
    RESTAURANT_CLOSED("RESTAURANT_CLOSED", "商家已经打烊"),
    RESTAURANT_TOO_BUSY("RESTAURANT_TOO_BUSY", "商家现在太忙"),
    NOT_SATISFIED_DELIVERY_REQUIREMENT("NOT_SATISFIED_DELIVERY_REQUIREMENT", "不满足起送要求"),
    DISTANCE_TOO_FAR("DISTANCE_TOO_FAR", "超出配送范围"),
    DELIVERY_FAULT("DELIVERY_FAULT", "配送出现问题"),
    FORCE_REJECT_ORDER("FORCE_REJECT_ORDER", "用户申请取消"),
    CONTACT_USER_FAILED("CONTACT_USER_FAILED", "联系不上用户"),
    FAKE_ORDER("FAKE_ORDER", "用户信息不符"),
    OTHERS("OTHERS", "其他原因"),

    ;

    private String typeCode;
    private String description;


    RefuseReason(String typeCode, String description) {
        this.typeCode = typeCode;
        this.description = description;
    }

    public String getTypeCode() {
        return typeCode;
    }


    public String getDescription() {
        return description;
    }

}
