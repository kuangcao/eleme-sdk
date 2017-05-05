package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * 新菜品对象
 * Created by wanglei on 16-10-19.
 */
public class NewFood implements Serializable {


    private static final long serialVersionUID = 6613624722322641657L;

    public final static int ON_SHELF = 1;
    public final static int OFF_SHELF = 0;

    private Long food_id;  //食物id
    private Long food_category_id;  //饿了么食物分类ID
    private String name;  //食物名称
    private Float price;  //食物单价
    private String description;  //食物描述
    private String image_hash;  //图片image_hash（如何获得 /api/merchant/image）
    private int on_shelf = ON_SHELF;
    private Labels labels;  //标签属性集合

    private List<Spec> specs;  //具体参考下文中示例 规格

    public Long getFood_id() {
        return food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
    }

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

    public String getImage_hash() {
        return image_hash;
    }

    public void setImage_hash(String image_hash) {
        this.image_hash = image_hash;
    }

    public Labels getLabels() {
        return labels;
    }

    public void setLabels(Labels labels) {
        this.labels = labels;
    }

    public int getOn_shelf() {
        return on_shelf;
    }

    public void setOn_shelf(int on_shelf) {
        this.on_shelf = on_shelf;
    }

    public List<Spec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        this.specs = specs;
    }

    @Override
    public String toString() {
        return "NewFood{" +
                "food_id=" + food_id +
                ", food_category_id=" + food_category_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image_hash='" + image_hash + '\'' +
                ", on_shelf=" + on_shelf +
                ", labels=" + labels +
                ", specs=" + specs +
                '}';
    }
}
