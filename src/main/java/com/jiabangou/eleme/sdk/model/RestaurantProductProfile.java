package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;

/**
 * 餐厅的标品信息
 * Created by freeway on 16/7/21.
 */
public class RestaurantProductProfile implements Serializable {
    /**
     * 比如: 饿配送
     */
    private String product_name;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "RestaurantProductProfile{" +
                "product_name='" + product_name + '\'' +
                '}';
    }
}
