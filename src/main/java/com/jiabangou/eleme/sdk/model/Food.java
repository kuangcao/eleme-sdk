package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * 食物
 * Created by freeway on 16/7/11.
 */
public class Food implements Serializable {

    /**
     * 食物描述
     */
    private String description;
    /**
     * 食物id
      */
    private Long food_id;

    /**
     * 食物名
     */
    private String food_name;

    /**
     * 是否活动食物，暂不建议使用有活动的食物
     */
    private Integer has_activity;

    /**
     * 食物图片
     */
    private String image_url;

    /**
     * 食物评价，依次为1-5星评价的数目
     */
    private List<Integer> num_ratings;

    /**
     * 食物价格
     */
    private Float price;

    /**
     * 最近一个月的售出份数
     */
    private Integer recent_popularity;

    /**
     * 最近一个月的评价
     */
    private Float recent_rating;

    /**
     * 餐厅Id
     */
    private Long restaurant_id;

    /**
     * 餐厅名称
     */
    private String restaurant_name;

    /**
     * 库存量
     */
    private Integer stock;

    private Short is_featured;
    private Short is_gum;
    private Short is_new;
    private Short is_spicy;
    private Short is_valid = 1;

    /**
     * 食物排序(数值越小越靠前)
     */
    private Integer sort_order;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFood_id() {
        return food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public Integer getHas_activity() {
        return has_activity;
    }

    public void setHas_activity(Integer has_activity) {
        this.has_activity = has_activity;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Short getIs_featured() {
        return is_featured;
    }

    public void setIs_featured(Short is_featured) {
        this.is_featured = is_featured;
    }

    public Short getIs_gum() {
        return is_gum;
    }

    public void setIs_gum(Short is_gum) {
        this.is_gum = is_gum;
    }

    public Short getIs_new() {
        return is_new;
    }

    public void setIs_new(Short is_new) {
        this.is_new = is_new;
    }

    public Short getIs_spicy() {
        return is_spicy;
    }

    public void setIs_spicy(Short is_spicy) {
        this.is_spicy = is_spicy;
    }

    public int getIs_valid() {
        return is_valid;
    }

    public List<Integer> getNum_ratings() {
        return num_ratings;
    }

    public void setNum_ratings(List<Integer> num_ratings) {
        this.num_ratings = num_ratings;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getRecent_popularity() {
        return recent_popularity;
    }

    public void setRecent_popularity(Integer recent_popularity) {
        this.recent_popularity = recent_popularity;
    }

    public Float getRecent_rating() {
        return recent_rating;
    }

    public void setRecent_rating(Float recent_rating) {
        this.recent_rating = recent_rating;
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        return food_id != null ? food_id.equals(food.food_id) : food.food_id == null;

    }

    @Override
    public int hashCode() {
        return food_id != null ? food_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Food{" +
                "description='" + description + '\'' +
                ", food_id=" + food_id +
                ", food_name='" + food_name + '\'' +
                ", has_activity=" + has_activity +
                ", image_url='" + image_url + '\'' +
                ", num_ratings=" + num_ratings +
                ", price=" + price +
                ", recent_popularity=" + recent_popularity +
                ", recent_rating=" + recent_rating +
                ", restaurant_id=" + restaurant_id +
                ", restaurant_name='" + restaurant_name + '\'' +
                ", stock=" + stock +
                ", is_featured=" + is_featured +
                ", is_gum=" + is_gum +
                ", is_new=" + is_new +
                ", is_spicy=" + is_spicy +
                ", is_valid=" + is_valid +
                ", sort_order=" + sort_order +
                '}';
    }
}
