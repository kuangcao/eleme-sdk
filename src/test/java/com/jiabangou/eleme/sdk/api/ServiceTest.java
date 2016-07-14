package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.api.impl.ElemeClientImpl;
import org.junit.BeforeClass;

/**
 * Created by freeway on 16/7/14.
 */
public class ServiceTest {

    protected static ElemeClient elemeClient;

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

}
