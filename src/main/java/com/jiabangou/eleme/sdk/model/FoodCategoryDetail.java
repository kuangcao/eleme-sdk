package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 食物分类详情,包含分类下的食物
 * Created by freeway on 16/7/14.
 */
public class FoodCategoryDetail implements Serializable {


    private String category;
    private Long category_id;
    private String description;

    private List<Food> foods;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "FoodCategoryDetail{" +
                "category='" + category + '\'' +
                ", category_id=" + category_id +
                ", description='" + description + '\'' +
                ", foods=" + foods +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodCategoryDetail that = (FoodCategoryDetail) o;

        return category_id != null ? category_id.equals(that.category_id) : that.category_id == null;

    }

    @Override
    public int hashCode() {
        return category_id != null ? category_id.hashCode() : 0;
    }

    public static class Food implements Serializable {
        private Long id;
        private String tp_food_id;
        private String name;
        private String pinyin_name;
        private String description;
        private Set<String> attributes;
        private List<Integer> num_ratings;
        private Float price;
        private Integer rating;
        private String rating_count;
        private Long restaurant_id;
        private Long sales;
        private Integer stock;
        private String image_url;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPinyin_name() {
            return pinyin_name;
        }

        public void setPinyin_name(String pinyin_name) {
            this.pinyin_name = pinyin_name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Set<String> getAttributes() {
            return attributes;
        }

        public void setAttributes(Set<String> attributes) {
            this.attributes = attributes;
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

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

        public String getRating_count() {
            return rating_count;
        }

        public void setRating_count(String rating_count) {
            this.rating_count = rating_count;
        }

        public Long getRestaurant_id() {
            return restaurant_id;
        }

        public void setRestaurant_id(Long restaurant_id) {
            this.restaurant_id = restaurant_id;
        }

        public Long getSales() {
            return sales;
        }

        public void setSales(Long sales) {
            this.sales = sales;
        }

        public Integer getStock() {
            return stock;
        }

        public void setStock(Integer stock) {
            this.stock = stock;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
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

            Food food = (Food) o;

            return id != null ? id.equals(food.id) : food.id == null;

        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "id=" + id +
                    ", tp_food_id=" + tp_food_id +
                    ", name='" + name + '\'' +
                    ", pinyin_name='" + pinyin_name + '\'' +
                    ", description='" + description + '\'' +
                    ", attributes=" + attributes +
                    ", num_ratings=" + num_ratings +
                    ", price=" + price +
                    ", rating=" + rating +
                    ", rating_count='" + rating_count + '\'' +
                    ", restaurant_id=" + restaurant_id +
                    ", sales=" + sales +
                    ", stock=" + stock +
                    ", image_url='" + image_url + '\'' +
                    '}';
        }



    }

}
