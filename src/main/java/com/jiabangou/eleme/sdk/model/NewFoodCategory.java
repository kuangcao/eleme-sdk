package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-10-19.
 */
public class NewFoodCategory implements Serializable {

    private Long food_category_id; //分类id
    private Integer restaurant_id; //饿了么餐厅ID
    private String name; //食物分类名称
    private String description; //食物分类描述
    private List<DisplayAttribute> display_attribute; //分类分时展示属性

    public Long getFood_category_id() {
        return food_category_id;
    }

    public void setFood_category_id(Long food_category_id) {
        this.food_category_id = food_category_id;
    }

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DisplayAttribute> getDisplay_attribute() {
        return display_attribute;
    }

    public void setDisplay_attribute(List<DisplayAttribute> display_attribute) {
        this.display_attribute = display_attribute;
    }

    @Override
    public String toString() {
        return "NewFoodCategory{" +
                "food_category_id='" + food_category_id + '\'' +
                ", restaurant_id=" + restaurant_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", display_attribute=" + display_attribute +
                '}';
    }
}
