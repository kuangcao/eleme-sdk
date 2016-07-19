package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by freeway on 16/7/18.
 */
public class Order implements Serializable {

    /**
     * 顾客送餐地址
     */
    private String address;
    /**
     * 下单时间
     */
    private String created_at;
    /**
     * 	datetime	订单生效时间(即支付时间)
     */
    private String active_at;
    /**
     * 	float	配送费
     */
    private Float deliver_fee;
    /**
     * 	datetime	送餐时间
     */
    private String deliver_time;
    /**
     * 	int	配送状态（仅用于第三方配送）
     */
    private int deliver_status;
    /**
     * 	string	订单备注
     */
    private String description;

    private Detail detail;

    /**
     * 发票抬头
     */
    private String invoice;
    /**
     * 是否预订单
     */
    private Short is_book;
    /**
     * 是否在线支付
     */
    private Short is_online_paid;

    /**
     * 饿了么订单id
     */
    private Long order_id;

    /**
     * 顾客联系电话
     */
    private List<String> phone_list;
    /**
     *
     */
    private String tp_restaurant_id;
    /**
     * 餐厅id
     */
    private Long restaurant_id;
    /**
     * 餐厅名称
     */
    private String restaurant_name;
    /**
     * 餐厅当日订单序号
     */
    private Long restaurant_number;
    /**
     * 订单状态
     */
    private Short status_code;
    /**
     * 用户id
     */
    private Long user_id;
    /**
     * 用户名称
     */
    private String user_name;
    /**
     * 订单总价（单位：元）
     */
    private Float total_price;
    /**
     * 原始价格（优惠前的价格，即菜价加上配送费和打包费，单位：元）
     */
    private Float original_price;
    /**
     * 订单收货人
     */
    private String consignee;
    /**
     * 订单收货地址经纬度，例如：31.2538,121.4185
     */
    private String delivery_geo;
    /**
     * 顾客送餐详情地址，例如：近铁城市广场（普陀区金沙江路1518弄)
     */
    private String delivery_poi_address;
    /**
     * 是否需要发票，0-不需要，1-需要
     */
    private Short invoiced;
    /**
     * 店铺实收
     */
    private Float income;
    /**
     * 饿了么服务费率
     */
    private Float service_rate;
    /**
     * 饿了么服务费
     */
    private Float service_fee;
    /**
     * 订单中红包金额
     */
    private Float hongbao;
    /**
     * 餐盒费
     */
    private Float package_fee;
    /**
     * 订单活动总额
     */
    private Float activity_total;

    /**
     * 店铺承担活动费用
     */
    private Float restaurant_part;

    /**
     * 饿了么承担活动费用
     */
    private Float eleme_part;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getActive_at() {
        return active_at;
    }

    public void setActive_at(String active_at) {
        this.active_at = active_at;
    }

    public Float getDeliver_fee() {
        return deliver_fee;
    }

    public void setDeliver_fee(Float deliver_fee) {
        this.deliver_fee = deliver_fee;
    }

    public String getDeliver_time() {
        return deliver_time;
    }

    public void setDeliver_time(String deliver_time) {
        this.deliver_time = deliver_time;
    }

    public int getDeliver_status() {
        return deliver_status;
    }

    public void setDeliver_status(int deliver_status) {
        this.deliver_status = deliver_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Short getIs_book() {
        return is_book;
    }

    public void setIs_book(Short is_book) {
        this.is_book = is_book;
    }

    public Short getIs_online_paid() {
        return is_online_paid;
    }

    public void setIs_online_paid(Short is_online_paid) {
        this.is_online_paid = is_online_paid;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public List<String> getPhone_list() {
        return phone_list;
    }

    public void setPhone_list(List<String> phone_list) {
        this.phone_list = phone_list;
    }

    public String getTp_restaurant_id() {
        return tp_restaurant_id;
    }

    public void setTp_restaurant_id(String tp_restaurant_id) {
        this.tp_restaurant_id = tp_restaurant_id;
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public Long getRestaurant_number() {
        return restaurant_number;
    }

    public void setRestaurant_number(Long restaurant_number) {
        this.restaurant_number = restaurant_number;
    }

    public Short getStatus_code() {
        return status_code;
    }

    public void setStatus_code(Short status_code) {
        this.status_code = status_code;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Float total_price) {
        this.total_price = total_price;
    }

    public Float getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Float original_price) {
        this.original_price = original_price;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getDelivery_geo() {
        return delivery_geo;
    }

    public void setDelivery_geo(String delivery_geo) {
        this.delivery_geo = delivery_geo;
    }

    public String getDelivery_poi_address() {
        return delivery_poi_address;
    }

    public void setDelivery_poi_address(String delivery_poi_address) {
        this.delivery_poi_address = delivery_poi_address;
    }

    public Short getInvoiced() {
        return invoiced;
    }

    public void setInvoiced(Short invoiced) {
        this.invoiced = invoiced;
    }

    public Float getIncome() {
        return income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }

    public Float getService_rate() {
        return service_rate;
    }

    public void setService_rate(Float service_rate) {
        this.service_rate = service_rate;
    }

    public Float getService_fee() {
        return service_fee;
    }

    public void setService_fee(Float service_fee) {
        this.service_fee = service_fee;
    }

    public Float getHongbao() {
        return hongbao;
    }

    public void setHongbao(Float hongbao) {
        this.hongbao = hongbao;
    }

    public Float getPackage_fee() {
        return package_fee;
    }

    public void setPackage_fee(Float package_fee) {
        this.package_fee = package_fee;
    }

    public Float getActivity_total() {
        return activity_total;
    }

    public void setActivity_total(Float activity_total) {
        this.activity_total = activity_total;
    }

    public Float getRestaurant_part() {
        return restaurant_part;
    }

    public void setRestaurant_part(Float restaurant_part) {
        this.restaurant_part = restaurant_part;
    }

    public Float getEleme_part() {
        return eleme_part;
    }

    public void setEleme_part(Float eleme_part) {
        this.eleme_part = eleme_part;
    }

    @Override
    public String toString() {
        return "Order{" +
                "address='" + address + '\'' +
                ", created_at='" + created_at + '\'' +
                ", active_at='" + active_at + '\'' +
                ", deliver_fee=" + deliver_fee +
                ", deliver_time='" + deliver_time + '\'' +
                ", deliver_status=" + deliver_status +
                ", description='" + description + '\'' +
                ", detail=" + detail +
                ", invoice='" + invoice + '\'' +
                ", is_book=" + is_book +
                ", is_online_paid=" + is_online_paid +
                ", order_id=" + order_id +
                ", phone_list=" + phone_list +
                ", tp_restaurant_id='" + tp_restaurant_id + '\'' +
                ", restaurant_id=" + restaurant_id +
                ", restaurant_name='" + restaurant_name + '\'' +
                ", restaurant_number=" + restaurant_number +
                ", status_code=" + status_code +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", total_price=" + total_price +
                ", original_price=" + original_price +
                ", consignee='" + consignee + '\'' +
                ", delivery_geo='" + delivery_geo + '\'' +
                ", delivery_poi_address='" + delivery_poi_address + '\'' +
                ", invoiced=" + invoiced +
                ", income=" + income +
                ", service_rate=" + service_rate +
                ", service_fee=" + service_fee +
                ", hongbao=" + hongbao +
                ", package_fee=" + package_fee +
                ", activity_total=" + activity_total +
                ", restaurant_part=" + restaurant_part +
                ", eleme_part=" + eleme_part +
                '}';
    }

    public static class Detail implements Serializable {
        private List<List<OrderItem>> group;
        private List<Extra> extra;

        public List<Extra> getExtra() {
            return extra;
        }

        public void setExtra(List<Extra> extra) {
            this.extra = extra;
        }

        public List<List<OrderItem>> getGroup() {
            return group;
        }

        public void setGroup(List<List<OrderItem>> group) {
            this.group = group;
        }

        @Override
        public String toString() {
            return "Detail{" +
                    "group=" + group +
                    ", extra=" + extra +
                    '}';
        }
    }

    public static class Extra implements Serializable {
        /**
         * 	订单项的名称
         */
        private String name;
        /**
         * 	金额（单位：元），金额分正负，比如优惠为负，配送费为正
         */
        private Float price;
        /**
         * 	说明
         */
        private String description;
        /**
         * 	id唯一标识这个实体（可能是活动，可能是打包费、配送费等）
         */
        private Long id;
        /**
         * 	唯一标识该订单项目的ID
         * 	@see <http://merchant.openapi.eleme.io/appendix/enums.html#enum-entity-category>
         */
        private Long category_id;

        /**
         * 	项目类型，不同category_id下的type会不一样
         * 	@see <http://merchant.openapi.eleme.io/appendix/enums.html#enum-restaurant-activity-type>
         */
        private Long type;
        /**
         * 	数量
         */
        private Integer quantity;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getCategory_id() {
            return category_id;
        }

        public void setCategory_id(Long category_id) {
            this.category_id = category_id;
        }

        public Long getType() {
            return type;
        }

        public void setType(Long type) {
            this.type = type;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Extra{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", description='" + description + '\'' +
                    ", id=" + id +
                    ", category_id=" + category_id +
                    ", type=" + type +
                    ", quantity=" + quantity +
                    '}';
        }
    }

    public static class OrderItem implements Serializable {
        private Long id;
        private String tp_food_id;
        private int quantity;
        private Long category_id;
        private String name;
        private Float price;
        private List<OrderItem> garnish;
        private List<String> specs;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTp_food_id() {
            return tp_food_id;
        }

        public void setTp_food_id(String tp_food_id) {
            this.tp_food_id = tp_food_id;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Long getCategory_id() {
            return category_id;
        }

        public void setCategory_id(Long category_id) {
            this.category_id = category_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }

        public List<OrderItem> getGarnish() {
            return garnish;
        }

        public void setGarnish(List<OrderItem> garnish) {
            this.garnish = garnish;
        }

        public List<String> getSpecs() {
            return specs;
        }

        public void setSpecs(List<String> specs) {
            this.specs = specs;
        }

        @Override
        public String toString() {
            return "OrderItem{" +
                    "id=" + id +
                    ", tp_food_id='" + tp_food_id + '\'' +
                    ", quantity=" + quantity +
                    ", category_id=" + category_id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", garnish=" + garnish +
                    ", specs=" + specs +
                    '}';
        }
    }
}
