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

    void removeFood(Long foodId);

    Food createFood(Food food);

    Food updateFood(Food food);

    String uploadFoodImage(String url, MediaType mediaType);

    List<Category> getCategories(Long restaurantId);

    void setFoodPosition(Long foodId, int position);

    void onShelf(Long foodId);

    void onShelf(List<Long> foodIds);

    void offShelf(Long foodId);

    void offShelf(List<Long> foodIds);

    Category createCategory(Long restaurantId, String name, String description);

    void removeCategory(Long categoryId);

    Category updateCategory(Category category);
}
