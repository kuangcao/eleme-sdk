package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.FoodCategoryDetail;
import com.jiabangou.eleme.sdk.model.Restaurant;
import com.jiabangou.eleme.sdk.model.RestaurantSave;
import com.jiabangou.eleme.sdk.model.RestaurantStatus;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 餐馆单元测试
 * <p>
 * Created by freeway on 16/7/14.
 */
public class RestaurantServiceTest extends ServiceTest {

    @Test
    public void testGetMenu() throws ElemeErrorException {
        List<FoodCategoryDetail> foodCategoryDetails = elemeClient.getRestaurantService().getMenu(62028381L);
        System.out.println(foodCategoryDetails);
        foodCategoryDetails = elemeClient.getRestaurantService().getMenu(21388463L);
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
        elemeClient.getRestaurantService().binding(62028381L, "xQWEtysdjxxx");

    }

    @Test
    public void testRebinding() throws ElemeErrorException {
        elemeClient.getRestaurantService().rebinding(62028381L, "xQWEtysdjx");
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
        elemeClient.getRestaurantService().setIsOpen(21388463L, true);
    }

    @Test
    public void testGetProductProfile() throws ElemeErrorException {
        System.out.println(elemeClient.getRestaurantService().getProductProfile(62028381L));
    }

    @Test
    public void testGetStatus() throws ElemeErrorException {
        List<Long> restaurantIds = new ArrayList<>();
        restaurantIds = elemeClient.getRestaurantService().getIds();
        System.out.println(restaurantIds.size());
        System.out.println(restaurantIds);
        List<RestaurantStatus> restaurantStatuses = elemeClient.getRestaurantService().getStatus(restaurantIds);
        System.out.println(restaurantStatuses.size());
        System.out.println(restaurantStatuses);
        restaurantIds.add(620228381L);
        elemeClient.getRestaurantService().getStatus(restaurantIds);
    }


    @Test
    public void testGets() throws ElemeErrorException {
        List<Long> restaurantIds = elemeClient.getRestaurantService().getIds();
        for (Long restaurantId : restaurantIds) {
            System.out.println(elemeClient.getRestaurantService().get(restaurantId));
        }
    }

    @Test
    public void test21388463() throws ElemeErrorException {
        Restaurant restaurant = elemeClient.getRestaurantService().get(21388463L);

        System.out.println(restaurant);
        System.out.println(elemeClient.getRestaurantService().getMenu(21388463L));

        RestaurantSave restaurantSave = new RestaurantSave();
        String imageHash = elemeClient.getImageService().uploadByUrl("http://fuss10.elemecdn.com/0/88/add59ad9ad94bd327c94fd2ce293fjpeg.jpeg");
        restaurantSave.setLogo_image_hash(imageHash);
        restaurantSave.setRestaurant_id(restaurant.getId());
        restaurantSave.setNo_agent_fee_total(59);
        elemeClient.getRestaurantService().update(restaurantSave);
    }


}
