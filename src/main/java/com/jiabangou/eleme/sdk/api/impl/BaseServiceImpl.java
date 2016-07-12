package com.jiabangou.eleme.sdk.api.impl;

import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
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

    public BaseServiceImpl(ElemeConfigStorage configStorage) {
        this.configStorage = configStorage;
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
        List<String> sortParams = realParams.keySet().stream()
                .map(key->key + "=" + urlEncode(realParams.get(key))).sorted().collect(Collectors.toList());
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
