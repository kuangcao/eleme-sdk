package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;

/**
 * 餐厅订单评价
 * Created by freeway on 16/7/20.
 */
public class Comment implements Serializable {

    /**
     * 评论ID
     */
    private Long id;
    /**
     * 	订单ID
     */
    private Long order_id;
    /**
     * 	餐厅ID
     */
    private Integer restaurant_id;
    /**
     * 	评论内容
     */
    private String content;

    /**
     * datetime	评论时间
     */
    private String created_time;
    /**
     * 	int	是否已回复(0:未回复，1:已回复)
     */
    private Short is_replied;
    /**
     * 	int	评论星级
     */
    private Short rating;

    private CommentUser user;

    private CommentReply reply;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public Short getIs_replied() {
        return is_replied;
    }

    public void setIs_replied(Short is_replied) {
        this.is_replied = is_replied;
    }

    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }

    public CommentUser getUser() {
        return user;
    }

    public void setUser(CommentUser user) {
        this.user = user;
    }

    public CommentReply getReply() {
        return reply;
    }

    public void setReply(CommentReply reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", restaurant_id=" + restaurant_id +
                ", content='" + content + '\'' +
                ", created_time='" + created_time + '\'' +
                ", is_replied=" + is_replied +
                ", rating=" + rating +
                ", user=" + user +
                ", reply=" + reply +
                '}';
    }

    public static class CommentReply implements Serializable {
        private String content;
        private String created_time;
        private String replier_name;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_time() {
            return created_time;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }

        public String getReplier_name() {
            return replier_name;
        }

        public void setReplier_name(String replier_name) {
            this.replier_name = replier_name;
        }

        @Override
        public String toString() {
            return "CommentReply{" +
                    "content='" + content + '\'' +
                    ", created_time='" + created_time + '\'' +
                    ", replier_name='" + replier_name + '\'' +
                    '}';
        }
    }

    public static class CommentUser implements Serializable {

        private String user_name;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        @Override
        public String toString() {
            return "CommentUser{" +
                    "user_name='" + user_name + '\'' +
                    '}';
        }
    }
}
