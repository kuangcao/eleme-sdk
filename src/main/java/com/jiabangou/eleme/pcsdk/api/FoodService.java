package com.jiabangou.eleme.pcsdk.api;

import com.jiabangou.eleme.pcsdk.model.Category;
import com.jiabangou.eleme.pcsdk.model.Food;
import okhttp3.MediaType;

import java.util.List;

/**
 * 菜品服务
 * Created by freeway on 2016/12/5.
 */
public interface FoodService {

    void fillStock(Long foodId);

    void fillStock(List<Long> foodIds);

    void clearStock(Long foodId);

    void clearStock(List<Long> foodIds);

    List<Food> getFoodsByCategoryId(Long categoryId);

    Food getFood(Long foodId);

    String uploadFoodImage(String url, MediaType mediaType);

    List<Category> getCategories(Long restaurantId);

}
