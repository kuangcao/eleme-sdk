package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-10-19.
 */
public class DisplayAttribute implements Serializable {

    private List<Time> times; //分类分时-按时间段展示

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "DisplayAttribute{" +
                "times=" + times +
                '}';
    }
}
