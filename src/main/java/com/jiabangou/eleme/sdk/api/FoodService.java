package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.Food;
import com.jiabangou.eleme.sdk.model.FoodSave;

import java.util.List;

/**
 * Created by freeway on 16/7/11.
 */
public interface FoodService {

    Food getById(Long foodId) throws ElemeErrorException;

    List<Food> getsByIds(List<Long> foodIds) throws ElemeErrorException;

    Long add(FoodSave foodSave) throws ElemeErrorException;

    void update(FoodSave foodSave) throws ElemeErrorException;

    void remove(Long foodId) throws ElemeErrorException;

    void removeAll(List<Long> foodIds) throws ElemeErrorException;

    List<Food> getsByFoodCategoryId(Long foodCategoryId) throws ElemeErrorException;
}
