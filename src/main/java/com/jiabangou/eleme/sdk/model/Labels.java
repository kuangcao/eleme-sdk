package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-10-20.
 */
public class Labels implements Serializable {

    private Integer is_new;  //1：新菜 0：非新菜	是否是新菜品
    private Integer is_featured;  //1：招牌菜 0：非招牌菜	是否是招牌菜
    private Integer is_gum; //1：配菜 0：不是配菜	是否是配菜
    private Integer is_spicy; //1：辣 0：不辣	味道是否辣

    public Integer getIs_new() {
        return is_new;
    }

    public void setIs_new(Integer is_new) {
        this.is_new = is_new;
    }

    public Integer getIs_featured() {
        return is_featured;
    }

    public void setIs_featured(Integer is_featured) {
        this.is_featured = is_featured;
    }

    public Integer getIs_gum() {
        return is_gum;
    }

    public void setIs_gum(Integer is_gum) {
        this.is_gum = is_gum;
    }

    public Integer getIs_spicy() {
        return is_spicy;
    }

    public void setIs_spicy(Integer is_spicy) {
        this.is_spicy = is_spicy;
    }

    @Override
    public String toString() {
        return "Labels{" +
                "is_new=" + is_new +
                ", is_featured=" + is_featured +
                ", is_gum=" + is_gum +
                ", is_spicy=" + is_spicy +
                '}';
    }
}
