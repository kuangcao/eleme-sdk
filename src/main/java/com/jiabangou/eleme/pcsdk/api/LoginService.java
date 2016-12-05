package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.pcsdk.exception.ElemePCLoginServiceException;
import com.jiabangou.eleme.pcsdk.model.LoginResult;

/**
 * 登录服务
 * Created by freeway on 2016/12/4.
 */
public interface LoginService {

    LoginResult loginByUsername(String username, String password, String captchaCode) throws ElemePCLoginServiceException;

}
