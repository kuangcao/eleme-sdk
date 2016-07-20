package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Comment;

import java.util.List;

/**
 * 评论服务
 * Created by freeway on 16/7/20.
 */
public interface CommentService {

    /**
     * 根据餐厅id获取评论
     * @param restaurantId
     * @param offset 位移，默认为0。
     * @param limit 评论数量，默认为20
     * @return
     */
    List<Comment> getsByRestaurantId(Long restaurantId, Integer offset, Integer limit) throws ElemeErrorException;

    /**
     * 获取餐厅订单评价数量
     * 根据给定的餐厅ID,查询订单评价数量
     * @param restaurantId
     * @return
     * @throws ElemeErrorException
     */
    long countByRestaurantId(Long restaurantId) throws ElemeErrorException;

    /**
     * 评价回复
     * @param restaurantId
     * @param commentId
     * @param content
     * @param replierName
     */
    void reply(Long restaurantId, Long commentId, String content, String replierName) throws ElemeErrorException;
}
