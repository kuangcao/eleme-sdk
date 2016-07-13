package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.api.impl.ElemeClientImpl;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Food;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by freeway on 16/7/13.
 */
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
        Food food = elemeClient.getFoodService().getById(123L);
        System.out.println(food);
    }
}
