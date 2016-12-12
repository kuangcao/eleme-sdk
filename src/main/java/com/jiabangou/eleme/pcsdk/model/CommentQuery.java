package com.jiabangou.eleme.pcsdk.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 评论查询条件
 * Created by freeway on 2016/12/11.
 */
public class CommentQuery implements Serializable {

    /**
     * 未回复差评
     */
    public static final String NEGATIVE_COMMENTS = "NegativeComments";

    /**
     * 未回复评论
     */
    public static final String NEW_COMMENTS = "NewComments";


    public static CommentQuery build() {
        return new CommentQuery().setLimit(20).setOffset(0);
    }

    public static CommentQuery buildLastSevenAll() {
        CommentQuery cq = new CommentQuery();
        LocalDate today = LocalDate.now();
        cq.setBeginDate(today.plusDays(-7).atStartOfDay().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        cq.setEndDate(today.plusDays(1).atStartOfDay().plusSeconds(-1).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        cq.setLimit(20);
        cq.setOffset(0);

        return cq;
    }

    private String beginDate;

    private String endDate;

    private Boolean hasContent;

    private int limit;

    private int offset;

    private Boolean replied;

    private String state;

    private String tag;

    public static String getNegativeComments() {
        return NEGATIVE_COMMENTS;
    }

    public static String getNewComments() {
        return NEW_COMMENTS;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public CommentQuery setBeginDate(String beginDate) {
        this.beginDate = beginDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public CommentQuery setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public Boolean isHasContent() {
        return hasContent;
    }

    public CommentQuery setHasContent(Boolean hasContent) {
        this.hasContent = hasContent;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public CommentQuery setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public CommentQuery setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public Boolean isReplied() {
        return replied;
    }

    public CommentQuery setReplied(Boolean replied) {
        this.replied = replied;
        return this;
    }

    public String getState() {
        return state;
    }

    public CommentQuery setState(String state) {
        this.state = state;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public CommentQuery setTag(String tag) {
        this.tag = tag;
        return this;
    }

    @Override
    public String toString() {
        return "CommentQuery{" +
                "beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", hasContent=" + hasContent +
                ", limit=" + limit +
                ", offset=" + offset +
                ", replied=" + replied +
                ", state='" + state + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
