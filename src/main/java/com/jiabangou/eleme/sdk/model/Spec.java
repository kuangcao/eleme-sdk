package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-10-20.
 */
public class Spec implements Serializable {

    private Integer spec_id;  //规格ID
    private String name;  //规格名称
    private  Float price;  //规格单价
    private String tp_food_id;  //第三方食物ID
    private Integer max_stock;  //最大库存
    private Integer stock;  //当前库存
    private Float packing_fee;  //菜品打包费（元）
    private Integer on_shelf;  //0：下架， 1：上架

    public Integer getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(Integer spec_id) {
        this.spec_id = spec_id;
    }

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

    public String getTp_food_id() {
        return tp_food_id;
    }

    public void setTp_food_id(String tp_food_id) {
        this.tp_food_id = tp_food_id;
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

    public Float getPacking_fee() {
        return packing_fee;
    }

    public void setPacking_fee(Float packing_fee) {
        this.packing_fee = packing_fee;
    }

    public Integer getOn_shelf() {
        return on_shelf;
    }

    public void setOn_shelf(Integer on_shelf) {
        this.on_shelf = on_shelf;
    }

    @Override
    public String toString() {
        return "Spec{" +
                "spec_id=" + spec_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", tp_food_id='" + tp_food_id + '\'' +
                ", max_stock=" + max_stock +
                ", stock=" + stock +
                ", packing_fee=" + packing_fee +
                ", on_shelf=" + on_shelf +
                '}';
    }
}
