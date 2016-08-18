package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.*;

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

    /**
     * 绑定商户餐厅 ID
     * @param restaurantId
     * @param tpRestaurantId
     * @throws ElemeErrorException 1004 代表已经被绑定过,example:
     * <code>
     *   {
     *     "message":"Restaurant 62028381 has been binded with 203518",
     *     "code":1004,
     *     "data":null,
     *     "request_id":"7e0a584c66c0458ca51a32def4d2c550"
     *   }
     * </code>
     *
     */
    void binding(Long restaurantId, String tpRestaurantId) throws ElemeErrorException;

    /**
     * 重新绑定商户餐厅 ID
     * restaurant_id 需要已经绑定过，否则绑定失败
     * tp_restaurant_id 不能已经被自己的其他餐厅使用
     * @param restaurantId 饿了么餐厅 ID
     * @param tpRestaurantId 商户餐厅 ID
     * @throws ElemeErrorException
     */
    void rebinding(Long restaurantId, String tpRestaurantId) throws ElemeErrorException;

    /**
     * 通过 tp_restaurant_id 查询饿了么餐厅 ID
     * 通过商户餐厅 ID 查询饿了么餐厅 ID
     * @param tpRestaurantId
     * @return
     * @throws ElemeErrorException
     */
    Long getIdByTpRestaurantId(String tpRestaurantId) throws ElemeErrorException;

    /**
     * 查询所属餐厅
     * 获取商户所管理(即绑定为开放平台的餐厅后)的所有餐厅的ID
     * @return
     * @throws ElemeErrorException
     */
    List<Long> getIds() throws ElemeErrorException;

    /**
     * 更新某一个指定餐厅的基本信息
     * @param restaurantSave
     * @throws ElemeErrorException
     */
    void update(RestaurantSave restaurantSave) throws ElemeErrorException;

    /**
     * 更新餐厅营业信息
     * @param restaurantId
     * @param isOpen
     * @throws ElemeErrorException
     */
    void setIsOpen(Long restaurantId, boolean isOpen) throws ElemeErrorException;

    /**
     *
     * @param restaurantId
     * @param orderMode
     * @throws ElemeErrorException
     */
    void updateOrderMode(Long restaurantId, Short orderMode) throws ElemeErrorException;

    /**
     * 批量获取餐厅的状态
     * 批量获取一组餐厅营业状态，有效状态，订单模式
     * @param restaurantIds 餐厅id
     * @return
     * @throws ElemeErrorException
     */
    List<RestaurantStatus> getStatus(List<Long> restaurantIds) throws ElemeErrorException;

    /**
     * 获取餐厅的标品信息
     * @param restaurantId
     * @return
     * @throws ElemeErrorException
     */
    RestaurantProductProfile getProductProfile(Long restaurantId) throws ElemeErrorException;

    /**
     * 设置餐厅配送信息
     * @param restaurantGeo
     * @throws ElemeErrorException
     */
    void restaurantGeo(Long restaurantId, List<RestaurantGeo> restaurantGeo) throws ElemeErrorException;
}
