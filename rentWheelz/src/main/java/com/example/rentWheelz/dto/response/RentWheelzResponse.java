package com.example.rentWheelz.dto.response;

public record RentWheelzResponse<T>(
        String status,
        String message,
        T data
) {

}

