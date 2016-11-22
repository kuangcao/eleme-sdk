package com.jiabangou.eleme.sdk.api.impl;

import com.jiabangou.eleme.sdk.api.ServiceTest;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import org.junit.Test;

import java.util.List;

/**
 * Created by freeway on 16/7/21.
 */
public class CommentServiceTest extends ServiceTest {

    @Test
    public void testGetsByRestaurantId() throws ElemeErrorException {

        List<Long> restaurantIds = elemeClient.getRestaurantService().getIds();
        for (Long restaurantId : restaurantIds) {
            System.out.println("restaurantId:"+ restaurantId + " " + elemeClient.getCommentService().getsByRestaurantId(restaurantId, 0, 20));
            System.out.println("restaurantId:"+ restaurantId + " " + elemeClient.getCommentService().countByRestaurantId(restaurantId));
        }
    }
}
