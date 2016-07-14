package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.FoodCategoryDetail;
import org.junit.Test;

import java.util.List;

/**
 * Created by freeway on 16/7/14.
 */
public class RestaurantServiceTest extends ServiceTest {

    @Test
    public void testGetMenu() throws ElemeErrorException {
        List<FoodCategoryDetail> foodCategoryDetails = elemeClient.getRestaurantService().getMenu(62028381L);
        System.out.println(foodCategoryDetails);
    }
}
