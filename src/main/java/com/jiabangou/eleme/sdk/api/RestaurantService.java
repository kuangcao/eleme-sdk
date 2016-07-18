package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.FoodCategoryDetail;
import com.jiabangou.eleme.sdk.model.Restaurant;

import java.util.List;

/**
 * Created by freeway on 16/7/13.
 */
public interface RestaurantService {

    /**
     * 查询餐厅菜单
     * 根据指定的ID查询餐厅菜单
     * @param restaurantId
     * @return
     * @throws ElemeErrorException
     */
    List<FoodCategoryDetail> getMenu(Long restaurantId) throws ElemeErrorException;

    /**
     * 查询餐厅信息
     * 根据指定的ID查询餐厅信息
     * @param restaurantId
     * @return
     * @throws ElemeErrorException
     */
    Restaurant get(Long restaurantId) throws ElemeErrorException;
}
