package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by freeway on 16/7/18.
 */
public class RestaurantSave implements Serializable {

    private Long restaurant_id;
    /**
     * 餐厅地址
     */
    private String address_text;

    /**
     * longitude和latitude用英文逗号分隔
     */
    private String geo;

    /**
     * 配送费
     */
    private Float agent_fee;

    /**
     * 	string	关闭原因
     */
    private String close_description;

    /**
     * 配送区域详情
     */
    private String deliver_description;

    /**
     * 	餐厅描述
     */
    private String description;

    /**
     * 	string	餐厅名称
     */
    private String name;
    /**
     * 是否支持预定
     */
    private Short is_bookable;

    /**
     * 	string	营业时间bitmap bitmap说明
     * 	http://merchant.openapi.eleme.io/appendix/models.html#api-bitmap
     */
    private String open_time;

    /**
     * 餐厅联系电话
     */
    private String phone;

    /**
     * 	string	促销信息
     */
    private String promotion_info;

    /**
     * 餐厅Logo的图片image_hash（如何获得 /api/merchant/image ）
     */
    private String logo_image_hash;

    /**
     * 	是否支持开发票(是为1，否为0)
     */
    private Short invoice;

    /**
     * 支持的最小发票金额
     */
    private Float invoice_min_amount;
    /**
     * 	float	免配送费的最低消费额度
     */
    private Integer no_agent_fee_total;
    /**
     * 餐厅是否有效（上线、下线），0为无效，1为有效
     */
    private Integer is_valid;
    /**
     * 订单打包费，对于该店铺的每张订单，如果有店铺订单打包费，则采用该值；如果没有，则根据订单中的菜品来决定打包费。注：设置该值为 -1 表示禁用该值。
     */
    private Float packing_fee;

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getAddress_text() {
        return address_text;
    }

    public void setAddress_text(String address_text) {
        this.address_text = address_text;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public Float getAgent_fee() {
        return agent_fee;
    }

    public void setAgent_fee(Float agent_fee) {
        this.agent_fee = agent_fee;
    }

    public String getClose_description() {
        return close_description;
    }

    public void setClose_description(String close_description) {
        this.close_description = close_description;
    }

    public String getDeliver_description() {
        return deliver_description;
    }

    public void setDeliver_description(String deliver_description) {
        this.deliver_description = deliver_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getIs_bookable() {
        return is_bookable;
    }

    public void setIs_bookable(Short is_bookable) {
        this.is_bookable = is_bookable;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPromotion_info() {
        return promotion_info;
    }

    public void setPromotion_info(String promotion_info) {
        this.promotion_info = promotion_info;
    }

    public String getLogo_image_hash() {
        return logo_image_hash;
    }

    public void setLogo_image_hash(String logo_image_hash) {
        this.logo_image_hash = logo_image_hash;
    }

    public Short getInvoice() {
        return invoice;
    }

    public void setInvoice(Short invoice) {
        this.invoice = invoice;
    }

    public Float getInvoice_min_amount() {
        return invoice_min_amount;
    }

    public void setInvoice_min_amount(Float invoice_min_amount) {
        this.invoice_min_amount = invoice_min_amount;
    }

    public Integer getNo_agent_fee_total() {
        return no_agent_fee_total;
    }

    public void setNo_agent_fee_total(Integer no_agent_fee_total) {
        this.no_agent_fee_total = no_agent_fee_total;
    }

    public Integer getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(Integer is_valid) {
        this.is_valid = is_valid;
    }

    public Float getPacking_fee() {
        return packing_fee;
    }

    public void setPacking_fee(Float packing_fee) {
        this.packing_fee = packing_fee;
    }

    @Override
    public String toString() {
        return "RestaurantSave{" +
                "restaurant_id=" + restaurant_id +
                ", address_text='" + address_text + '\'' +
                ", geo='" + geo + '\'' +
                ", agent_fee=" + agent_fee +
                ", close_description='" + close_description + '\'' +
                ", deliver_description='" + deliver_description + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", is_bookable=" + is_bookable +
                ", open_time='" + open_time + '\'' +
                ", phone='" + phone + '\'' +
                ", promotion_info='" + promotion_info + '\'' +
                ", logo_image_hash='" + logo_image_hash + '\'' +
                ", invoice=" + invoice +
                ", invoice_min_amount=" + invoice_min_amount +
                ", no_agent_fee_total=" + no_agent_fee_total +
                ", is_valid=" + is_valid +
                ", packing_fee=" + packing_fee +
                '}';
    }
}
