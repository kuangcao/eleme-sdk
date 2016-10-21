package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Food;
import com.jiabangou.eleme.sdk.model.FoodSave;
import com.jiabangou.eleme.sdk.model.Stock;
import com.jiabangou.eleme.sdk.model.TpFood;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class FoodServiceTest extends ServiceTest {


    @Test
    public void testGetById() throws ElemeErrorException {
        Food food = elemeClient.getFoodService().getById(131168182L);
        System.out.println(food);
    }

    @Test
    public void testGetsByIds() throws ElemeErrorException {
        List<Food> foods = elemeClient.getFoodService().getsByIds(Arrays.asList(new Long[]{111891571L, 111856403L}));
        System.out.println(foods);
    }

    @Test
    public void testAdd() throws ElemeErrorException {
        FoodSave foodSave = new FoodSave();
//        foodSave.setFood_category_id(11510476L);
        foodSave.setFood_category_id(10217122L);
        foodSave.setDescription("西红柿炒肉");
        foodSave.setName("西红柿炒肉");
        foodSave.setPrice(12.00f);
        foodSave.setMax_stock(1000);
        foodSave.setStock(100);
        foodSave.setSort_order(1);
        foodSave.setPacking_fee(0.00f);
        String image_hash = elemeClient.getImageService().uploadByUrl("http://i2.xygcdn.com/login/xyglogo.jpg");
        System.out.println(image_hash);
        foodSave.setImage_hash(image_hash);
        Long foodId = elemeClient.getFoodService().add(foodSave);
        System.out.println(foodId);
        elemeClient.getFoodService().remove(foodId);
    }

    @Test
    public void testUpdate() throws ElemeErrorException {
        Food food = elemeClient.getFoodService().getById(127999351L);
        System.out.println(food);
        FoodSave foodSave = new FoodSave();
        foodSave.setFood_id(food.getFood_id());
//        String descOld = "@#!!@#$%^&*()_^…… SGFDSF＠＃￥＠＃￥＃％￥……％＆……×＆（×（））（";
//        String desc = descOld.replace("。", ".").replace("——", "-").
//                replace("、", " ").replace("【", " ").replace("】", " ").replace("《", " ").
//                replace("》", " ").replace("‘", " ").replace("’", " ").replace("“", " ").
//                replace("”", " ").replace("×", "*").replace("……", "^").replace("·", " ").replace("^", " ");
//        //
//        String descNew = ToDBC(desc);
        //@#!!@#$% &*()_   SGFDSF@#￥@#￥#%￥ %& *&(*())(
//        foodSave.setDescription("~!@#$%^&():?><,./';:'");
//        foodSave.setName(food.getFood_name());
//        foodSave.setPrice(food.getPrice());
        foodSave.setName("你好我是滴减肥代理商空间反垄断");
        foodSave.setMax_stock(400);
        foodSave.setStock(14);
//        foodSave.setSort_order(1);
        elemeClient.getFoodService().update(foodSave);
    }

    public static String ToDBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\u3000') {
                c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);

            }
        }
        return new String(c);
    }

    @Test
    public void testRemove() throws ElemeErrorException {
//        FoodSave foodSave = new FoodSave();
//        foodSave.setFood_category_id(10963900L);
//        foodSave.setDescription("西红柿炒肉");
//        foodSave.setName("西红柿炒肉");
//        foodSave.setPrice(12.00f);
//        foodSave.setMax_stock(1000);
//        foodSave.setStock(100);
//        foodSave.setSort_order(1);
//        foodSave.setPacking_fee(0.00f);
//        String image_hash = elemeClient.getImageService().uploadByUrl("http://i2.xygcdn.com/login/xyglogo.jpg");
//        System.out.println(image_hash);
//        foodSave.setImage_hash(image_hash);
//        Long foodId = elemeClient.getFoodService().add(foodSave);
//        Food food = elemeClient.getFoodService().getById(foodId);
//        System.out.println(food);
        elemeClient.getFoodService().remove(142703090L);
    }

    @Test
    public void testRemoveAll() throws ElemeErrorException {
        List<Long> foodIds = new ArrayList<>();
        FoodSave foodSave = new FoodSave();
        foodSave.setTp_food_id(UUID.randomUUID().toString());
        foodSave.setFood_category_id(10963900L);
        foodSave.setDescription("西红柿炒肉");
        foodSave.setName("西红柿炒肉");
        foodSave.setPrice(12.00f);
        foodSave.setMax_stock(1000);
        foodSave.setStock(100);
        foodSave.setSort_order(1);
        foodSave.setPacking_fee(0.00f);
        String image_hash = elemeClient.getImageService().uploadByUrl("http://i2.xygcdn.com/login/xyglogo.jpg");
        System.out.println(image_hash);
        foodSave.setImage_hash(image_hash);
        foodIds.add(elemeClient.getFoodService().add(foodSave));
        foodSave = new FoodSave();
        foodSave.setTp_food_id(UUID.randomUUID().toString());
        foodSave.setFood_category_id(10963900L);
        foodSave.setDescription("西红柿炒肉腊肉");
        foodSave.setName("西红柿炒腊肉");
        foodSave.setPrice(12.00f);
        foodSave.setMax_stock(1000);
        foodSave.setStock(100);
        foodSave.setSort_order(1);
        foodSave.setPacking_fee(0.00f);
        foodSave.setImage_hash(image_hash);
        foodIds.add(elemeClient.getFoodService().add(foodSave));
        elemeClient.getFoodService().removeAll(foodIds);
    }


    @Test
    public void testGetsByTpFoodId() throws ElemeErrorException {
        List<Long> foodIds = new ArrayList<>();
        List<String> tpFoodIds = new ArrayList<>();
        String tpFoodId = null;
        FoodSave foodSave = new FoodSave();
        tpFoodId = UUID.randomUUID().toString();
        tpFoodIds.add(tpFoodId);
        foodSave.setTp_food_id(tpFoodId);

        foodSave.setFood_category_id(10963900L);
        foodSave.setDescription("西红柿炒肉");
        foodSave.setName("西红柿炒肉");
        foodSave.setPrice(12.00f);
        foodSave.setMax_stock(1000);
        foodSave.setStock(100);
        foodSave.setSort_order(1);
        foodSave.setPacking_fee(0.00f);
        String image_hash = "80dc33c9f6f9050022892f3b6d5ae9b5cdf24707";
        foodSave.setImage_hash(image_hash);
        foodIds.add(elemeClient.getFoodService().add(foodSave));
        foodSave = new FoodSave();
        tpFoodId = UUID.randomUUID().toString();
        tpFoodIds.add(tpFoodId);
        foodSave.setTp_food_id(tpFoodId);
        foodSave.setFood_category_id(10963900L);
        foodSave.setDescription("西红柿炒肉腊肉");
        foodSave.setName("西红柿炒腊肉");
        foodSave.setPrice(12.00f);
        foodSave.setMax_stock(1000);
        foodSave.setStock(100);
        foodSave.setSort_order(1);
        foodSave.setPacking_fee(0.00f);
        foodSave.setImage_hash(image_hash);
        foodIds.add(elemeClient.getFoodService().add(foodSave));
        List<TpFood> tpFoods = elemeClient.getFoodService().getsByTpFoodIds(tpFoodIds);
        System.out.println(tpFoods);

        List<Stock> stocks = new ArrayList<>();
        tpFoods.forEach(tpFood -> {
            Stock stock = new Stock();
            stock.setStock(100);
            stock.setTp_food_id(tpFood.getTp_food_id());
            stock.setTp_restaurant_id(tpFood.getTp_restaurant_id());
            stocks.add(stock);
        });
        elemeClient.getFoodService().updateStocks(stocks);
        elemeClient.getFoodService().removeAll(foodIds);
    }

    //12673189, 12671470
    @Test
    public void testGetsByFoodCategoryId() throws ElemeErrorException {
        List<Food> foods = elemeClient.getFoodService().getsByFoodCategoryId(14051990L);
        System.out.println(foods);
    }

    @Test
    public void testUpdateAll() throws ElemeErrorException {
        List<FoodSave> foodSaves = new ArrayList<>();
        FoodSave foodSave = new FoodSave();
        foodSave.setFood_id(114871106L);
        foodSave.setName("西葫芦炒肉");
        foodSave.setSort_order(2000);
        foodSaves.add(foodSave);
        foodSave = new FoodSave();
        foodSave.setFood_id(114863204L);
        foodSave.setName("西红石");
        foodSave.setSort_order(0);
        foodSave.setFood_category_id(11510476L);
        foodSaves.add(foodSave);
        elemeClient.getFoodService().updateAll(foodSaves);
    }

    @Test
    public void test() {
        String hello = "http://v2.openapi.ele.me/food_category/10963900/foods/?consumer_key=0170804777&timestamp=146851328687217cb263701f90316236c4df00d9352fb1da76";
        try {
            String hexString = Hex.encodeHexString(hello.getBytes("utf-8"));
            String hexString2 = Hex.encodeHexString(hello.getBytes("ascii"));
            String hexString3 = Hex.encodeHexString(hello.getBytes("gbk"));
            String hexString4 = new String(Hex.encodeHex(hello.getBytes("utf-8"), false));
            System.out.println(hexString);
            System.out.println(hexString2);
            System.out.println(hexString3);
            System.out.println(hexString4);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
