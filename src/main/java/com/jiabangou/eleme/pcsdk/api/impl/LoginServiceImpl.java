package com.jiabangou.eleme.pcsdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiabangou.eleme.pcsdk.ElemePCConfigStorage;
import com.jiabangou.eleme.pcsdk.PCLogListener;
import com.jiabangou.eleme.pcsdk.api.LoginService;
import com.jiabangou.eleme.pcsdk.exception.ElemePCLoginServiceException;
import com.jiabangou.eleme.pcsdk.model.LoginResult;
import okhttp3.OkHttpClient;

/**
 * 登录服务
 * Created by freeway on 2016/12/4.
 */
public class LoginServiceImpl extends PCBaseServiceImpl implements LoginService {

    public LoginServiceImpl(OkHttpClient client, ElemePCConfigStorage configStorage, PCLogListener logListener) {
        super(client, configStorage, logListener);
    }

    @Override
    public LoginResult loginByUsername(String username, String password, String captchaCode) throws ElemePCLoginServiceException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        jsonObject.put("captchaCode", captchaCode);
        JSONObject result = (JSONObject)execute(API.LOGIN_SERVICE_LOGIN_BY_USERNAME, jsonObject, false);
        boolean isSuccess = result.getBoolean("succeed");
        if (!isSuccess) {
            JSONObject failureData = result.getJSONObject("failureData");
            ElemePCLoginServiceException excp = new ElemePCLoginServiceException(failureData.getString("errorMessage"));
            excp.setCaptchaImageB64(failureData.getString("captchaImageB64"));
            excp.setShowCaptcha(failureData.getBoolean("showCaptcha"));
            excp.setWeakPassword(failureData.getBoolean("weakPassword"));
            throw excp;
        }
        return result.getObject("successData", LoginResult.class);
    }
}
