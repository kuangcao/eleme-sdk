package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.DisplayAttribute;
import com.jiabangou.eleme.sdk.model.NewFoodCategory;
import com.jiabangou.eleme.sdk.model.Time;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by freeway on 16/7/14.
 */
public class NewFoodCategoryServiceTest extends ServiceTest {

    private final static NewFoodCategoryService newFoodCategoryService = elemeClient.getNewFoodCategoryService();

    @Test
    public void add() throws ElemeErrorException {
        NewFoodCategory newFoodCategory = new NewFoodCategory();
        newFoodCategory.setRestaurant_id(1199500);
        newFoodCategory.setName("测试新分类接口");
        newFoodCategory.setDescription("这是分类描述");
        //设置displayAttributes
        Time time = new Time();
        time.setStart_time("12:00:00");
        time.setEnd_time("23:59:59");
        List<Time> times = new ArrayList<>();
        times.add(time);

        List<Integer> weekdays = new ArrayList<>();
        weekdays.add(1);
        weekdays.add(2);

        DisplayAttribute displayAttribute = new DisplayAttribute();
        displayAttribute.setTimes(times);
        displayAttribute.setWeekdays(weekdays);
        List<DisplayAttribute> displayAttributes = new ArrayList<>();
        displayAttributes.add(displayAttribute);

        newFoodCategory.setDisplay_attribute(displayAttributes);
        newFoodCategoryService.add(newFoodCategory);
    }

    @Test
    public void getById() throws ElemeErrorException {
        newFoodCategoryService.getById(0L);
    }

}
