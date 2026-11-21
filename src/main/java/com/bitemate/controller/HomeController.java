//      HomeController.java handles requests for the BiteMate home page.
//        It retrieves food items from the database through the Service,
//        sends that data to the Thymeleaf HTML template, and displays the food dashboard
//        in the browser.
package com.bitemate.controller;

import com.bitemate.entity.FoodItem;
import com.bitemate.service.FoodItemService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Handles browser page requests and returns Thymeleaf templates.
@Controller
public class  HomeController {

    private final FoodItemService foodItemService;

    // Spring automatically injects FoodItemService.
    public HomeController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }


    // Opens the public landing page.
    @GetMapping("/")
    public String home() {
        return "home";
    }
    // Opens the login page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Opens the food dashboard and loads saved food items.
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<FoodItem> foods = foodItemService.getAllFoodItems();
        model.addAttribute("foods", foods);
        return "foods";
    }

    // Handles the Add Food form.
    @PostMapping("/add-food")
    public String addFood(@ModelAttribute FoodItem foodItem) {
        foodItemService.addFoodItem(foodItem);
        return "redirect:/dashboard";
    }

    // Handles the Delete Food form.
    @PostMapping("/delete-food/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodItemService.deleteFoodItem(id);
        return "redirect:/dashboard";
    }
}