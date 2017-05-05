package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.pcsdk.PCServiceTest;
import com.jiabangou.eleme.pcsdk.exception.ElemePCLoginServiceException;
import com.jiabangou.eleme.pcsdk.model.LoginResult;
import org.junit.Test;

/**
 * Created by freeway on 2016/12/4.
 */
public class LoginServiceTest extends PCServiceTest {

    @Test
    public void testLoginByUsername() throws ElemePCLoginServiceException {
        String username = "qjdcsd";
        String password = "qjdcsd123";
        LoginResult loginResult = elemeClient.getLoginService().loginByUsername(username, password, null);
        System.out.println(loginResult);
    }


}
