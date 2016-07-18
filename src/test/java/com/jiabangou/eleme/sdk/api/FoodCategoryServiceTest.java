package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.FoodCategory;
import com.jiabangou.eleme.sdk.model.FoodCategorySave;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by freeway on 16/7/14.
 */
public class FoodCategoryServiceTest extends ServiceTest {

    @Test
    public void testAddUpdateRemove() throws ElemeErrorException {
        FoodCategoryService foodCategoryService = elemeClient.getFoodCategoryService();
        FoodCategorySave foodCategorySave = new FoodCategorySave();
        foodCategorySave.setName("今日大减价");
        foodCategorySave.setRestaurant_id(62028381L);
        foodCategorySave.setWeight(1);
        foodCategorySave.setFood_category_id(foodCategoryService.add(foodCategorySave));
        System.out.print(foodCategorySave);

        FoodCategory foodCategory = foodCategoryService.getById(foodCategorySave.getFood_category_id());
        Assert.assertEquals("今日大减价",foodCategory.getName());
        Assert.assertEquals(new Integer(1), foodCategory.getWeight());
        System.out.println(foodCategory);

        foodCategorySave.setName("今日不减价");
        foodCategoryService.update(foodCategorySave);
        foodCategory = foodCategoryService.getById(foodCategorySave.getFood_category_id());
        Assert.assertEquals("今日不减价",foodCategory.getName());
        System.out.println(foodCategory);
//        foodCategoryService.remove(foodCategorySave.getFood_category_id());
//        foodCategory = foodCategoryService.getById(foodCategorySave.getFood_category_id());
//        Assert.assertNull(foodCategory);
    }

    @Test
    public void test() throws ElemeErrorException {
        FoodCategoryService foodCategoryService = elemeClient.getFoodCategoryService();
        System.out.println(foodCategoryService.getsByRestaurantId(62028381L));
    }
}
