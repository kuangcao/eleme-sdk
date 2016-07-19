package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * 订单配送信息
 * Created by freeway on 16/7/19.
 */
public class OrderDelivery implements Serializable {

    private Long eleme_order_id;
    private List<Delivery> records;

    public Long getEleme_order_id() {
        return eleme_order_id;
    }

    public void setEleme_order_id(Long eleme_order_id) {
        this.eleme_order_id = eleme_order_id;
    }

    public List<Delivery> getRecords() {
        return records;
    }

    public void setRecords(List<Delivery> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "OrderDelivery{" +
                "eleme_order_id=" + eleme_order_id +
                ", records=" + records +
                '}';
    }

    public static class Delivery implements Serializable {
        private Deliveryman deliveryman_info;
        private Long updated_at;
        private Short status_code;
        private Short sub_status_code;

        public Deliveryman getDeliveryman_info() {
            return deliveryman_info;
        }

        public void setDeliveryman_info(Deliveryman deliveryman_info) {
            this.deliveryman_info = deliveryman_info;
        }

        public Long getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(Long updated_at) {
            this.updated_at = updated_at;
        }

        /**
         * 配送状态
         * @see <http://merchant.openapi.eleme.io/appendix/enums.html#enum-delivery-status>
         * @return
         */
        public Short getStatus_code() {
            return status_code;
        }

        public void setStatus_code(Short status_code) {
            this.status_code = status_code;
        }

        /**
         * 配送子状态(当配送状态为CANCELLED或者EXCEPTION使用)
         * @see <http://merchant.openapi.eleme.io/appendix/enums.html#cancelledexception>
         * @return
         */
        public Short getSub_status_code() {
            return sub_status_code;
        }

        public void setSub_status_code(Short sub_status_code) {
            this.sub_status_code = sub_status_code;
        }

        @Override
        public String toString() {
            return "Delivery{" +
                    "deliveryman_info=" + deliveryman_info +
                    ", updated_at=" + updated_at +
                    ", status_code=" + status_code +
                    ", sub_status_code=" + sub_status_code +
                    '}';
        }
    }

    public static class Deliveryman implements Serializable {
        private String deliveryman_name;
        private String deliveryman_phone;

        public String getDeliveryman_name() {
            return deliveryman_name;
        }

        public void setDeliveryman_name(String deliveryman_name) {
            this.deliveryman_name = deliveryman_name;
        }

        public String getDeliveryman_phone() {
            return deliveryman_phone;
        }

        public void setDeliveryman_phone(String deliveryman_phone) {
            this.deliveryman_phone = deliveryman_phone;
        }

        @Override
        public String toString() {
            return "Deliveryman{" +
                    "deliveryman_name='" + deliveryman_name + '\'' +
                    ", deliveryman_phone='" + deliveryman_phone + '\'' +
                    '}';
        }
    }

}
