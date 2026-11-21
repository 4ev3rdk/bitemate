// Handles food item business logic and coordinates operations between controllers and the repository.
package com.bitemate.service;

import com.bitemate.entity.FoodItem;
import com.bitemate.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

// List is used to store and return multiple FoodItem objects.
import java.util.List;
@Service  //this class contais logic so other part of app can use it
public class FoodItemService {

    // Repository reference used to communicate with the database.
    private final FoodItemRepository foodItemRepository; //FoodItemRepository(data type:interface)

    // Constructor injection: Spring provides the repository automatically.
    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    // Saves a new food item into sql
    public FoodItem addFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem); //Spring Data JPA Method
    }

    // Retrieves all food items from the database.
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll(); //Spring Data JPA Method
    }
    // Deletes a food item from the database using its ID.
    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }
}
