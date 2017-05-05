package com.jiabangou.eleme.pcsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * 订单对象
 * 对应返回的json
 *
 * Created by freeway on 2016/12/6.
 */
public class Order implements Serializable {

//    {
//        "ncp": "2.0.0",
//            "id": "c8d72d73-1462-4b5b-a496-c75e21d2f129",
//            "result": [
//        {
//            "id": "101670666683827524",
//                "shopId": 1809202,
//                "shopName": "全聚德（北沙滩店）测试3店",
//                "restaurantName": "全聚德（北沙滩店）测试3店",
//                "daySn": 2,
//                "activeTime": "2016-12-06T15:07:06",
//                "remark": "",
//                "payment": "ONLINE",
//                "bookedTime": null,
//                "invoiceTitle": null,
//                "groups": [
//            {
//                "name": "1号篮子",
//                    "type": "NORMAL",
//                    "items": [
//                {
//                    "id": 170268233,
//                        "name": "WM-MT-GBAA",
//                        "categoryId": 1,
//                        "price": 0,
//                        "quantity": 2,
//                        "total": 0,
//                        "discount": 0,
//                        "displayQuantity": true,
//                        "additions": []
//                }
//                ]
//            }
//            ],
//            "paymentStatus": "SUCCESS",
//                "status": "UNPROCESSED",
//                "invalidType": null,
//                "invalidRemark": null,
//                "tips": [],
//            "followed": false,
//                "consigneeName": "hu wei 先生",
//                "consigneePhones": [
//            "18657128771"
//            ],
//            "consigneeSecretPhones": [],
//            "phoneAlertDescription": "",
//                "secretPhoneExpireTime": null,
//                "consigneeAddress": "北沙滩[地铁站] [地铁站]呵呵",
//                "distance": "339m",
//                "times": 1,
//                "payAmount": 0.01,
//                "income": 0,
//                "hongbao": 0,
//                "restaurantPart": 0,
//                "elemePart": 0,
//                "elemeMerchantSubsidy": 0,
//                "deliveryCost": 0,
//                "deliveryFee": 0,
//                "vipDeliveryFeeDiscount": 0,
//                "packageFee": 0,
//                "serviceRate": 0,
//                "serviceFee": 0,
//                "goodsTotal": 0,
//                "goodsTotalWithoutPackage": 0,
//                "activityTotal": 0,
//                "activities": [],
//            "merchantActivities": [],
//            "elemeActivityPart": 0,
//                "elemeActivityPartPositive": 0,
//                "merchantActivityPart": 0,
//                "orderTraceButton": "NONE",
//                "orderTraceRenderViews": [],
//            "cookingTime": null,
//                "expectDeliveryCost": 0,
//                "expectDeliveryCostForDetail": 0,
//                "expectDeliveryCostDetail": [],
//            "feedbackStatus": "WAITING",
//                "reminderOrder": null,
//                "downgraded": false,
//                "showConfirmOrderButton": true,
//                "showPrintOrderButton": false,
//                "showInvalidOrderButton": true,
//                "showNoMoreDeliveryButton": false,
//                "showSetDeliveryBySelfButton": false,
//                "showDeliveryBySelfOnCancelled": false,
//                "showAgreeCancelOrderButton": false,
//                "showDisagreeCancelOrderButton": false,
//                "showReadCancelOrderButton": false,
//                "showAgreeRefundOrderButton": false,
//                "showDisagreeRefundOrderButton": false,
//                "callDeliveryType": "DISABLE",
//                "showReadExceptionOrderButton": false,
//                "merchantDeliverySubsidy": 0,
//                "customerActualFee": 0,
//                "deliveryFeeTotal": 0,
//                "uavLoad": null,
//                "uavUnload": null,
//                "uavReferCode": null,
//                "orderType": "NORMAL",
//                "anonymousOrder": false
//        }
//        ],
//        "error": null
//    }

    private String id;
    private Long shopId;
    private String shopName;
    private String restaurantName;
    private Integer daySn;
    private String activeTime;
    private String remark;
    private String payment;
    private String bookedTime;
    private String invoiceTitle;
    private List<Group> groups;
    private String paymentStatus;
    private String status;
    private List<String> tips;
    private String consigneeName;
    private List<String> consigneePhones;
    private String consigneeAddress;
    private double payAmount;
    private String distance;
    private int income;
    private int hongbao;
    private int restaurantPart;
    private int elemePart;
    private int elemeMerchantSubsidy;
    private int deliveryCost;
    private int deliveryFee;
    private int vipDeliveryFeeDiscount;
    private int packageFee;
    private int serviceRate;
    private int serviceFee;
    private int goodsTotal;
    private int goodsTotalWithoutPackage;
    private int activityTotal;
    private double deliveryFeeTotal;
    private double customerActualFee;
    private String callDeliveryType;
    private String orderType;
    private int merchantDeliverySubsidy;
    private boolean anonymousOrder = false;
    private boolean downgraded;
    private String feedbackStatus;

    public String getId() {
        return id;
    }

    public Order setId(String id) {
        this.id = id;
        return this;
    }

    public Long getShopId() {
        return shopId;
    }

    public Order setShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public String getShopName() {
        return shopName;
    }

    public Order setShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public Order setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }

    public Integer getDaySn() {
        return daySn;
    }

    public Order setDaySn(Integer daySn) {
        this.daySn = daySn;
        return this;
    }

    public String getActiveTime() {
        return activeTime;
    }

    public Order setActiveTime(String activeTime) {
        this.activeTime = activeTime;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Order setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getPayment() {
        return payment;
    }

    public Order setPayment(String payment) {
        this.payment = payment;
        return this;
    }

    public String getBookedTime() {
        return bookedTime;
    }

    public Order setBookedTime(String bookedTime) {
        this.bookedTime = bookedTime;
        return this;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public Order setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
        return this;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Order setGroups(List<Group> groups) {
        this.groups = groups;
        return this;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public Order setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Order setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<String> getTips() {
        return tips;
    }

    public Order setTips(List<String> tips) {
        this.tips = tips;
        return this;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public Order setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
        return this;
    }

    public List<String> getConsigneePhones() {
        return consigneePhones;
    }

    public Order setConsigneePhones(List<String> consigneePhones) {
        this.consigneePhones = consigneePhones;
        return this;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public Order setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
        return this;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public Order setPayAmount(double payAmount) {
        this.payAmount = payAmount;
        return this;
    }

    public String getDistance() {
        return distance;
    }

    public Order setDistance(String distance) {
        this.distance = distance;
        return this;
    }

    public int getIncome() {
        return income;
    }

    public Order setIncome(int income) {
        this.income = income;
        return this;
    }

    public int getHongbao() {
        return hongbao;
    }

    public Order setHongbao(int hongbao) {
        this.hongbao = hongbao;
        return this;
    }

    public int getRestaurantPart() {
        return restaurantPart;
    }

    public Order setRestaurantPart(int restaurantPart) {
        this.restaurantPart = restaurantPart;
        return this;
    }

    public int getElemePart() {
        return elemePart;
    }

    public Order setElemePart(int elemePart) {
        this.elemePart = elemePart;
        return this;
    }

    public int getElemeMerchantSubsidy() {
        return elemeMerchantSubsidy;
    }

    public Order setElemeMerchantSubsidy(int elemeMerchantSubsidy) {
        this.elemeMerchantSubsidy = elemeMerchantSubsidy;
        return this;
    }

    public int getDeliveryCost() {
        return deliveryCost;
    }

    public Order setDeliveryCost(int deliveryCost) {
        this.deliveryCost = deliveryCost;
        return this;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public Order setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
        return this;
    }

    public int getVipDeliveryFeeDiscount() {
        return vipDeliveryFeeDiscount;
    }

    public Order setVipDeliveryFeeDiscount(int vipDeliveryFeeDiscount) {
        this.vipDeliveryFeeDiscount = vipDeliveryFeeDiscount;
        return this;
    }

    public int getPackageFee() {
        return packageFee;
    }

    public Order setPackageFee(int packageFee) {
        this.packageFee = packageFee;
        return this;
    }

    public int getServiceRate() {
        return serviceRate;
    }

    public Order setServiceRate(int serviceRate) {
        this.serviceRate = serviceRate;
        return this;
    }

    public int getServiceFee() {
        return serviceFee;
    }

    public Order setServiceFee(int serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public int getGoodsTotal() {
        return goodsTotal;
    }

    public Order setGoodsTotal(int goodsTotal) {
        this.goodsTotal = goodsTotal;
        return this;
    }

    public int getGoodsTotalWithoutPackage() {
        return goodsTotalWithoutPackage;
    }

    public Order setGoodsTotalWithoutPackage(int goodsTotalWithoutPackage) {
        this.goodsTotalWithoutPackage = goodsTotalWithoutPackage;
        return this;
    }

    public int getActivityTotal() {
        return activityTotal;
    }

    public Order setActivityTotal(int activityTotal) {
        this.activityTotal = activityTotal;
        return this;
    }

    public double getDeliveryFeeTotal() {
        return deliveryFeeTotal;
    }

    public Order setDeliveryFeeTotal(double deliveryFeeTotal) {
        this.deliveryFeeTotal = deliveryFeeTotal;
        return this;
    }

    public double getCustomerActualFee() {
        return customerActualFee;
    }

    public Order setCustomerActualFee(double customerActualFee) {
        this.customerActualFee = customerActualFee;
        return this;
    }

    public String getCallDeliveryType() {
        return callDeliveryType;
    }

    public Order setCallDeliveryType(String callDeliveryType) {
        this.callDeliveryType = callDeliveryType;
        return this;
    }

    public String getOrderType() {
        return orderType;
    }

    public Order setOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    public int getMerchantDeliverySubsidy() {
        return merchantDeliverySubsidy;
    }

    public Order setMerchantDeliverySubsidy(int merchantDeliverySubsidy) {
        this.merchantDeliverySubsidy = merchantDeliverySubsidy;
        return this;
    }

    public boolean isAnonymousOrder() {
        return anonymousOrder;
    }

    public Order setAnonymousOrder(boolean anonymousOrder) {
        this.anonymousOrder = anonymousOrder;
        return this;
    }

    public static class Group implements Serializable {
        private String name;
        private String type;
        private List<OrderItem> items;

        public String getName() {
            return name;
        }

        public Group setName(String name) {
            this.name = name;
            return this;
        }

        public String getType() {
            return type;
        }

        public Group setType(String type) {
            this.type = type;
            return this;
        }

        public List<OrderItem> getItems() {
            return items;
        }

        public Group setItems(List<OrderItem> items) {
            this.items = items;
            return this;
        }

        @Override
        public String toString() {
            return "Group{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", items=" + items +
                    '}';
        }
    }

    public static class OrderItem implements Serializable {
        private Long id;
        private int quantity;
        private Long categoryId;
        private String name;
        private Float price;

        public Long getId() {
            return id;
        }

        public OrderItem setId(Long id) {
            this.id = id;
            return this;
        }

        public int getQuantity() {
            return quantity;
        }

        public OrderItem setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Long getCategoryId() {
            return categoryId;
        }

        public OrderItem setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public String getName() {
            return name;
        }

        public OrderItem setName(String name) {
            this.name = name;
            return this;
        }

        public Float getPrice() {
            return price;
        }

        public OrderItem setPrice(Float price) {
            this.price = price;
            return this;
        }

        @Override
        public String toString() {
            return "OrderItem{" +
                    "id=" + id +
                    ", quantity=" + quantity +
                    ", categoryId=" + categoryId +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", daySn=" + daySn +
                ", activeTime='" + activeTime + '\'' +
                ", remark='" + remark + '\'' +
                ", payment='" + payment + '\'' +
                ", bookedTime='" + bookedTime + '\'' +
                ", invoiceTitle='" + invoiceTitle + '\'' +
                ", groups=" + groups +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", status='" + status + '\'' +
                ", tips=" + tips +
                ", consigneeName='" + consigneeName + '\'' +
                ", consigneePhones=" + consigneePhones +
                ", consigneeAddress='" + consigneeAddress + '\'' +
                ", payAmount=" + payAmount +
                ", distance='" + distance + '\'' +
                ", income=" + income +
                ", hongbao=" + hongbao +
                ", restaurantPart=" + restaurantPart +
                ", elemePart=" + elemePart +
                ", elemeMerchantSubsidy=" + elemeMerchantSubsidy +
                ", deliveryCost=" + deliveryCost +
                ", deliveryFee=" + deliveryFee +
                ", vipDeliveryFeeDiscount=" + vipDeliveryFeeDiscount +
                ", packageFee=" + packageFee +
                ", serviceRate=" + serviceRate +
                ", serviceFee=" + serviceFee +
                ", goodsTotal=" + goodsTotal +
                ", goodsTotalWithoutPackage=" + goodsTotalWithoutPackage +
                ", activityTotal=" + activityTotal +
                ", deliveryFeeTotal=" + deliveryFeeTotal +
                ", customerActualFee=" + customerActualFee +
                ", callDeliveryType='" + callDeliveryType + '\'' +
                ", orderType='" + orderType + '\'' +
                ", merchantDeliverySubsidy=" + merchantDeliverySubsidy +
                ", anonymousOrder=" + anonymousOrder +
                '}';
    }
}
