package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import okhttp3.*;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by freeway on 16/7/11.
 */
public class BaseServiceImpl {

    public static final String BASE_URL = "http://v2.openapi.ele.me";

    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_PUT = "PUT";
    public static final String HTTP_METHOD_POST = "POST";
    public static final String HTTP_METHOD_DELETE = "DELETE";

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

    protected ElemeConfigStorage configStorage;
    protected OkHttpClient client;

    public BaseServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage) {
        this.configStorage = configStorage;
        this.client = client;
    }

    protected static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String toHex(String arg) {
        try {
            return Hex.encodeHexString(arg.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    protected RealUriAndParams createRealUriAndParams(String httpMethod, String url, Map<String, String> params) {
        String realUri = url;
        StringBuilder forSignatureStr = new StringBuilder(BASE_URL);
        Map<String, String> realParams = new HashMap<>(params.size()+2);
        realParams.put("consumer_key", configStorage.getConsumerKey());
        realParams.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        boolean isGetOrDelete = HTTP_METHOD_GET.equals(httpMethod) || HTTP_METHOD_DELETE.equals(httpMethod);
        for (Map.Entry<String, String> entry :params.entrySet()) {
            if (url.contains("${"+entry.getKey()+"}")) {
                if (entry.getValue() != null) {
                    realUri = realUri.replace("${"+entry.getKey()+"}", urlEncode(entry.getValue()));
                }
            } else {
                realParams.put(entry.getKey(), entry.getValue());
            }
        }
        forSignatureStr.append(realUri);
        List<String> sortParams = realParams.entrySet().stream()
                .map(entry->entry.getKey() + "=" + urlEncode(entry.getValue())).sorted().collect(Collectors.toList());
        if (!isGetOrDelete) {
            realUri = forSignatureStr.toString();
        }

        forSignatureStr.append("?").append(StringUtils.join(sortParams, "&"));

        if (isGetOrDelete) {
            realUri = forSignatureStr.toString();
        }
        String signature = DigestUtils.sha1Hex(toHex(forSignatureStr.toString() + configStorage.getConsumerSecret()));

        if (isGetOrDelete) {
            return new RealUriAndParams(realUri + "&sig=" + signature);
        } else {
            realParams.put("sig", signature);
            return new RealUriAndParams(realUri, realParams);
        }
    }

    protected JSONObject execute(String httpMethod, String url, Map<String, String> params) throws ElemeErrorException {

        OkHttpClient client = new OkHttpClient();
        RealUriAndParams rp = createRealUriAndParams(httpMethod, url, params);
        Request.Builder builder = new Request.Builder();
        builder.url(rp.getRealUri());

        if (HTTP_METHOD_DELETE.equals(httpMethod)) {
            builder.delete();
        } else if (HTTP_METHOD_POST.equals(httpMethod)) {
            RequestBody requestBody = createFormBody(rp.getParams());
            System.out.println(requestBody.toString());
            builder.post(requestBody);
        } else if (HTTP_METHOD_PUT.equals(httpMethod)) {
            RequestBody requestBody = createFormBody(rp.getParams());
            System.out.println(requestBody.toString());
            builder.put(requestBody);
        }
        Response response = null;
        try {
            response = client.newCall(builder.build()).execute();
            String jsonStr = response.body().string();

            JSONObject jsonObject = JSONObject.parseObject(jsonStr);
            int code = jsonObject.getIntValue("code");
            if (code != 200) {
                throw new ElemeErrorException(code, jsonObject.getString("message"), rp.getRealUri(), rp.getParams(), jsonStr);
            }
            return jsonObject.getJSONObject("data");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private RequestBody createFormBody(Map<String, String> params) {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            formBodyBuilder.add(entry.getKey(), entry.getValue());
        }
        return formBodyBuilder.build();
    }

    static class RealUriAndParams {
        private String realUri;
        private Map<String, String> params;

        public RealUriAndParams(String realUri) {
            this.realUri = realUri;
        }

        public RealUriAndParams(String realUri, Map<String, String> params) {
            this.realUri = realUri;
            this.params = params;
        }

        public String getRealUri() {
            return realUri;
        }

        public Map<String, String> getParams() {
            return params;
        }

        @Override
        public String toString() {
            return "RealUriAndParams{" +
                    "realUri='" + realUri + '\'' +
                    ", params=" + params +
                    '}';
        }
    }
}
