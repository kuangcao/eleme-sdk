package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.NewFood;

/**
 * 菜品服务新接口
 * Created by wanglei on 16-10-20.
 */
public interface NewFoodService {

    NewFood getById(Long foodId) throws ElemeErrorException;

    Long add(NewFood food) throws ElemeErrorException;

    void update(NewFood food) throws ElemeErrorException;

    void remove(Long foodId) throws ElemeErrorException;

    /**
     * 上架
     * @param foodId
     * @throws ElemeErrorException
     */
    void onShelf(Long foodId) throws ElemeErrorException;

    /**
     * 菜品下架
     * @param foodId
     * @throws ElemeErrorException
     */
    void offShelf(Long foodId) throws ElemeErrorException;
}
