
package com.bitemate.entity;

import jakarta.persistence.*;

// Marks this class as a database entity.
@Entity

// Specifies the table name in MySQL.
@Table(name = "users")
public class User {

    // Primary key: uniquely identifies each user.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Stores the user's full name.
    private String name;

    // Stores email and prevents duplicate registrations.
    @Column(unique = true, nullable = false)
    private String email;

    // Stores the user's hashed password (not plain text).
    @Column(nullable = false)
    private String password;

    // Default constructor required by JPA.
    public User() {
    }

    // Returns the user's ID.
    public Long getId() {
        return id;
    }

    // Sets the user's ID.
    public void setId(Long id) {
        this.id = id;
    }

    // Returns the user's name.
    public String getName() {
        return name;
    }

    // Sets the user's name.
    public void setName(String name) {
        this.name = name;
    }

    // Returns the user's email.
    public String getEmail() {
        return email;
    }

    // Sets the user's email.
    public void setEmail(String email) {
        this.email = email;
    }

    // Returns the user's password.
    public String getPassword() {
        return password;
    }

    // Sets the user's password.
    public void setPassword(String password) {
        this.password = password;
    }
}
