//Provides ready-made database operations for FoodItem entities using Spring Data JPA.
package com.bitemate.repository;
import com.bitemate.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
//jpaRepository(Spring Data Jpa interface) provide readymade db operations
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

}
