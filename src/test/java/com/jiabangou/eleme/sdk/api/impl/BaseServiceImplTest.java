package com.jiabangou.eleme.sdk.api.impl;

import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.LogListener;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by freeway on 16/7/12.
 */
public class BaseServiceImplTest {

    @Test
    public void testCreateRealUriAndParams() {
        BaseServiceImpl baseService = new BaseServiceImpl(null, new ElemeConfigStorage() {
            @Override
            public String getConsumerKey() {
//                return "0170804777";
                return "3459598486"; // 全聚德
            }

            @Override
            public String getConsumerSecret() {
//                return "87217cb263701f90316236c4df00d9352fb1da76";
                return "5b14c2424f82e55172e3f331da577a89719ae955"; // 全聚德
            }
        },
                (String cmd, boolean isSuccess, String request, String response) -> {
            });
        Map<String, String> params = new HashMap<String, String>();
        params.put("food_id", "123");
        BaseServiceImpl.RealUriAndParams rp = baseService.createRealUriAndParams(BaseServiceImpl.HTTP_METHOD_GET, "/food/${food_id}/", params);
        System.out.println(rp.toString());

        rp = baseService.createRealUriAndParams(BaseServiceImpl.HTTP_METHOD_DELETE, "/food/${food_id}/", params);
        System.out.println(rp.toString());

        rp = baseService.createRealUriAndParams(BaseServiceImpl.HTTP_METHOD_POST, "/food/${food_id}/", params);
        System.out.println(rp.toString());

        rp = baseService.createRealUriAndParams(BaseServiceImpl.HTTP_METHOD_PUT, "/food/${food_id}/", params);
        System.out.println(rp.toString());
        float abc = 12.21223f;
        System.out.println(String.valueOf(abc));
    }
}
