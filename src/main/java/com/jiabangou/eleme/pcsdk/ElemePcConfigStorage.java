package com.jiabangou.eleme.pcsdk;

/**
 * PC版本的配置
 * Created by freeway on 2016/12/4.
 */
public interface ElemePCConfigStorage {

    String getUserName();
    String getPassword();
    String getKsid();
    String getShopId();

    void save(String username, String password, String ksid, String shopId);

}
