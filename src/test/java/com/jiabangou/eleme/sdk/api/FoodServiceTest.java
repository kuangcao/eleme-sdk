package com.jiabangou.eleme.sdk.api;

import com.alibaba.fastjson.JSON;
import com.jiabangou.eleme.sdk.api.impl.ElemeClientImpl;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Food;
import com.jiabangou.eleme.sdk.model.FoodSave;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FoodServiceTest {


    private static ElemeClient elemeClient;

    @BeforeClass
    public static void BeforeClass() {
        elemeClient = new ElemeClientImpl(new ElemeConfigStorage() {
            @Override
            public String getConsumerKey() {
                return "0170804777";
            }

            @Override
            public String getConsumerSecret() {
                return "87217cb263701f90316236c4df00d9352fb1da76";
            }
        });
    }

    @Test
    public void testGetById() throws ElemeErrorException {
        Food food = elemeClient.getFoodService().getById(111856403L);
        System.out.println(food);
    }

    @Test
    public void testGetsByIds() throws ElemeErrorException {
        List<Food> foods = elemeClient.getFoodService().getsByIds(Arrays.asList(new Long[]{111891571L, 111856403L}));
        System.out.println(foods);
    }

    @Test
    public void testAdd() throws ElemeErrorException {
        Food food = elemeClient.getFoodService().getById(111856403L);
        FoodSave foodSave = new FoodSave();
        foodSave.setDescription(food.getDescription());
        foodSave.setName(food.getFood_name());
        elemeClient.getFoodService().add(foodSave);
        System.out.println(JSON.toJSON(new FoodSave()));
    }

    @Test
    public void testUpdate() throws ElemeErrorException {
        Food food = elemeClient.getFoodService().getById(111856403L);
        FoodSave foodSave = new FoodSave();
        foodSave.setDescription(food.getDescription());
        foodSave.setName(food.getFood_name());
        foodSave.setFood_id(food.getFood_id());
        foodSave.setPrice(food.getPrice());
        foodSave.setMax_stock(10000);
        foodSave.setStock(food.getStock());
        elemeClient.getFoodService().update(foodSave);
        System.out.println(food);
    }

    @Test
    public void testRemove() throws ElemeErrorException {
        elemeClient.getFoodService().remove(113887406L);
    }


}
