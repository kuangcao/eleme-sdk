package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;

/**
 * Created by freeway on 16/7/13.
 */
public class FoodCategorySave implements Serializable {

    private Long food_category_id;

    private Long restaurant_id;

    private String name;

    private Integer weight;

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Long getFood_category_id() {
        return food_category_id;
    }

    public void setFood_category_id(Long food_category_id) {
        this.food_category_id = food_category_id;
    }

    @Override
    public String toString() {
        return "FoodCategorySave{" +
                "food_category_id=" + food_category_id +
                ", restaurant_id=" + restaurant_id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
