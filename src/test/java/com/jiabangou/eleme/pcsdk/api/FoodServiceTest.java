package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.pcsdk.PCServiceTest;
import com.jiabangou.eleme.pcsdk.exception.ElemePCLoginServiceException;
import com.jiabangou.eleme.pcsdk.model.MediaTypeConst;
import org.junit.Test;

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
                .uploadFoodImage("http://fuss10.elemecdn.com/d/87/58e0e365255edca10328a67eb621fjpeg.jpeg",
                MediaTypeConst.MEDIA_TYPE_JPEG));
    }

    @Test
    public void testClearStock() {
        elemeClient.getFoodService().clearStock(27831883325L);
    }

    @Test
    public void testFillStock() {
        elemeClient.getFoodService().fillStock(27831883325L);
    }
}
