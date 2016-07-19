package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;

/**
 * Created by freeway on 16/7/18.
 */
public class Order implements Serializable {

    /**
     * 顾客送餐地址
     */
    private String address;
    /**
     * 下单时间
     */
    private String created_at;
    /**
     * 	datetime	订单生效时间(即支付时间)
     */
    private String active_at;
    /**
     * 	float	配送费
     */
    private Float deliver_fee;
    /**
     * 	datetime	送餐时间
     */
    private String deliver_time;
    /**
     * 	int	配送状态（仅用于第三方配送）
     */
    private int deliver_status;
    /**
     * 	string	订单备注
     */
    private String description;

}
