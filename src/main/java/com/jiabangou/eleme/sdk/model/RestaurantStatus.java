package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;

/**
 * 餐厅的状态
 * Created by freeway on 16/7/21.
 */
public class RestaurantStatus implements Serializable {
    /**
     * 餐厅id
     */
    private Long restaurant_id;
    /**
     * is_open	含义
     *  0	关店
     *  1	开店
     */
    private Short is_open;
    /**
     * 是否有效
     */
    private Short is_valid;

    /**
     * 参考 OrderMode
     */
    private Short order_mode;


    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public Short getIs_open() {
        return is_open;
    }

    public void setIs_open(Short is_open) {
        this.is_open = is_open;
    }

    public Short getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(Short is_valid) {
        this.is_valid = is_valid;
    }

    public Short getOrder_mode() {
        return order_mode;
    }

    public void setOrder_mode(Short order_mode) {
        this.order_mode = order_mode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantStatus that = (RestaurantStatus) o;

        return restaurant_id != null ? restaurant_id.equals(that.restaurant_id) : that.restaurant_id == null;

    }

    @Override
    public int hashCode() {
        return restaurant_id != null ? restaurant_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RestaurantStatus{" +
                "order_mode=" + order_mode +
                ", is_valid=" + is_valid +
                ", is_open=" + is_open +
                ", restaurant_id=" + restaurant_id +
                '}';
    }
}
