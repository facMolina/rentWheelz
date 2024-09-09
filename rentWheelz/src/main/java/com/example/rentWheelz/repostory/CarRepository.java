package com.example.rentWheelz.repostory;

import com.example.rentWheelz.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//extends JpaRepository <Car, Integer>
public interface CarRepository extends JpaRepository<Car, String> {
    //Make method to findAll
    List<Car> findAll();
}
