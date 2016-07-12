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
    private long food_id;

    /**
     * 食物名
     */
    private String food_name;

    /**
     * 是否活动食物，暂不建议使用有活动的食物
     */
    private int has_activity;

    /**
     * 食物图片
     */
    private String image_url;

    /**
     * 	是否招牌菜
     */
    private int is_featured;

    /**
     * 是否配菜
     */
    private int is_gum;

    /**
     * 是否新菜
     */
    private int is_new;

    /**
     * 是否辣
     */
    private int is_spicy;

    /**
     * 是否有效
     */
    private int is_valid;

    /**
     * 食物评价，依次为1-5星评价的数目
     */
    private List<Integer> num_ratings;

    /**
     * 食物价格
     */
    private float price;

    /**
     * 最近一个月的售出份数
     */
    private int recent_popularity;

    /**
     * 最近一个月的评价
     */
    private float recent_rating;

    /**
     * 餐厅Id
     */
    private long restaurant_id;

    /**
     * 餐厅名称
     */
    private String restaurant_name;

    /**
     * 库存量
     */
    private int stock;

    /**
     * 食物排序(数值越小越靠前)
     */
    private int sort_order;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getHas_activity() {
        return has_activity;
    }

    public void setHas_activity(int has_activity) {
        this.has_activity = has_activity;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getIs_featured() {
        return is_featured;
    }

    public void setIs_featured(int is_featured) {
        this.is_featured = is_featured;
    }

    public int getIs_gum() {
        return is_gum;
    }

    public void setIs_gum(int is_gum) {
        this.is_gum = is_gum;
    }

    public int getIs_new() {
        return is_new;
    }

    public void setIs_new(int is_new) {
        this.is_new = is_new;
    }

    public int getIs_spicy() {
        return is_spicy;
    }

    public void setIs_spicy(int is_spicy) {
        this.is_spicy = is_spicy;
    }

    public int getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(int is_valid) {
        this.is_valid = is_valid;
    }

    public List<Integer> getNum_ratings() {
        return num_ratings;
    }

    public void setNum_ratings(List<Integer> num_ratings) {
        this.num_ratings = num_ratings;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRecent_popularity() {
        return recent_popularity;
    }

    public void setRecent_popularity(int recent_popularity) {
        this.recent_popularity = recent_popularity;
    }

    public float getRecent_rating() {
        return recent_rating;
    }

    public void setRecent_rating(float recent_rating) {
        this.recent_rating = recent_rating;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    public long getFood_id() {
        return food_id;
    }

    public void setFood_id(long food_id) {
        this.food_id = food_id;
    }

    public long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        if (food_id != food.food_id) return false;
        if (has_activity != food.has_activity) return false;
        if (is_featured != food.is_featured) return false;
        if (is_gum != food.is_gum) return false;
        if (is_new != food.is_new) return false;
        if (is_spicy != food.is_spicy) return false;
        if (is_valid != food.is_valid) return false;
        if (Float.compare(food.price, price) != 0) return false;
        if (recent_popularity != food.recent_popularity) return false;
        if (Float.compare(food.recent_rating, recent_rating) != 0) return false;
        if (restaurant_id != food.restaurant_id) return false;
        if (stock != food.stock) return false;
        if (sort_order != food.sort_order) return false;
        if (description != null ? !description.equals(food.description) : food.description != null) return false;
        if (food_name != null ? !food_name.equals(food.food_name) : food.food_name != null) return false;
        if (image_url != null ? !image_url.equals(food.image_url) : food.image_url != null) return false;
        if (num_ratings != null ? !num_ratings.equals(food.num_ratings) : food.num_ratings != null) return false;
        return restaurant_name != null ? restaurant_name.equals(food.restaurant_name) : food.restaurant_name == null;

    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (int) (food_id ^ (food_id >>> 32));
        result = 31 * result + (food_name != null ? food_name.hashCode() : 0);
        result = 31 * result + has_activity;
        result = 31 * result + (image_url != null ? image_url.hashCode() : 0);
        result = 31 * result + is_featured;
        result = 31 * result + is_gum;
        result = 31 * result + is_new;
        result = 31 * result + is_spicy;
        result = 31 * result + is_valid;
        result = 31 * result + (num_ratings != null ? num_ratings.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + recent_popularity;
        result = 31 * result + (recent_rating != +0.0f ? Float.floatToIntBits(recent_rating) : 0);
        result = 31 * result + (int) (restaurant_id ^ (restaurant_id >>> 32));
        result = 31 * result + (restaurant_name != null ? restaurant_name.hashCode() : 0);
        result = 31 * result + stock;
        result = 31 * result + sort_order;
        return result;
    }

    @Override
    public String toString() {
        return "Food{" +
                "description='" + description + '\'' +
                ", food_id=" + food_id +
                ", food_name='" + food_name + '\'' +
                ", has_activity=" + has_activity +
                ", image_url='" + image_url + '\'' +
                ", is_featured=" + is_featured +
                ", is_gum=" + is_gum +
                ", is_new=" + is_new +
                ", is_spicy=" + is_spicy +
                ", is_valid=" + is_valid +
                ", num_ratings=" + num_ratings +
                ", price=" + price +
                ", recent_popularity=" + recent_popularity +
                ", recent_rating=" + recent_rating +
                ", restaurant_id=" + restaurant_id +
                ", restaurant_name='" + restaurant_name + '\'' +
                ", stock=" + stock +
                ", sort_order=" + sort_order +
                '}';
    }
}
