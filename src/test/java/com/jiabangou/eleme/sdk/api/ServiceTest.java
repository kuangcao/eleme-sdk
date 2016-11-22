package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.api.impl.ElemeClientImpl;
import org.apache.commons.lang.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;

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
                return "1111111";
            }

            @Override
            public String getConsumerSecret() {
                return "aaaaaaa";
            }

        });
    }

    @Test
    public void testForUrl() {
        String url = "http://www.socm.com/sdfs?sds=s&sdfs=sdfs&sdf=sdf";
        String noQueryUrl = url.substring(0, url.indexOf("?"));
        System.out.println(noQueryUrl);

        String queryString = url.substring(url.indexOf("?")+1, url.length());
        System.out.println(queryString);
        StringUtils.split(queryString, "&");
    }
}
