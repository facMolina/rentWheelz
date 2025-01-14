package com.example.rentWheelz.repostory;

import com.example.rentWheelz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    //Make method to findyById
    Optional<User> findById(String id);
}
