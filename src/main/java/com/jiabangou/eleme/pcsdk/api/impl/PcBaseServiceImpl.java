package com.jiabangou.eleme.pcsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiabangou.eleme.pcsdk.ElemePCConfigStorage;
import com.jiabangou.eleme.pcsdk.PCLogListener;
import com.jiabangou.eleme.pcsdk.exception.ElemePCErrorException;
import com.jiabangou.eleme.pcsdk.model.MediaTypeConst;
import okhttp3.*;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

public class PCBaseServiceImpl {


    private static final Logger LOGGER = LoggerFactory.getLogger(PCBaseServiceImpl.class);

    protected ElemePCConfigStorage configStorage;
    protected PCLogListener logListener;
    protected OkHttpClient client;

    public PCBaseServiceImpl(OkHttpClient client, ElemePCConfigStorage configStorage, PCLogListener logListener) {
        this.configStorage = configStorage;
        this.client = client;
        this.logListener = logListener;
    }

    private void logging(String cmd, String method, boolean isSuccess, String request, String response) {
        if (logListener != null) {
            logListener.requestEvent(cmd, method, isSuccess, request, response);
        }
    }

    protected JSON uploadFile(String url, String type, MediaType mediaType) throws ElemePCErrorException {
        String uploadUrl = API.BASE_URL + "upload?appName=melody&appVersion=4.4.0&ksid=" + configStorage.getKsid();
        String id = UUID.randomUUID().toString();

        File file = null;
        try {
            URL urlObj = new URL(url);
            String tDir = System.getProperty("java.io.tmpdir");
            String path = tDir + UUID.randomUUID().toString();
            file = new File(path);
            file.deleteOnExit();
            FileUtils.copyURLToFile(urlObj, file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        RequestBody requestBody =  new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("ncp", "1.0.0")
                .addFormDataPart("id", id)
                .addFormDataPart("type", type)
                .addFormDataPart("file", "blob", RequestBody.create(mediaType, file))
                .build();

        Request request = new Request.Builder()
                .url(uploadUrl)
                .post(requestBody)
                .build();

        String respStr = null;
        try {
            Response response = client.newCall(request).execute();
            respStr = response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RespPack respPack = JSONObject.parseObject(respStr, RespPack.class);
        if (respPack.getError() != null) {
            throw new ElemePCErrorException(respPack.getError());
        }
        if (!respPack.getId().equals(id)) {
            throw new RuntimeException("id is not match");
        }
        return respPack.getResult();
    }

    protected JSON execute(API api, JSONObject params) throws ElemePCErrorException {
        return execute(api, params, true);
    }

    protected JSON execute(API api, JSONObject params, boolean isAuth) throws ElemePCErrorException {
        ReqPack reqPack= ReqPack.build(api, params);
        if (isAuth) {
            reqPack.getMetas().setKsid(configStorage.getKsid());
        }
        String jsonStr = JSONObject.toJSONString(reqPack);
        Request.Builder builder = new Request.Builder().url(api.getUrl())
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.98 Safari/537.36")
                .header("Origin", "http://melody.shop.ele.me")
                .post(RequestBody.create(MediaTypeConst.MEDIA_TYPE_JSON, jsonStr));

        String respStr = null;
        try {
            Response response = client.newCall(builder.build()).execute();
            respStr = response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RespPack respPack = JSONObject.parseObject(respStr, RespPack.class);
        if (respPack.getError() != null) {
            logging(api.getUrl(), api.getMethod()+"."+api.getService(), false, jsonStr, respStr);
            throw new ElemePCErrorException(respPack.getError());
        }
        if (!respPack.getId().equals(reqPack.getId())) {
            throw new RuntimeException("id is not match");
        }
        return respPack.getResult();
    }

}
