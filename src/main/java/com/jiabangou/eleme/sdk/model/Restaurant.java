package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * 餐厅基本信息
 * @see <http://merchant.openapi.eleme.io/appendix/models.html#model-restaurant-base>
 * Created by freeway on 16/7/17.
 */
public class Restaurant implements Serializable {
    private Long id;
    /**
     * 餐厅地址
     */
    private String address_text;

    /**
     * 配送费
     */
    private Float agent_fee;

    /**
     * 联系电话列表
     */
    private List<String> phone_list;

    /**
     * 餐厅繁忙状态，详见附录
     */
    private Integer busy_level;

    /**
     * 城市id，详见附录
     */
    private Integer city_id;

    /**
     * 城市区号(021, 010等)
     */
    private String city_code;

    /**
     * 	string	关闭原因
     */
    private String close_description;

    /**
     * 	起送价
     */
    private Float deliver_amount;

    /**
     * 配送区域详情
     */
    private String deliver_description;

    /**
     * 配送范围，详情请咨询饿了么
     */
    private String deliver_geojson;

    /**
     * 	2周内的平均送餐时间
     */
    private Integer deliver_spent;

    /**
     * 	餐厅描述
     */
    private String description;

    /**
     * 	餐厅口味
     */
    private String flavors;

    /**
     * 	餐厅Logo地址
     */
    private String image_url;

    /**
     * 	是否支持开发票(是为1，否为0)
     */
    private Short invoice;

    /**
     * 支持的最小发票金额
     */
    private Float invoice_min_amount;

    /**
     * 是否支持预定
     */
    private Short is_bookable;

    /**
     * 	string	营业时间bitmap bitmap说明
     * 	@see <http://merchant.openapi.eleme.io/appendix/models.html#api-bitmap>
     */
    private String open_time_bitmap;

    /**
     * 	string	预定时间bitmap bitmap说明
     * 	@see <http://merchant.openapi.eleme.io/appendix/models.html#api-bitmap>
     */
    private String book_time_bitmap;

    /**
     * 	string list	预定时间选项 预订单说明
     */
    private List<String> deliver_times;

    /**
     * 	bool	是否正在营业
     */
    private Boolean is_open;

    /**
     * 	int	是否隐藏电话号码
     */
    private Short is_phone_hidden;

    /**
     * 	int	是否品牌馆餐厅
     */
    private Short is_premium;

    /**
     * 	int	是否支持超时赔付
     */
    private Short is_time_ensure;

    /**
     * 	string	超时赔付详细信息
     */
    private String time_ensure_full_description;

    /**
     * 	float	纬度
     */
    private Float latitude;

    /**
     * 	float	经度
     */
    private Float longitude;

    /**
     * 	string	餐厅接收饿了么短信的号码
     */
    private String mobile;
    /**
     * 	float	免配送费的最低消费额度
     */
    private Float no_agent_fee_total;

    /**
     * 	int list	餐厅评价，依次为1-5星评价的数目
     */
    private List<Integer> num_ratings;

    /**
     * 	int	订单模式，详见附录
     */
    private Integer order_mode;

    /**
     * 	int	是否支持在线支付
     */
    private Integer online_payment;

    /**
     * 未知
     */
    private Integer payment_method;

    /**
     * 	string	促销信息
     */
    private String promotion_info;

    /**
     * 	int	最近一个月美食销量
     */
    private Integer recent_food_popularity;

    /**
     * 	string	餐厅名称
     */
    private String restaurant_name;

    /**
     * 	string	餐厅手机站url
     */
    private String restaurant_murl;

    /**
     * 	string	餐厅PC站url
     */
    private String restaurant_url;

    /**
     * 	string list	营业时间
     */
    private List<String> serving_time;

    /**
     * 	int	是否支持在线订餐
     */
    private Boolean support_online;

    /**
     * 	int	自配送餐厅合作类型
     */
    private Integer service_category;

    /**
     * 	float	订单打包费，对于该店铺的每张订单，如果有店铺订单打包费，则采用该值；如果没有，则根据订单中的菜品来决定打包费。
     */
    private Float packing_fee;

    public String getAddress_text() {
        return address_text;
    }

    public void setAddress_text(String address_text) {
        this.address_text = address_text;
    }

    public Float getAgent_fee() {
        return agent_fee;
    }

    public void setAgent_fee(Float agent_fee) {
        this.agent_fee = agent_fee;
    }

    public List<String> getPhone_list() {
        return phone_list;
    }

    public void setPhone_list(List<String> phone_list) {
        this.phone_list = phone_list;
    }

    public Integer getBusy_level() {
        return busy_level;
    }

    public void setBusy_level(Integer busy_level) {
        this.busy_level = busy_level;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getClose_description() {
        return close_description;
    }

    public void setClose_description(String close_description) {
        this.close_description = close_description;
    }

    public Float getDeliver_amount() {
        return deliver_amount;
    }

    public void setDeliver_amount(Float deliver_amount) {
        this.deliver_amount = deliver_amount;
    }

    public String getDeliver_description() {
        return deliver_description;
    }

    public void setDeliver_description(String deliver_description) {
        this.deliver_description = deliver_description;
    }

    public String getDeliver_geojson() {
        return deliver_geojson;
    }

    public void setDeliver_geojson(String deliver_geojson) {
        this.deliver_geojson = deliver_geojson;
    }

    public Integer getDeliver_spent() {
        return deliver_spent;
    }

    public void setDeliver_spent(Integer deliver_spent) {
        this.deliver_spent = deliver_spent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlavors() {
        return flavors;
    }

    public void setFlavors(String flavors) {
        this.flavors = flavors;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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

    public Short getIs_bookable() {
        return is_bookable;
    }

    public void setIs_bookable(Short is_bookable) {
        this.is_bookable = is_bookable;
    }

    public String getOpen_time_bitmap() {
        return open_time_bitmap;
    }

    public void setOpen_time_bitmap(String open_time_bitmap) {
        this.open_time_bitmap = open_time_bitmap;
    }

    public String getBook_time_bitmap() {
        return book_time_bitmap;
    }

    public void setBook_time_bitmap(String book_time_bitmap) {
        this.book_time_bitmap = book_time_bitmap;
    }

    public List<String> getDeliver_times() {
        return deliver_times;
    }

    public void setDeliver_times(List<String> deliver_times) {
        this.deliver_times = deliver_times;
    }

    public Boolean getIs_open() {
        return is_open;
    }

    public void setIs_open(Boolean is_open) {
        this.is_open = is_open;
    }

    public Short getIs_phone_hidden() {
        return is_phone_hidden;
    }

    public void setIs_phone_hidden(Short is_phone_hidden) {
        this.is_phone_hidden = is_phone_hidden;
    }

    public Short getIs_premium() {
        return is_premium;
    }

    public void setIs_premium(Short is_premium) {
        this.is_premium = is_premium;
    }

    public Short getIs_time_ensure() {
        return is_time_ensure;
    }

    public void setIs_time_ensure(Short is_time_ensure) {
        this.is_time_ensure = is_time_ensure;
    }

    public String getTime_ensure_full_description() {
        return time_ensure_full_description;
    }

    public void setTime_ensure_full_description(String time_ensure_full_description) {
        this.time_ensure_full_description = time_ensure_full_description;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Float getNo_agent_fee_total() {
        return no_agent_fee_total;
    }

    public void setNo_agent_fee_total(Float no_agent_fee_total) {
        this.no_agent_fee_total = no_agent_fee_total;
    }

    public List<Integer> getNum_ratings() {
        return num_ratings;
    }

    public void setNum_ratings(List<Integer> num_ratings) {
        this.num_ratings = num_ratings;
    }

    public Integer getOrder_mode() {
        return order_mode;
    }

    public void setOrder_mode(Integer order_mode) {
        this.order_mode = order_mode;
    }

    public Integer getOnline_payment() {
        return online_payment;
    }

    public void setOnline_payment(Integer online_payment) {
        this.online_payment = online_payment;
    }

    public Integer getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(Integer payment_method) {
        this.payment_method = payment_method;
    }

    public String getPromotion_info() {
        return promotion_info;
    }

    public void setPromotion_info(String promotion_info) {
        this.promotion_info = promotion_info;
    }

    public Integer getRecent_food_popularity() {
        return recent_food_popularity;
    }

    public void setRecent_food_popularity(Integer recent_food_popularity) {
        this.recent_food_popularity = recent_food_popularity;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestaurant_murl() {
        return restaurant_murl;
    }

    public void setRestaurant_murl(String restaurant_murl) {
        this.restaurant_murl = restaurant_murl;
    }

    public String getRestaurant_url() {
        return restaurant_url;
    }

    public void setRestaurant_url(String restaurant_url) {
        this.restaurant_url = restaurant_url;
    }

    public List<String> getServing_time() {
        return serving_time;
    }

    public void setServing_time(List<String> serving_time) {
        this.serving_time = serving_time;
    }

    public Boolean getSupport_online() {
        return support_online;
    }

    public void setSupport_online(Boolean support_online) {
        this.support_online = support_online;
    }

    public Integer getService_category() {
        return service_category;
    }

    public void setService_category(Integer service_category) {
        this.service_category = service_category;
    }

    public Float getPacking_fee() {
        return packing_fee;
    }

    public void setPacking_fee(Float packing_fee) {
        this.packing_fee = packing_fee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", address_text='" + address_text + '\'' +
                ", agent_fee=" + agent_fee +
                ", phone_list=" + phone_list +
                ", busy_level=" + busy_level +
                ", city_id=" + city_id +
                ", city_code='" + city_code + '\'' +
                ", close_description='" + close_description + '\'' +
                ", deliver_amount=" + deliver_amount +
                ", deliver_description='" + deliver_description + '\'' +
                ", deliver_geojson='" + deliver_geojson + '\'' +
                ", deliver_spent=" + deliver_spent +
                ", description='" + description + '\'' +
                ", flavors='" + flavors + '\'' +
                ", image_url='" + image_url + '\'' +
                ", invoice=" + invoice +
                ", invoice_min_amount=" + invoice_min_amount +
                ", is_bookable=" + is_bookable +
                ", open_time_bitmap='" + open_time_bitmap + '\'' +
                ", book_time_bitmap='" + book_time_bitmap + '\'' +
                ", deliver_times=" + deliver_times +
                ", is_open=" + is_open +
                ", is_phone_hidden=" + is_phone_hidden +
                ", is_premium=" + is_premium +
                ", is_time_ensure=" + is_time_ensure +
                ", time_ensure_full_description='" + time_ensure_full_description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", mobile='" + mobile + '\'' +
                ", no_agent_fee_total=" + no_agent_fee_total +
                ", num_ratings=" + num_ratings +
                ", order_mode=" + order_mode +
                ", online_payment=" + online_payment +
                ", payment_method=" + payment_method +
                ", promotion_info='" + promotion_info + '\'' +
                ", recent_food_popularity=" + recent_food_popularity +
                ", restaurant_name='" + restaurant_name + '\'' +
                ", restaurant_murl='" + restaurant_murl + '\'' +
                ", restaurant_url='" + restaurant_url + '\'' +
                ", serving_time=" + serving_time +
                ", support_online=" + support_online +
                ", service_category=" + service_category +
                ", packing_fee=" + packing_fee +
                '}';
    }
}
