package com.example.rentWheelz.service;

import com.example.rentWheelz.dto.reservation.request.BookingRequest;
import com.example.rentWheelz.dto.reservation.request.CancelRequest;
import com.example.rentWheelz.dto.reservation.request.ReservationRequest;
import com.example.rentWheelz.dto.reservation.response.BookingResponse;
import com.example.rentWheelz.dto.reservation.response.CancelResponse;
import com.example.rentWheelz.dto.reservation.response.ReservationResponse;
import com.example.rentWheelz.dto.response.RentWheelzResponse;
import com.example.rentWheelz.model.Reservation;

import java.util.List;

public interface ReservationService {

    RentWheelzResponse<ReservationResponse> reserve(ReservationRequest reservationRequest);
    BookingResponse<List<Reservation>> myReservations(BookingRequest request);
    CancelResponse cancelReservation(CancelRequest request);
}
