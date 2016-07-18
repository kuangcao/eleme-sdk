package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.FoodCategoryDetail;
import com.jiabangou.eleme.sdk.model.Restaurant;
import org.junit.Test;

import java.util.List;

/**
 * 餐馆单元测试
 *
 * Created by freeway on 16/7/14.
 */
public class RestaurantServiceTest extends ServiceTest {

    @Test
    public void testGetMenu() throws ElemeErrorException {
        List<FoodCategoryDetail> foodCategoryDetails = elemeClient.getRestaurantService().getMenu(62028381L);
        System.out.println(foodCategoryDetails);
    }

    @Test
    public void testGet() throws ElemeErrorException {
        Restaurant restaurant = elemeClient.getRestaurantService().get(62028381L);
        System.out.println(restaurant);
    }
}
