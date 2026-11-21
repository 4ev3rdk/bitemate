//This interface communicates with the database and provides operations such as saving users and finding users by email.
package com.bitemate.repository;

import com.bitemate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// Marks this interface as a Spring Data repository.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Finds a user using their email address.
    // Optional means the user may or may not exist.
    Optional<User> findByEmail(String email);
}
