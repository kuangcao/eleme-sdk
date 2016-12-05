package com.jiabangou.eleme.pcsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * 食物
 * Created by freeway on 2016/12/5.
 */
public class Food implements Serializable {

    private Long id;
    private Long restaurantId;
    private String name;
    private String description;
    private double price;
    private Short recentPopularity;
    private boolean valid;
    private double packingFee;
    private Integer stock;
    private Integer maxStock;
    private List<String> labels;
    private String imageUrl;
    private Long createdAt;
    private Long removedAt;
    private boolean canChangeName;
    private boolean canChangePrice;
    private Integer discount;
    private Long categoryId;
    private String type;
    private boolean onShelf;
    private boolean editable;
//            "relatedFoods": [],
//            "garnishes": [],
//            "specs": [],

    public Long getId() {
        return id;
    }

    public Food setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public Food setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Food setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Food setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Food setPrice(double price) {
        this.price = price;
        return this;
    }

    public Short getRecentPopularity() {
        return recentPopularity;
    }

    public Food setRecentPopularity(Short recentPopularity) {
        this.recentPopularity = recentPopularity;
        return this;
    }

    public boolean isValid() {
        return valid;
    }

    public Food setValid(boolean valid) {
        this.valid = valid;
        return this;
    }

    public double getPackingFee() {
        return packingFee;
    }

    public Food setPackingFee(double packingFee) {
        this.packingFee = packingFee;
        return this;
    }

    public Integer getStock() {
        return stock;
    }

    public Food setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public Food setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
        return this;
    }

    public List<String> getLabels() {
        return labels;
    }

    public Food setLabels(List<String> labels) {
        this.labels = labels;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Food setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Food setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Long getRemovedAt() {
        return removedAt;
    }

    public Food setRemovedAt(Long removedAt) {
        this.removedAt = removedAt;
        return this;
    }

    public boolean isCanChangeName() {
        return canChangeName;
    }

    public Food setCanChangeName(boolean canChangeName) {
        this.canChangeName = canChangeName;
        return this;
    }

    public boolean isCanChangePrice() {
        return canChangePrice;
    }

    public Food setCanChangePrice(boolean canChangePrice) {
        this.canChangePrice = canChangePrice;
        return this;
    }

    public Integer getDiscount() {
        return discount;
    }

    public Food setDiscount(Integer discount) {
        this.discount = discount;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Food setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getType() {
        return type;
    }

    public Food setType(String type) {
        this.type = type;
        return this;
    }

    public boolean isOnShelf() {
        return onShelf;
    }

    public Food setOnShelf(boolean onShelf) {
        this.onShelf = onShelf;
        return this;
    }

    public boolean isEditable() {
        return editable;
    }

    public Food setEditable(boolean editable) {
        this.editable = editable;
        return this;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", recentPopularity=" + recentPopularity +
                ", valid=" + valid +
                ", packingFee=" + packingFee +
                ", stock=" + stock +
                ", maxStock=" + maxStock +
                ", labels=" + labels +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdAt=" + createdAt +
                ", removedAt=" + removedAt +
                ", canChangeName=" + canChangeName +
                ", canChangePrice=" + canChangePrice +
                ", discount=" + discount +
                ", categoryId=" + categoryId +
                ", type='" + type + '\'' +
                ", onShelf=" + onShelf +
                ", editable=" + editable +
                '}';
    }
}
