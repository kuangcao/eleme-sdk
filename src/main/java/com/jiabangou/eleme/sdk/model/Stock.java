package com.jiabangou.eleme.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by freeway on 16/7/17.
 */
public class Stock implements Serializable {

    private String tp_restaurant_id;
    private String tp_food_id;

    private Integer stock;

    public String getTp_restaurant_id() {
        return tp_restaurant_id;
    }

    public void setTp_restaurant_id(String tp_restaurant_id) {
        this.tp_restaurant_id = tp_restaurant_id;
    }

    public String getTp_food_id() {
        return tp_food_id;
    }

    public void setTp_food_id(String tp_food_id) {
        this.tp_food_id = tp_food_id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock1 = (Stock) o;

        if (tp_restaurant_id != null ? !tp_restaurant_id.equals(stock1.tp_restaurant_id) : stock1.tp_restaurant_id != null)
            return false;
        if (tp_food_id != null ? !tp_food_id.equals(stock1.tp_food_id) : stock1.tp_food_id != null) return false;
        return stock != null ? stock.equals(stock1.stock) : stock1.stock == null;

    }

    @Override
    public int hashCode() {
        int result = tp_restaurant_id != null ? tp_restaurant_id.hashCode() : 0;
        result = 31 * result + (tp_food_id != null ? tp_food_id.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "tp_restaurant_id='" + tp_restaurant_id + '\'' +
                ", tp_food_id='" + tp_food_id + '\'' +
                ", stock=" + stock +
                '}';
    }
}
