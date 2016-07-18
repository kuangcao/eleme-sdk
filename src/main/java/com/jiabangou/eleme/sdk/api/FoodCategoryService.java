package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.FoodCategory;
import com.jiabangou.eleme.sdk.model.FoodCategorySave;

/**
 * Created by freeway on 16/7/13.
 */
public interface FoodCategoryService {

    /**
     * 获取菜品分类型芯
     * @see <http://merchant.openapi.eleme.io/merchant.html#api-restaurant-menu-get>
     * @param foodCategoryId
     * @return
     * @throws ElemeErrorException
     */
    FoodCategory getById(Long foodCategoryId) throws ElemeErrorException;


    Long add(FoodCategorySave foodCategorySave) throws ElemeErrorException;

    void update(FoodCategorySave foodCategorySave) throws ElemeErrorException;

    /**
     *
     * @param foodCategoryId
     * @throws ElemeErrorException
     */
    void remove(Long foodCategoryId) throws ElemeErrorException;
}
