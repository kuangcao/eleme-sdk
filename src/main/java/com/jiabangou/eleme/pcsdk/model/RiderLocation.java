package com.jiabangou.eleme.pcsdk.model;

import java.io.Serializable;

/**
 * 骑士地理位置
 * Created by freeway on 2016/12/12.
 */
public class RiderLocation implements Serializable {

    private Location customerLocation;
    private Location riderLocation;
    private Location rstLocation;

    public Location getCustomerLocation() {
        return customerLocation;
    }

    public RiderLocation setCustomerLocation(Location customerLocation) {
        this.customerLocation = customerLocation;
        return this;
    }

    public Location getRiderLocation() {
        return riderLocation;
    }

    public RiderLocation setRiderLocation(Location riderLocation) {
        this.riderLocation = riderLocation;
        return this;
    }

    public Location getRstLocation() {
        return rstLocation;
    }

    public RiderLocation setRstLocation(Location rstLocation) {
        this.rstLocation = rstLocation;
        return this;
    }

    public static class Location implements Serializable {
        private double latitude;
        private double longitude;
    }

    @Override
    public String toString() {
        return "RiderLocation{" +
                "customerLocation=" + customerLocation +
                ", riderLocation=" + riderLocation +
                ", rstLocation=" + rstLocation +
                '}';
    }
}
