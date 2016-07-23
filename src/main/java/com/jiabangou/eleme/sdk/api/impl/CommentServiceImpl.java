package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.eleme.sdk.api.CommentService;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.LogListener;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Comment;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 评论服务
 * Created by freeway on 16/7/20.
 */
public class CommentServiceImpl extends BaseServiceImpl implements CommentService {

    private final static String COMMENT_RESTAURANT_ID_REPLY = "/comment/${restaurant_id}/reply/";
    private final static String COMMENT_RESTAURANT_ID_COUNT = "/comment/${restaurant_id}/count/";
    private final static String COMMENT_RESTAURANT_ID_LIST_VIEW = "/comment/${restaurant_id}/list_view/";

    public CommentServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage, LogListener logListener) {
        super(client, configStorage, logListener);
    }

    @Override
    public List<Comment> getsByRestaurantId(final Long restaurantId, Integer offset, Integer limit) throws ElemeErrorException {
        if (restaurantId == null) {
            throw new ElemeErrorException(-1, "restaurant_id is required.");
        }
        if (offset == null) {
            offset = 0;
        }
        if (limit == null) {
            limit = 20;
        }
        final Integer finalOffset = offset;
        final Integer finalLimit = limit;
        return execute(HTTP_METHOD_GET, COMMENT_RESTAURANT_ID_LIST_VIEW, new HashMap<String, String>() {{
            put("restaurant_id", String.valueOf(restaurantId));
            put("offset", String.valueOf(finalOffset));
            put("limit", String.valueOf(finalLimit));
        }}).getJSONArray("comments").stream().map(s-> TypeUtils.castToJavaBean(s, Comment.class)).collect(toList());
    }

    @Override
    public long countByRestaurantId(Long restaurantId) throws ElemeErrorException {
        if (restaurantId == null) {
            throw new ElemeErrorException(-1, "restaurant_id is required.");
        }
        return execute(HTTP_METHOD_GET, COMMENT_RESTAURANT_ID_COUNT, new HashMap<String, String>() {{
            put("restaurant_id", String.valueOf(restaurantId));
        }}).getLongValue("count");
    }

    @Override
    public void reply(Long restaurantId, Long commentId, String content, String replierName) throws ElemeErrorException {
        if (restaurantId == null) {
            throw new ElemeErrorException(-1, "restaurant_id is required.");
        }
        if (commentId == null) {
            throw new ElemeErrorException(-1, "comment_id is required.");
        }
        if (content == null) {
            throw new ElemeErrorException(-1, "content is required.");
        }
        if (replierName == null) {
            throw new ElemeErrorException(-1, "replier_name is required.");
        }
        execute(HTTP_METHOD_POST, COMMENT_RESTAURANT_ID_REPLY, new HashMap<String, String>() {{
            put("restaurant_id", String.valueOf(restaurantId));
            put("comment_id", String.valueOf(commentId));
            put("content", String.valueOf(content));
            put("replier_name", String.valueOf(replierName));
        }});
    }
}
