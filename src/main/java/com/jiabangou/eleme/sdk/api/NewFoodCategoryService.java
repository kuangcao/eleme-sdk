package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.NewFood;
import com.jiabangou.eleme.sdk.model.NewFoodCategory;

import java.util.List;

/**
 * 食物分类服务
 * Created by freeway on 16/7/13.
 */
public interface NewFoodCategoryService {

    /**
     * 获取菜品分类型芯
     * http://merchant.openapi.eleme.io/merchant.html#api-new-food-category-get
     * @param foodCategoryId 分类id
     * @return 分类对象
     * @throws ElemeErrorException
     */
    NewFoodCategory getById(Long foodCategoryId) throws ElemeErrorException;

    /**
     * 查询分类食物列表
     * http://merchant.openapi.eleme.io/merchant.html#api-new-food-category-food-list
     * @param foodCategoryId 分类id
     * @return 该分类下的事物列表
     * @throws ElemeErrorException
     */
    List<NewFood> getFoodsById(Long foodCategoryId) throws ElemeErrorException;

    /**
     * 添加食物分类
     * http://merchant.openapi.eleme.io/merchant.html#api-new-food-category-add
     * @param newFoodCategory 分类对象
     * @return 分类id
     * @throws ElemeErrorException
     */
    Long add(NewFoodCategory newFoodCategory) throws ElemeErrorException;

    /**
     * 更新菜品分类
     * http://merchant.openapi.eleme.io/merchant.html#api-new-food-category-update
     * @param newFoodCategory 分类对象
     * @throws ElemeErrorException
     */
    void update(NewFoodCategory newFoodCategory) throws ElemeErrorException;

    /**
     * 删除菜品分类
     * http://merchant.openapi.eleme.io/merchant.html#api-new-food-category-delete
     * @param foodCategoryId 分类id
     * @throws ElemeErrorException
     */
    void remove(Long foodCategoryId) throws ElemeErrorException;

    /**
     * 删除餐厅下所有的菜品分类
     * @param restaurantId 分类id
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
    List<NewFoodCategory> getsByRestaurantId(Long restaurantId) throws ElemeErrorException;

}
