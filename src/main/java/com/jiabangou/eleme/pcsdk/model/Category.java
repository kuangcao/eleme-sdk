package com.jiabangou.eleme.pcsdk.model;

import java.io.Serializable;

/**
 * 菜品分类
 * Created by freeway on 2016/12/5.
 */
public class Category implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Boolean valid;

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean getValid() {
        return valid;
    }

    public Category setValid(Boolean valid) {
        this.valid = valid;
        return this;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", valid=" + valid +
                '}';
    }
}
