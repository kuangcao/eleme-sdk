package com.jiabangou.eleme.pcsdk.model;

import java.io.Serializable;

/**
 * 简要的店铺信息
 * Created by freeway on 2016/12/5.
 */
public class ShopLite implements Serializable {

    private Long id;
    private String name;
    private String address;

    public Long getId() {
        return id;
    }

    public ShopLite setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShopLite setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ShopLite setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "ShopLite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
