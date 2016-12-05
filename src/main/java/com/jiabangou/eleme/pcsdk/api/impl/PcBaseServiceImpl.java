package com.jiabangou.eleme.pcsdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiabangou.eleme.pcsdk.ElemePCConfigStorage;
import com.jiabangou.eleme.pcsdk.PCLogListener;
import com.jiabangou.eleme.pcsdk.exception.ElemePCErrorException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PcBaseServiceImpl {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final Logger LOGGER = LoggerFactory.getLogger(PcBaseServiceImpl.class);

    protected ElemePCConfigStorage configStorage;
    protected PCLogListener logListener;
    protected OkHttpClient client;

    public PcBaseServiceImpl(OkHttpClient client, ElemePCConfigStorage configStorage, PCLogListener logListener) {
        this.configStorage = configStorage;
        this.client = client;
        this.logListener = logListener;
    }

    private void logging(String cmd, String method, boolean isSuccess, String request, String response) {
        if (logListener != null) {
            logListener.requestEvent(cmd, method, isSuccess, request, response);
        }
    }

    protected JSONObject execute(API api, JSONObject params) throws ElemePCErrorException {
        return execute(api, params, true);
    }

    protected JSONObject execute(API api, JSONObject params, boolean isAuth) throws ElemePCErrorException {
        ReqPack reqPack= ReqPack.build(api, params);
        if (isAuth) {
            reqPack.getMetas().setKsid(configStorage.getKsid());
        }
        String jsonStr = JSONObject.toJSONString(reqPack);
        Request.Builder builder = new Request.Builder().url(api.getUrl())
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.98 Safari/537.36")
                .header("Origin", "http://melody.shop.ele.me")
                .post(RequestBody.create(JSON, jsonStr));

        String respStr = null;
        try {
            Response response = client.newCall(builder.build()).execute();
            respStr = response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RespPack respPack = JSONObject.parseObject(respStr, RespPack.class);
        if (respPack.getError() != null) {
            throw new ElemePCErrorException(respPack.getError());
        }
        if (respPack.getId().equals(reqPack.getId())) {
            return respPack.getResult();
        }
        throw new RuntimeException("id is not match");
    }

}
