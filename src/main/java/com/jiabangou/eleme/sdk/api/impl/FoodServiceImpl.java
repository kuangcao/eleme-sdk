package com.jiabangou.eleme.sdk.api.impl;

import com.jiabangou.eleme.sdk.api.ElemeConfigStorage;
import com.jiabangou.eleme.sdk.api.FoodService;
import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Food;

/**
 *
 * Created by freeway on 16/7/11.
 */
public class FoodServiceImpl extends BaseServiceImpl implements FoodService {

    private final static String FOOD = "/food/<food_id>/";
    private final static String FOOD_BATCH_GET = "/foods/batch_get/";

    public FoodServiceImpl(ElemeConfigStorage configStorage) {
        super(configStorage);
    }

    public Food get(long foodId) throws ElemeErrorException {
        return null;
    }
}
