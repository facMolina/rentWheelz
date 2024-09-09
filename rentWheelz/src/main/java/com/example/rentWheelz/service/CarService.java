package com.example.rentWheelz.service;

import com.example.rentWheelz.dto.car.response.CarResponse;
import com.example.rentWheelz.model.Car;

import java.util.List;

public interface CarService {
    //make a method to get all cars. Use CarResponse<List<Car>> as return type
    CarResponse<List<Car>> getAllCars();
}
