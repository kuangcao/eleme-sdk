package com.jiabangou.eleme.pcsdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 评论对象
 * Created by freeway on 2016/12/11.
 */
public class Comment implements Serializable {

    /**
     * 评论ID
     */
    @JSONField(name = "ratingId")
    private Long id;

    /**
     * 	订单ID
     */
    private Long orderId;

    @JSONField(name = "ratingContent")
    private String content;

    /**
     * 	餐厅ID
     */
    private Long shopId;

    /**
     * datetime	评论时间
     */
    @JSONField(name="ratingAt")
    private String createdAt;
    /**
     * 	int	是否已回复(0:未回复，1:已回复)
     */
    private boolean replied;
    /**
     * 	int	评论星级
     */
    @JSONField(name = "ratingStar")
    private Short rating;

    private String replyAt;
    private String replyContent;
    private boolean canReply;

    private String deliveryTime;


    public Long getId() {
        return id;
    }

    public Comment setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Comment setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public Long getShopId() {
        return shopId;
    }

    public Comment setShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Comment setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Short getRating() {
        return rating;
    }

    public Comment setRating(Short rating) {
        this.rating = rating;
        return this;
    }

    public String getReplyAt() {
        return replyAt;
    }

    public Comment setReplyAt(String replyAt) {
        this.replyAt = replyAt;
        return this;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public Comment setReplyContent(String replyContent) {
        this.replyContent = replyContent;
        return this;
    }

    public boolean isCanReply() {
        return canReply;
    }

    public Comment setCanReply(boolean canReply) {
        this.canReply = canReply;
        return this;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public Comment setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
        return this;
    }

    public boolean isReplied() {
        return replied;
    }

    public Comment setReplied(boolean replied) {
        this.replied = replied;
        return this;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", content='" + content + '\'' +
                ", shopId=" + shopId +
                ", createdAt='" + createdAt + '\'' +
                ", replied=" + replied +
                ", rating=" + rating +
                ", replyAt='" + replyAt + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", canReply=" + canReply +
                ", deliveryTime='" + deliveryTime + '\'' +
                '}';
    }
}
