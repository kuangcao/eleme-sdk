package com.jiabangou.eleme.pcsdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.pcsdk.ElemePCConfigStorage;
import com.jiabangou.eleme.pcsdk.PCLogListener;
import com.jiabangou.eleme.pcsdk.api.CommentService;
import com.jiabangou.eleme.pcsdk.model.Comment;
import com.jiabangou.eleme.pcsdk.model.CommentQuery;
import okhttp3.OkHttpClient;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 评论服务实现
 * Created by freeway on 2016/12/11.
 */
public class CommentServiceImpl extends PCBaseServiceImpl implements CommentService {

    public CommentServiceImpl(OkHttpClient client, ElemePCConfigStorage configStorage, PCLogListener logListener) {
        super(client, configStorage, logListener);
    }

    @Override
    public List<Comment> getsByShopId(Long shopId, int offset, int limit) {
        JSONObject params = new JSONObject();
        params.put("shopId", shopId);
        params.put("query", JSONObject.toJSON(CommentQuery.build().setOffset(offset).setLimit(limit)));
        JSONObject jsonResult = (JSONObject) execute(API.SHOP_RATING_QUERY_SINGLE_SHOP_RATING, params);
        return jsonResult.getJSONArray("orderRatingList").stream()
                .map(json -> TypeUtils.castToJavaBean(json, Comment.class)).collect(toList());
    }

    @Override
    public void reply(Long shopId, Long commentId, String content) {
        JSONObject params = new JSONObject();
        params.put("shopId", shopId);
        JSONObject reply = new JSONObject();
        params.put("reply", reply);
        reply.put("content", content);
        reply.put("ratingId", commentId);
        reply.put("ratingType", "ORDER");
        execute(API.SHOP_RATING_REPLY_RATING, params);
    }
}
