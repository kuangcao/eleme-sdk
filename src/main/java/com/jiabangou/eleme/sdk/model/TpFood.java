package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;

/**
 * Created by freeway on 16/7/17.
 */
public class TpFood implements Serializable {

    private String tp_food_id;
    private String tp_restaurant_id;
    private Long restaurant_id;
    private Long food_id;

    public String getTp_restaurant_id() {
        return tp_restaurant_id;
    }

    public void setTp_restaurant_id(String tp_restaurant_id) {
        this.tp_restaurant_id = tp_restaurant_id;
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public Long getFood_id() {
        return food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
    }

    public String getTp_food_id() {
        return tp_food_id;
    }

    public void setTp_food_id(String tp_food_id) {
        this.tp_food_id = tp_food_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpFood tpFood = (TpFood) o;

        if (tp_restaurant_id != null ? !tp_restaurant_id.equals(tpFood.tp_restaurant_id) : tpFood.tp_restaurant_id != null)
            return false;
        if (restaurant_id != null ? !restaurant_id.equals(tpFood.restaurant_id) : tpFood.restaurant_id != null)
            return false;
        if (food_id != null ? !food_id.equals(tpFood.food_id) : tpFood.food_id != null) return false;
        return tp_food_id != null ? tp_food_id.equals(tpFood.tp_food_id) : tpFood.tp_food_id == null;

    }

    @Override
    public int hashCode() {
        int result = tp_restaurant_id != null ? tp_restaurant_id.hashCode() : 0;
        result = 31 * result + (restaurant_id != null ? restaurant_id.hashCode() : 0);
        result = 31 * result + (food_id != null ? food_id.hashCode() : 0);
        result = 31 * result + (tp_food_id != null ? tp_food_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TpFood{" +
                "tp_restaurant_id='" + tp_restaurant_id + '\'' +
                ", restaurant_id=" + restaurant_id +
                ", food_id=" + food_id +
                ", tp_food_id='" + tp_food_id + '\'' +
                '}';
    }
}
