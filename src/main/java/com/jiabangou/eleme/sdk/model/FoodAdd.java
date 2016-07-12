package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * 食物
 * Created by freeway on 16/7/11.
 */
public class FoodAdd implements Serializable {

    /**
     * 饿了么食物分类ID
     */
    private long food_category_id;

    /**
     * 食物价格
     */
    private float price;

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
    private int max_stock;

    /**
     * 库存量
     */
    private int stock;

    /**
     * 第三方食物ID
      */
    private String tp_food_id;

    /**
     * 图片image_hash
     */
    private String image_hash;

    /**
     * 食物图片
     */
    private String image_url;

    /**
     * 菜品打包费（元）
     */
    private float packing_fee;

    /**
     * 食物排序(数值越小越靠前)
     */
    private int sort_order;

    public long getFood_category_id() {
        return food_category_id;
    }

    public void setFood_category_id(long food_category_id) {
        this.food_category_id = food_category_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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

    public int getMax_stock() {
        return max_stock;
    }

    public void setMax_stock(int max_stock) {
        this.max_stock = max_stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public float getPacking_fee() {
        return packing_fee;
    }

    public void setPacking_fee(float packing_fee) {
        this.packing_fee = packing_fee;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodAdd foodAdd = (FoodAdd) o;

        if (food_category_id != foodAdd.food_category_id) return false;
        if (Float.compare(foodAdd.price, price) != 0) return false;
        if (max_stock != foodAdd.max_stock) return false;
        if (stock != foodAdd.stock) return false;
        if (Float.compare(foodAdd.packing_fee, packing_fee) != 0) return false;
        if (sort_order != foodAdd.sort_order) return false;
        if (name != null ? !name.equals(foodAdd.name) : foodAdd.name != null) return false;
        if (description != null ? !description.equals(foodAdd.description) : foodAdd.description != null) return false;
        if (tp_food_id != null ? !tp_food_id.equals(foodAdd.tp_food_id) : foodAdd.tp_food_id != null) return false;
        if (image_hash != null ? !image_hash.equals(foodAdd.image_hash) : foodAdd.image_hash != null) return false;
        return image_url != null ? image_url.equals(foodAdd.image_url) : foodAdd.image_url == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (food_category_id ^ (food_category_id >>> 32));
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + max_stock;
        result = 31 * result + stock;
        result = 31 * result + (tp_food_id != null ? tp_food_id.hashCode() : 0);
        result = 31 * result + (image_hash != null ? image_hash.hashCode() : 0);
        result = 31 * result + (image_url != null ? image_url.hashCode() : 0);
        result = 31 * result + (packing_fee != +0.0f ? Float.floatToIntBits(packing_fee) : 0);
        result = 31 * result + sort_order;
        return result;
    }

    @Override
    public String toString() {
        return "FoodAdd{" +
                "food_category_id=" + food_category_id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", max_stock=" + max_stock +
                ", stock=" + stock +
                ", tp_food_id='" + tp_food_id + '\'' +
                ", image_hash='" + image_hash + '\'' +
                ", image_url='" + image_url + '\'' +
                ", packing_fee=" + packing_fee +
                ", sort_order=" + sort_order +
                '}';
    }
}
