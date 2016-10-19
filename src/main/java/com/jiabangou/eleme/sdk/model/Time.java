package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-10-19.
 */
public class Time implements Serializable {

    private String start_time;
    private String end_time;

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Time{" +
                "start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                '}';
    }
}
