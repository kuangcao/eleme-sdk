package com.jiabangou.eleme.sdk.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public enum ElemeErrorCode implements Serializable {

    PERMISSION_DENIED(1000, "权限错误"),
    SIGNATURE_ERROR(1001, "签名错误"),
    SYSTEM_PARAM_ERROR(1002, "系统级参数错误"),
    INVALID_CONSUMER(1003, "非法用户"),
    INVALID_REQUEST_PARAM(1004, "非法请求参数"),
    INVALID_ONLINE_PAYMENT_ORDER_VALIDATION(1005, "在线支付订单验证错误"),
    SYSTEM_ERROR(1006, "系统错误"),
    ELEME_SYSTEM_ERROR(1007, "饿了么业务系统错误"),
    OPENAPI_SYSTEM_ERROR(1008, "开放平台错误"),
    RATE_LIMIT_REACHED(1009, "超过请求限制"),
    GPG_KEY_NOT_FOUND(1010, "GnuPG公钥未找到"),
    APPLICATION_NOT_FOUND(1011, "开放平台应用未找到"),
    ORDER_NOT_FOUND(1012, "订单未找到"),
    ORDER_CANCELED(1013, "订单已取消"),
    INVALID_GEO(1014, "无效地理位置"),
    ORDER_EXISTED(1015, "订单已存在"),
    FOOD_EXISTED(1016, "食物已存在"),
    IMAGE_UPLOAD_ERROR(1017, "图片上传失败"),
    INVALID_ORDER_STATUS(1018, "无效的订单状态"),
    INVALID_FOOD_CATEGORY(1019, "无效的食物分类"),
    INVALID_FOOD(1020, "无效的食物"),
    COMMENT_REPLY_ERROR(1021, "已回复评论")

    ;

    private Integer code;
    private String msg;

    ElemeErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
