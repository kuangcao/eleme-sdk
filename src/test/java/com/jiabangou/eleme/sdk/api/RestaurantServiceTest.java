package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.FoodCategoryDetail;
import com.jiabangou.eleme.sdk.model.Restaurant;
import com.jiabangou.eleme.sdk.model.RestaurantSave;
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
        foodCategoryDetails = elemeClient.getRestaurantService().getMenu(804622L);
        System.out.println(foodCategoryDetails);
    }

    @Test
    public void testGetUpdate() throws ElemeErrorException {
        Restaurant restaurant = elemeClient.getRestaurantService().get(62028381L);
        System.out.println(restaurant);
        RestaurantSave restaurantSave = new RestaurantSave();
        restaurantSave.setRestaurant_id(62028381L);
        restaurantSave.setPacking_fee(20f);
        restaurantSave.setGeo(restaurant.getLongitude() + "," + restaurant.getLatitude());
        restaurantSave.setDescription("永不开张的店");
        restaurantSave.setName("永不开张的店");
        restaurantSave.setPhone("18657237231");
        restaurantSave.setDeliver_description("怎么开");
        elemeClient.getRestaurantService().update(restaurantSave);
    }

    @Test
    public void testBinding() throws ElemeErrorException {
        elemeClient.getRestaurantService().binding(62028381L, "xQWEtysdj");

    }

    @Test
    public void testRebinding() throws ElemeErrorException {
        elemeClient.getRestaurantService().rebinding(62028381L, "xQWEtysdj");
    }

    @Test
    public void testGetIdByTpRestaurantId() throws ElemeErrorException {
        System.out.println(elemeClient.getRestaurantService().getIdByTpRestaurantId("xQWEtysdj"));
        System.out.println(elemeClient.getRestaurantService().getIdByTpRestaurantId("xQWEtysdsj"));
    }

    @Test
    public void testGetIds() throws ElemeErrorException {
        System.out.println(elemeClient.getRestaurantService().getIds());
    }

    @Test
    public void testIsOpen() throws ElemeErrorException {
        elemeClient.getRestaurantService().setIsOpen(62028381L, true);
    }

}
