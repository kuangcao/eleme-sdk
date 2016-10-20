package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.NewFood;

/**
 * Created by wanglei on 16-10-20.
 */
public interface NewFoodService {

    NewFood getById(Long foodId) throws ElemeErrorException;

    Long add(NewFood food) throws ElemeErrorException;

    void update(NewFood food) throws ElemeErrorException;

    void remove(Long foodId) throws ElemeErrorException;

}
