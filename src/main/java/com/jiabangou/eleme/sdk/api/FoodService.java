package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Food;
import com.jiabangou.eleme.sdk.model.FoodAdd;

import java.util.List;

/**
 * Created by freeway on 16/7/11.
 */
public interface FoodService {

    Food getById(long foodId) throws ElemeErrorException;

    List<Food> getsByIds(List<Long> foodIds) throws ElemeErrorException;

    long add(FoodAdd foodAdd) throws ElemeErrorException;

}
