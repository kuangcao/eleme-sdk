package com.jiabangou.eleme.sdk.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Created by freeway on 16/7/19.
 */
public class ElemeUtils {

    public static String toHex(String arg) {
        try {
            return Hex.encodeHexString(arg.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sigCheck(String url, Map<String, String> params, String consumerKey, String consumerSecret) {
        SigPart sigPart = getSigPart(url, params);
        if (sigPart.getSig() == null) {
            throw new RuntimeException("sig is required");
        }
        Map<String, String> signParams = sigPart.getSignRelationParams();
        if (!signParams.containsKey("timestamp")) {
            throw new RuntimeException("timestamp is required");
        }
        if (!signParams.containsKey("consumer_key")) {
            throw new RuntimeException("consumer_key is required");
        }
        if (consumerKey.equals(signParams.get("consumer_key"))) {
            throw new RuntimeException("consumer_key is incorrect");
        }
        List<String> sortParams = signParams.entrySet().stream()
                .map(entry -> entry.getKey() + "=" +
                        ElemeUtils.urlEncode(entry.getValue())).sorted().collect(toList());

        String signature = DigestUtils.sha1Hex(ElemeUtils.toHex(sigPart.getUrl() + "?" +
                StringUtils.join(sortParams, "&")
                + consumerSecret));

        if (!signature.equals(sigPart.getSig())) {
            throw new RuntimeException("sig is incorrect");
        }
    }

    private static SigPart getSigPart(String url, Map<String, String> params) {
        if (!url.contains("?")) {
            Map<String, String> signParams = new HashMap<>();
            signParams.putAll(params);
            String sig = signParams.remove("sig");
            SigPart sigPart = new SigPart();
            sigPart.setSig(sig);
            sigPart.setSignRelationParams(signParams);
            sigPart.setUrl(url);
            return sigPart;
        }
        String noQueryUrl = url.substring(0, url.indexOf("?"));
        String queryString = url.substring(url.indexOf("?") + 1, url.length());
        Map<String, String> signParams = new HashMap<>();
        String sig = null;
        List<String> queryParts = Arrays.asList(StringUtils.split(queryString, "&"));
        for (String queryPart : queryParts) {
            String[] kv = queryPart.split("=");
            if ("sig".equals(kv[0])) {
                sig = kv[1];
            } else {
                signParams.put(kv[0], kv[1]);
            }
        }
        signParams.putAll(params);
        SigPart sigPart = new SigPart();
        sigPart.setSig(sig);
        sigPart.setSignRelationParams(signParams);
        sigPart.setUrl(noQueryUrl);
        return sigPart;
    }


    public static class SigPart implements Serializable {
        Map<String, String> signRelationParams;
        String sig;
        String url;

        public Map<String, String> getSignRelationParams() {
            return signRelationParams;
        }

        public void setSignRelationParams(Map<String, String> signRelationParams) {
            this.signRelationParams = signRelationParams;
        }

        public String getSig() {
            return sig;
        }

        public void setSig(String sig) {
            this.sig = sig;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "SigPart{" +
                    "signRelationParams=" + signRelationParams +
                    ", sig='" + sig + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

}
