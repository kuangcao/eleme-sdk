package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;

/**
 * Created by freeway on 16/7/13.
 */
public class FoodCategory implements Serializable {

    private Long food_category_id;

    private String name;

    private Short is_valid;

    private Integer weight;

    public Long getFood_category_id() {
        return food_category_id;
    }

    public void setFood_category_id(Long food_category_id) {
        this.food_category_id = food_category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(Short is_valid) {
        this.is_valid = is_valid;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodCategory that = (FoodCategory) o;

        if (food_category_id != null ? !food_category_id.equals(that.food_category_id) : that.food_category_id != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (is_valid != null ? !is_valid.equals(that.is_valid) : that.is_valid != null) return false;
        return weight != null ? weight.equals(that.weight) : that.weight == null;

    }

    @Override
    public int hashCode() {
        int result = food_category_id != null ? food_category_id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (is_valid != null ? is_valid.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FoodCategory{" +
                "food_category_id=" + food_category_id +
                ", name='" + name + '\'' +
                ", is_valid=" + is_valid +
                ", weight=" + weight +
                '}';
    }
}
