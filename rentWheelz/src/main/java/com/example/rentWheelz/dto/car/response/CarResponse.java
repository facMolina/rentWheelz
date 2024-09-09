package com.example.rentWheelz.dto.car.response;

public record CarResponse<T>(
        String status,
        Integer results,
        T data
) {

}