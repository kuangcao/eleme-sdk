package com.jiabangou.eleme.pcsdk;

import com.jiabangou.eleme.pcsdk.api.impl.ElemePCSDKClientImpl;
import org.junit.BeforeClass;

/**
 *
 * Created by freeway on 2016/12/4.
 */
public class PCServiceTest {

    protected static ElemePCSDKClient elemeClient;

    @BeforeClass
    public static void BeforeClass() {
        elemeClient = new ElemePCSDKClientImpl(new ElemePCConfigStorage() {
            private String ksid = "Zjk3ZGI3ZTctY2QwNS00ZjMyLThkYTNDE0Zm";
            private String shopId = "1809202";
            private String username = "qjdcsd";
            private String password = "qjdcsd123";
            @Override
            public String getUserName() {
                return username;
            }

            @Override
            public String getPassword() {
                return password;
            }

            @Override
            public String getKsid() {
                return ksid;
            }

            @Override
            public String getShopId() {
                return shopId;
            }

            @Override
            public void save(String username, String password, String ksid, String shopId) {
                this.username = username;
                this.password = password;
                this.ksid = ksid;
                this.shopId = shopId;
            }

        });
    }

}
