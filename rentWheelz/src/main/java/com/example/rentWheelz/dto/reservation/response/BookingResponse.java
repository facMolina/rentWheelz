package com.example.rentWheelz.dto.reservation.response;

public record BookingResponse<T>(
        String status,
        T data
) {
}
