package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.pcsdk.model.Comment;

import java.util.List;

/**
 * 评论服务
 * Created by freeway on 2016/12/11.
 */
public interface CommentService {

    /**
     * 根据餐厅id获取评论
     * @param shopId
     * @param offset 位移，默认为0。
     * @param limit 评论数量，默认为20
     * @return
     */
    List<Comment> getsByShopId(Long shopId, int offset, int limit);


    void reply(Long shopId, Long commentId, String content);
}
