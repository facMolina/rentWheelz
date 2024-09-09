package com.example.rentWheelz.controller;

import com.example.rentWheelz.dto.reservation.request.BookingRequest;
import com.example.rentWheelz.dto.reservation.request.CancelRequest;
import com.example.rentWheelz.dto.reservation.request.ReservationRequest;
import com.example.rentWheelz.dto.reservation.response.BookingResponse;
import com.example.rentWheelz.dto.reservation.response.CancelResponse;
import com.example.rentWheelz.dto.reservation.response.ReservationResponse;
import com.example.rentWheelz.dto.response.RentWheelzResponse;
import com.example.rentWheelz.model.Reservation;
import com.example.rentWheelz.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    //Declare a final variable of type ReservationService
    private final ReservationService reservationService;

    //Make a post method for booking a car calling "/reserve" using reserve method from ReservationService
    @PostMapping(value = "/reserve")
    public RentWheelzResponse<ReservationResponse> bookCar(@RequestBody ReservationRequest reservationRequest) {
        return this.reservationService.reserve(reservationRequest);
    }

    //Make a post method for getting all bookings of a user calling "/my-bookings" using myReservations method from ReservationService. Use the same response and request
    @PostMapping(value = "/my-bookings")
    public BookingResponse<List<Reservation>> myBookings(@RequestBody BookingRequest bookingRequest) {
        return this.reservationService.myReservations(bookingRequest);
    }

    //Make a post method for getting all bookings of a user calling "/cancel" using cancelReservation method from ReservationService. Use the same response and request.
    @PostMapping(value = "/cancel")
    public CancelResponse cancelBooking(@RequestBody CancelRequest cancelRequest) {
        return this.reservationService.cancelReservation(cancelRequest);
    }
}
