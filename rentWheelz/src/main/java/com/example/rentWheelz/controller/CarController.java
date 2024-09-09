package com.example.rentWheelz.controller;

import com.example.rentWheelz.dto.car.response.CarResponse;
import com.example.rentWheelz.model.Car;
import com.example.rentWheelz.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    //Declare a final variable of type CarService
    private final CarService carService;

    //Make a get method for getting all cars calling "/getPackages" using getAllCars method from CarService
    @GetMapping(value = "/getPackages")
    public CarResponse<List<Car>> getCars() {
        return this.carService.getAllCars();
    }
}
