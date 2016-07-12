package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Food;

/**
 * Created by freeway on 16/7/11.
 */
public interface FoodService {

    Food get(long foodId) throws ElemeErrorException;

}
