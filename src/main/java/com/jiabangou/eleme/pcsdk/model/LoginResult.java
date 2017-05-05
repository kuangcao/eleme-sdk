package com.jiabangou.eleme.pcsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by freeway on 2016/12/5.
 */
public class LoginResult implements Serializable {

    private String ksid;
    private Long keeperId;
    private String username;
    private String imageUrl;
    private List<ShopLite> shops;

    public String getKsid() {
        return ksid;
    }

    public LoginResult setKsid(String ksid) {
        this.ksid = ksid;
        return this;
    }

    public Long getKeeperId() {
        return keeperId;
    }

    public LoginResult setKeeperId(Long keeperId) {
        this.keeperId = keeperId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoginResult setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public LoginResult setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public List<ShopLite> getShops() {
        return shops;
    }

    public LoginResult setShops(List<ShopLite> shops) {
        this.shops = shops;
        return this;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "ksid='" + ksid + '\'' +
                ", keeperId=" + keeperId +
                ", username='" + username + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", shops=" + shops +
                '}';
    }
}
