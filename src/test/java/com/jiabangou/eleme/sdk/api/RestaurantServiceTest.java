package com.jiabangou.eleme.sdk.api;

import com.alibaba.fastjson.JSONObject;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.*;
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
    public void testGet() throws ElemeErrorException {
        Restaurant restaurant = elemeClient.getRestaurantService().get(1403447L);
        System.out.println(restaurant);
    }

    @Test
    public void testGetMenu() throws ElemeErrorException {
        List<FoodCategoryDetail> foodCategoryDetails = elemeClient.getRestaurantService().getMenu(1298521L);
        System.out.println(foodCategoryDetails);
        foodCategoryDetails = elemeClient.getRestaurantService().getMenu(1199500L);
        System.out.println(foodCategoryDetails);
    }

    @Test
    public void testGetUpdate() throws ElemeErrorException {
        Restaurant restaurant = elemeClient.getRestaurantService().get(1199500L);
        System.out.println(restaurant);
        RestaurantSave restaurantSave = new RestaurantSave();
        restaurantSave.setOpen_time("00:00-23:59");
        restaurantSave.setRestaurant_id(1199500L);
        restaurantSave.setAgent_fee(1);
        restaurantSave.setPacking_fee(20f);
        restaurantSave.setGeo(restaurant.getLongitude() + "," + restaurant.getLatitude());
        restaurantSave.setDescription("永不开张的店");
        restaurantSave.setName("永不开张的店");
        restaurantSave.setPhone("18657237231");
        restaurantSave.setDeliver_description("怎么开");
        elemeClient.getRestaurantService().update(restaurantSave);
    }

    @Test
    public void testUpdateOrderMode() throws ElemeErrorException {
        Restaurant restaurant = elemeClient.getRestaurantService().get(1298521L);
        System.out.println(restaurant);
        elemeClient.getRestaurantService().updateOrderMode(1199500L, Short.parseShort("1"));
    }

    @Test
    public void testBinding() throws ElemeErrorException {
        elemeClient.getRestaurantService().binding(1199500L, "19");

    }

    @Test
    public void testRebinding() throws ElemeErrorException {
        elemeClient.getRestaurantService().rebinding(1199500L, "18");
    }

    @Test
    public void testGetIdByTpRestaurantId() throws ElemeErrorException {
        System.out.println(elemeClient.getRestaurantService().getIdByTpRestaurantId("1202"));
//        System.out.println(elemeClient.getRestaurantService().getIdByTpRestaurantId("xQWEtysdsj"));
    }

    @Test
    public void testGetIds() throws ElemeErrorException {
        System.out.println(elemeClient.getRestaurantService().getIds());
    }

    @Test
    public void testIsOpen() throws ElemeErrorException {
        elemeClient.getRestaurantService().setIsOpen(1199500L, true);
        elemeClient.getRestaurantService().setIsOpen(1298521L, true);
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
        Restaurant restaurant = elemeClient.getRestaurantService().get(1298521L);

        System.out.println(restaurant);
        System.out.println(elemeClient.getRestaurantService().getMenu(21388463L));

        RestaurantSave restaurantSave = new RestaurantSave();
        String imageHash = elemeClient.getImageService().uploadByUrl("http://fuss10.elemecdn.com/0/88/add59ad9ad94bd327c94fd2ce293fjpeg.jpeg");
        restaurantSave.setLogo_image_hash(imageHash);
        restaurantSave.setRestaurant_id(restaurant.getId());
        restaurantSave.setNo_agent_fee_total(59);
        elemeClient.getRestaurantService().update(restaurantSave);
    }

    @Test
    public void testGeo() throws ElemeErrorException {
        List<RestaurantGeo> restaurantGeos = new ArrayList<>();
        String geo_json = "{\"geometry\": {\"type\": \"Polygon\", \"coordinates\": [[[121.381303, 31.243521], [121.380938, 31.242778], [121.380735, 31.242421], [121.380627, 31.242196], [121.380541, 31.24204], [121.38037, 31.241664], [121.380284, 31.241499], [121.38023, 31.241389], [121.380166, 31.241269], [121.380134, 31.241178], [121.379951, 31.24093], [121.379748, 31.24071], [121.379565, 31.240499], [121.379426, 31.24037], [121.379297, 31.240205], [121.379104, 31.239967], [121.378911, 31.239747], [121.378696, 31.239471], [121.377881, 31.238554], [121.377291, 31.237848], [121.376561, 31.237077], [121.37566, 31.236013], [121.375123, 31.235435], [121.374684, 31.234967], [121.374265, 31.234499], [121.374126, 31.23427], [121.374072, 31.234105], [121.374029, 31.233912], [121.3739, 31.233334], [121.373782, 31.232738], [121.373675, 31.232334], [121.3736, 31.231967], [121.373342, 31.230821], [121.374319, 31.23038], [121.375542, 31.22983], [121.377065, 31.229133], [121.377913, 31.228775], [121.378857, 31.228545], [121.37964, 31.228399], [121.381539, 31.228096], [121.382891, 31.227903], [121.38361, 31.229628], [121.384661, 31.231977], [121.385713, 31.23449], [121.386753, 31.236527], [121.386764, 31.236554], [121.387183, 31.237426], [121.387504, 31.238095], [121.388213, 31.239499], [121.388695, 31.24049], [121.387912, 31.240701], [121.386839, 31.240985], [121.385766, 31.241315], [121.385251, 31.241389], [121.383728, 31.24226], [121.381582, 31.243361], [121.381679, 31.243297], [121.381303, 31.243521]]]}, \"type\": \"Feature\", \"properties\": {\"delivery_price\": 20, \"area_agent_fee\": 3}}";
        RestaurantGeo restaurantGeo1 = JSONObject.parseObject(geo_json, RestaurantGeo.class);
        restaurantGeos.add(restaurantGeo1);
        elemeClient.getRestaurantService().restaurantGeo(1298521L, restaurantGeos);
    }


}
