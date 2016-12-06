package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.pcsdk.PCServiceTest;
import com.jiabangou.eleme.pcsdk.exception.ElemePCLoginServiceException;
import com.jiabangou.eleme.pcsdk.model.Category;
import com.jiabangou.eleme.pcsdk.model.Food;
import com.jiabangou.eleme.pcsdk.model.MediaTypeConst;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * Created by freeway on 2016/12/5.
 */
public class FoodServiceTest extends PCServiceTest {

    @Test
    public void testGetCategories() throws ElemePCLoginServiceException {
        System.out.println(elemeClient.getFoodService().getCategories(1809202L));
    }

    @Test
    public void testAddRemoveCategory() {
        Category category = elemeClient.getFoodService().createCategory(1809202L, "test1", "test1");
        elemeClient.getFoodService().updateCategory(category.setName("好玩"));
        elemeClient.getFoodService().removeCategory(category.getId());
    }

    @Test
    public void testGetFoodsByCategoryId() {
        System.out.println(elemeClient.getFoodService().getFoodsByCategoryId(27831891385L));
    }

    @Test
    public void testGetFood() {
        System.out.println(elemeClient.getFoodService().getFood(27831883325L));
    }

    @Test
    public void testUploadFoodImage() {
        System.out.println(elemeClient.getFoodService()
                .uploadFoodImage("https://gss0.bdstatic.com/7051cy89RcgCncy6lo7D0j9wexYrbOWh7c50/relibo-heqin/pjl-350X250.jpg",
                MediaTypeConst.MEDIA_TYPE_JPEG));
    }

    @Test
    public void testClearStock() {
        elemeClient.getFoodService().clearStock(27831883325L);

        elemeClient.getFoodService().clearStock(new ArrayList<Long>() {{
            add(27831883325L);
            add(27962995653L);
        }});

    }

    @Test
    public void testFillStock() {
        elemeClient.getFoodService().fillStock(27831883325L);
        elemeClient.getFoodService().fillStock(new ArrayList<Long>() {{
            add(27831883325L);
            add(27962995653L);
        }});
    }

    @Test
    public void testSetFoodPostion() {
        elemeClient.getFoodService().setFoodPosition(27892158086L, 1);
    }

    @Test
    public void testOnShelf() {
        elemeClient.getFoodService().onShelf(2789215808L);
    }

    @Test
    public void testOffShelf() {
        elemeClient.getFoodService().offShelf(27892158086L);
    }

    @Test
    public void testCreateFood() {
        Food food = new Food();
        food.setCategoryId(27844023479L)
        .setDescription("heheh")
        .setImageUrl("http://fuss10.elemecdn.com/d/87/58e0e365255edca10328a67eb621fjpeg.jpeg")
        .setLabels(Collections.emptyList())
        .setMaxStock(1000).setName("哈哈").setPackingFee(0).setPrice(23)
        .setStock(1000).setType("main");
        Food food1 = elemeClient.getFoodService().createFood(food);
        System.out.println(food1);
        elemeClient.getFoodService().updateFood(food1.setName("呵呵"));
        elemeClient.getFoodService().removeFood(food1.getId());
    }

}
