package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-8-18.
 */
public class RestaurantGeo implements Serializable {

    private Geometry geometry;

    private String type;

    private Properties properties;

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "RestaurantGeo{" +
                "geometry=" + geometry +
                ", type='" + type + '\'' +
                ", properties=" + properties +
                '}';
    }

    public static class Geometry implements Serializable {
        private String type;
        /**
         * "coordinates": [[[121.381303, 31.243521]]], 最里层数组index[0] 代表精度，index[1] 代表维度
         */
        private List<List<List<Float>>> coordinates;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<List<List<Float>>> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(List<List<List<Float>>> coordinates) {
            this.coordinates = coordinates;
        }

        @Override
        public String toString() {
            return "Geometry{" +
                    "type='" + type + '\'' +
                    ", coordinates=" + coordinates +
                    '}';
        }
    }

    public static class Properties implements Serializable {
        //该区域起送价
        private Float delivery_price;
        //该区域配送费
        private Float area_agent_fee;

        public Float getDelivery_price() {
            return delivery_price;
        }

        public void setDelivery_price(Float delivery_price) {
            this.delivery_price = delivery_price;
        }

        public Float getArea_agent_fee() {
            return area_agent_fee;
        }

        public void setArea_agent_fee(Float area_agent_fee) {
            this.area_agent_fee = area_agent_fee;
        }

        @Override
        public String toString() {
            return "Properties{" +
                    "delivery_price=" + delivery_price +
                    ", area_agent_fee=" + area_agent_fee +
                    '}';
        }
    }


}


