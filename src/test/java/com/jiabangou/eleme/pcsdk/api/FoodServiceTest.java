package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.pcsdk.PCServiceTest;
import com.jiabangou.eleme.pcsdk.exception.ElemePCLoginServiceException;
import com.jiabangou.eleme.pcsdk.model.LoginResult;
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

}
