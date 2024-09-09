package com.example.rentWheelz.service.impl;

import com.example.rentWheelz.dto.car.response.CarResponse;
import com.example.rentWheelz.model.Car;
import com.example.rentWheelz.repostory.CarRepository;
import com.example.rentWheelz.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
//implements CarService
public class CarServiceImpl implements CarService {

    //declare a private final attribute of type CarRepository
    private final CarRepository carRepository;


    @Override
    public CarResponse<List<Car>> getAllCars() {
        //Find all cars in the database
        var cars = carRepository.findAll();
        //return a new CarResponse object with the status "success", the number of results and the list of cars
        return new CarResponse<>("success", cars.size(), cars);
    }
}
