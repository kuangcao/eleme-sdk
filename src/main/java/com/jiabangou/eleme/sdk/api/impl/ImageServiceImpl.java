package com.jiabangou.eleme.sdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.ImageService;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import okhttp3.OkHttpClient;
import okhttp3.internal.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by freeway on 16/7/15.
 */
public class ImageServiceImpl extends BaseServiceImpl implements ImageService {

    private final static String IMAGE_IMAGE_HASH = "/image/${image_hash}/";
    private final static String IMAGE_UPLOAD_BY_URL = "/image/upload_by_url/";

    public ImageServiceImpl(OkHttpClient client, ElemeConfigStorage configStorage) {
        super(client, configStorage);
    }

    @Override
    public String getImageUrl(String imageHash) throws ElemeErrorException {
        return execute(BaseServiceImpl.HTTP_METHOD_GET, IMAGE_IMAGE_HASH,
                new HashMap<String, String>() {{
                    put("image_hash", String.valueOf(imageHash));
                }}).getString("image_url");
    }

    @Override
    public String uploadByUrl(String imageUrl) throws ElemeErrorException {

        return execute(BaseServiceImpl.HTTP_METHOD_POST, IMAGE_UPLOAD_BY_URL,
                new HashMap<String, String>() {{
                    put("image_url", String.valueOf(imageUrl));
                }}).getString("image_hash");

    }

}
