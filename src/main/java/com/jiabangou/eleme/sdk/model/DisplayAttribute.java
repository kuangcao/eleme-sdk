package com.jiabangou.eleme.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-10-19.
 */
public class DisplayAttribute implements Serializable {

    private List<Time> times; //分类分时-按时间段展示
    private List<Integer> weekdays; //取值范围在 1,2,3,4,5,6,7 分别对应了星期一到星期日
    private String begin_date_time; //必须成对出现、格式必须是‘2016-09-03 12:00:00’,并且end_date_time所表示的时间必须大于 begin_date_time
    private String end_date_time;

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public List<Integer> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(List<Integer> weekdays) {
        this.weekdays = weekdays;
    }

    public String getBegin_date_time() {
        return begin_date_time;
    }

    public void setBegin_date_time(String begin_date_time) {
        this.begin_date_time = begin_date_time;
    }

    public String getEnd_date_time() {
        return end_date_time;
    }

    public void setEnd_date_time(String end_date_time) {
        this.end_date_time = end_date_time;
    }

    @Override
    public String toString() {
        return "DisplayAttribute{" +
                "times=" + times +
                ", weekdays=" + weekdays +
                ", begin_date_time='" + begin_date_time + '\'' +
                ", end_date_time='" + end_date_time + '\'' +
                '}';
    }
}
