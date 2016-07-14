package com.jiabangou.eleme.sdk.api;

import com.jiabangou.eleme.sdk.exception.ElemeErrorException;
import com.jiabangou.eleme.sdk.model.FoodCategoryDetail;

import java.util.List;

/**
 * Created by freeway on 16/7/13.
 */
public interface RestaurantService {


    List<FoodCategoryDetail> getMenu(Long restaurantId) throws ElemeErrorException;


}
