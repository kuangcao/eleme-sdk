package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;

/**
 * 图片服务
 * Created by freeway on 16/7/15.
 */
public interface ImageService {

    /**
     * 获取图片 URL
     * 根据图片 image_hash ，返回可访问的图片 URL
     * @param imageHash 图片image_hash
     * @return image url
     * @throws ElemeErrorException
     */
    String getImageUrl(String imageHash) throws ElemeErrorException;

    /**
     * 通过url上传图片
     * 图片格式：不大于 300 k，支持 jpeg 和 png 格式
     * @param imageUrl 	图片url
     * @return image hash
     * @throws ElemeErrorException
     */
    String uploadByUrl(String imageUrl) throws ElemeErrorException;
}
