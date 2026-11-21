//connect our backend to incoming http requests
package com.bitemate.controller;

import com.bitemate.entity.FoodItem;
import com.bitemate.service.FoodItemService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

// It handles HTTP requests and returns data directly (usually JSON).
@RestController
// Sets the common URL for all endpoints in this controller.
@RequestMapping("/api/foods")
public class FoodItemController {

    // Stores the FoodItemService dependency.
    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }
    // POST is used here to send a new food item to the server.(wants to add data)
    @PostMapping
    public FoodItem addFoodItem(@RequestBody FoodItem foodItem) {   // @RequestBody converts the incoming JSON data into a FoodItem object.
        // Pass that object to the service, which asks the repository to save it.
        return foodItemService.addFoodItem(foodItem);
    }

    // GET is used to retrieve all saved food items.(show menu)
    @GetMapping
    public List<FoodItem> getAllFoodItems() {

        // Ask the service to retrieve all food items and return the list.
        return foodItemService.getAllFoodItems();
    }

}

