package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.pcsdk.model.Category;
import com.jiabangou.eleme.pcsdk.model.Food;

import java.util.List;

/**
 * 食物服务
 * Created by freeway on 2016/12/5.
 */
public interface FoodService {

    void fillStock(Long foodId);

    void fillStock(List<Long> foodIds);

    void clearStock(Long foodId);

    void clearStock(List<Long> foodIds);

    List<Food> getFoodsByCategoryId(Long categoryId);

    List<Category> getCategories(Long restaurantId);

}
