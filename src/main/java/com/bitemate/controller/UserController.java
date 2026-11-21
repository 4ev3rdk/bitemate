//handle registration form submissions and display the login and registration pages.

package com.bitemate.controller;

import com.bitemate.entity.User;
import com.bitemate.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Handles browser requests related to user registration.
@Controller
public class UserController {

    private final UserService userService;

    // Spring automatically injects UserService.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Displays the registration page.
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // Handles the submitted registration form.
    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute User user,
            @RequestParam String confirmPassword,
            Model model) {

        // Check whether this email is already registered.
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "Email is already registered.");
            return "register";
        }

        // Check whether both entered passwords match.
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            return "register";
        }

        // Save the user; UserService hashes the password before saving.
        userService.registerUser(user);

        // Redirect to login after successful registration.
        return "redirect:/login";
    }
}

