package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.FoodCategory;
import com.jiabangou.eleme.sdk.model.FoodCategoryDetailSave;
import com.jiabangou.eleme.sdk.model.FoodCategorySave;

import java.util.List;
import java.util.Map;

/**
 * 食物分类服务
 * Created by freeway on 16/7/13.
 */
public interface FoodCategoryService {

    /**
     * 获取菜品分类型芯
     * http://merchant.openapi.eleme.io/merchant.html#api-restaurant-menu-get
     * @param foodCategoryId
     * @return
     * @throws ElemeErrorException
     */
    FoodCategory getById(Long foodCategoryId) throws ElemeErrorException;

    /**
     * 创建菜品
     * @param foodCategorySave
     * @return
     * @throws ElemeErrorException
     */
    Long add(FoodCategorySave foodCategorySave) throws ElemeErrorException;

    /**
     * 更新菜品
     * @param foodCategorySave
     * @throws ElemeErrorException
     */
    void update(FoodCategorySave foodCategorySave) throws ElemeErrorException;

    /**
     * 删除菜品分类
     * @param foodCategoryId
     * @throws ElemeErrorException
     */
    void remove(Long foodCategoryId) throws ElemeErrorException;

    /**
     * 删除餐厅下所有的菜品分类
     * @param restaurantId
     * @throws ElemeErrorException
     */
    void removeAll(Long restaurantId) throws ElemeErrorException;

    /**
     * 查询餐厅食物分类
     * http://merchant.openapi.eleme.io/merchant.html#api-restaurant-food-category-list
     * @param restaurantId 餐厅id
     * @return 分类列表
     * @throws ElemeErrorException
     */
    List<FoodCategory> getsByRestaurantId(Long restaurantId) throws ElemeErrorException;

    Map<Long, List<Long>> addCategoryAndFoods(List<FoodCategoryDetailSave> categoryFoods) throws ElemeErrorException;
}
