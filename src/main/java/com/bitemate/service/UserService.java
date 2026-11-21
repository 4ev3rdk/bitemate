
package com.bitemate.service;

import com.bitemate.entity.User;
import com.bitemate.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Contains the business logic related to users.
@Service
public class UserService {

    private final UserRepository userRepository;

    // BCrypt converts plain-text passwords into secure password hashes.
    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    // Constructor injection: Spring provides UserRepository automatically.
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Hashes the password and saves the new user in the database.
    public User registerUser(User user) {

        // Convert the original password into a BCrypt hash.
        String hashedPassword = passwordEncoder.encode(user.getPassword());

        // Store the hashed password instead of the original password.
        user.setPassword(hashedPassword);

        // Save the user record in MySQL.
        return userRepository.save(user);
    }

    // Finds an existing user using their email address.
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

