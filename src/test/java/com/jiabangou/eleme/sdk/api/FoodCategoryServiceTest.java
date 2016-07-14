package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.FoodCategory;
import org.junit.Test;

/**
 * Created by freeway on 16/7/14.
 */
public class FoodCategoryServiceTest extends ServiceTest {

    @Test
    public void getById() throws ElemeErrorException {

        FoodCategory foodCategory = elemeClient.getFoodCategoryService().getById(10963900L);
        System.out.println(foodCategory);
    }
}
