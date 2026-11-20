//Java classes representing DB tables
package com.bitemate.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity //tells Hibernate to treat this class as a database entity (table).
public class FoodItem {
    @Id //marks id as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue tells Hibernate to let the database generate its value when a new food item is saved. IDENTITTY uses dbs auto increment feature
    private Long id;  //we choose long because it supports null value(before saving to mysql ts value can be null) Integer can be fine as well but we use Long convention
    private String name;
    private double calories;
    private double protein;
    private double carbohydrates;
    private double fat;  //each field represent database column

    public FoodItem(String name, double calories, double protein, double carbohydrates, double fat) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
    }

    public FoodItem() {
    }

    public Long getId() {
        return id;
    }

    public double getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFat() {
        return fat;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }
}
