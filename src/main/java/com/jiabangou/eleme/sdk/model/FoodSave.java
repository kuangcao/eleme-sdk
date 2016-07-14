package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;

/**
 * 食物
 * Created by freeway on 16/7/11.
 */
public class FoodSave implements Serializable {

    /**
     * 食物ID
     */
    private Long food_id;
    /**
     * 饿了么食物分类ID
     */
    private Long food_category_id;

    /**
     * 食物价格
     */
    private Float price;

    /**
     * 食物名
     */
    private String name;

    /**
     * 食物描述
     */
    private String description;

    /**
     * 最大库存
     */
    private Integer max_stock;

    /**
     * 库存量
     */
    private Integer stock;

    /**
     * 第三方食物ID
      */
    private String tp_food_id;

    /**
     * 图片image_hash
     */
    private String image_hash;

    /**
     * 菜品打包费（元）
     */
    private Float packing_fee;

    /**
     * 食物排序(数值越小越靠前)
     */
    private Integer sort_order;

    public Long getFood_category_id() {
        return food_category_id;
    }

    public void setFood_category_id(Long food_category_id) {
        this.food_category_id = food_category_id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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

    public Integer getMax_stock() {
        return max_stock;
    }

    public void setMax_stock(Integer max_stock) {
        this.max_stock = max_stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getTp_food_id() {
        return tp_food_id;
    }

    public void setTp_food_id(String tp_food_id) {
        this.tp_food_id = tp_food_id;
    }

    public String getImage_hash() {
        return image_hash;
    }

    public void setImage_hash(String image_hash) {
        this.image_hash = image_hash;
    }

    public Float getPacking_fee() {
        return packing_fee;
    }

    public void setPacking_fee(Float packing_fee) {
        this.packing_fee = packing_fee;
    }

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }

    public Long getFood_id() {
        return food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodSave foodSave = (FoodSave) o;

        return food_id != null ? food_id.equals(foodSave.food_id) : foodSave.food_id == null;

    }

    @Override
    public int hashCode() {
        return food_id != null ? food_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FoodSave{" +
                "food_id=" + food_id +
                ", food_category_id=" + food_category_id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", max_stock=" + max_stock +
                ", stock=" + stock +
                ", tp_food_id='" + tp_food_id + '\'' +
                ", image_hash='" + image_hash + '\'' +
                ", packing_fee=" + packing_fee +
                ", sort_order=" + sort_order +
                '}';
    }
}
