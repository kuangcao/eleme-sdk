package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * 批量添加食物分类和食物的对象
 * Created by freeway on 16/7/22.
 */
public class FoodCategoryDetailSave implements Serializable {

    private Long restaurant_id;
    private String name;
    private Integer weight;
    private List<Food> foods;

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

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "FoodCategoryDetailSave{" +
                "restaurant_id=" + restaurant_id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", foods=" + foods +
                '}';
    }

    public static class Food implements Serializable {
        private String name;
        private Float price;
        private String description;
        private Integer max_stock;
        private Integer stock;
        private Integer tp_food_id;
        private String image_hash;
        private Short is_new;
        private Short is_featured;
        private Short is_gum;
        private Short is_spicy;
        private Float packing_fee;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
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

        public Integer getTp_food_id() {
            return tp_food_id;
        }

        public void setTp_food_id(Integer tp_food_id) {
            this.tp_food_id = tp_food_id;
        }

        public String getImage_hash() {
            return image_hash;
        }

        public void setImage_hash(String image_hash) {
            this.image_hash = image_hash;
        }

        public Short getIs_new() {
            return is_new;
        }

        public void setIs_new(Short is_new) {
            this.is_new = is_new;
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

        public Short getIs_spicy() {
            return is_spicy;
        }

        public void setIs_spicy(Short is_spicy) {
            this.is_spicy = is_spicy;
        }

        public Float getPacking_fee() {
            return packing_fee;
        }

        public void setPacking_fee(Float packing_fee) {
            this.packing_fee = packing_fee;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", description='" + description + '\'' +
                    ", max_stock=" + max_stock +
                    ", stock=" + stock +
                    ", tp_food_id=" + tp_food_id +
                    ", image_hash='" + image_hash + '\'' +
                    ", is_new=" + is_new +
                    ", is_featured=" + is_featured +
                    ", is_gum=" + is_gum +
                    ", is_spicy=" + is_spicy +
                    ", packing_fee=" + packing_fee +
                    '}';
        }
    }
}
