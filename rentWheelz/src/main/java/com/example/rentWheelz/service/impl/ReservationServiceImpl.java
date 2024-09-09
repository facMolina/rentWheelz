package com.example.rentWheelz.service.impl;

import com.example.rentWheelz.dto.reservation.request.BookingRequest;
import com.example.rentWheelz.dto.reservation.request.CancelRequest;
import com.example.rentWheelz.dto.reservation.request.ReservationRequest;
import com.example.rentWheelz.dto.reservation.response.BookingResponse;
import com.example.rentWheelz.dto.reservation.response.CancelResponse;
import com.example.rentWheelz.dto.reservation.response.ReservationResponse;
import com.example.rentWheelz.dto.response.RentWheelzResponse;
import com.example.rentWheelz.model.Reservation;
import com.example.rentWheelz.repostory.CarRepository;
import com.example.rentWheelz.repostory.ReservationRepository;
import com.example.rentWheelz.repostory.UserRepository;
import com.example.rentWheelz.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
//implement the ReservationService interface
public class ReservationServiceImpl implements ReservationService {

    //declare a private final attribute of type ReservationRepository
    private final ReservationRepository reservationRepository;

    //declare a private final attribute of type CarRepository
    private final CarRepository carRepository;

    //declare a private final attribute of type UserRepository
    private final UserRepository userRepository;

    @Override
    public RentWheelzResponse<ReservationResponse> reserve(ReservationRequest reservationRequest) {
        //Get all users, and select a random user
        var user = userRepository.findAll().stream().findAny().orElseThrow();
        //From the list of available car user should be able to reserve the selected car
        // after entering the required information
        var cars = carRepository.findAll();
        var reservations = reservationRepository.findAll();
        //filter the reservations and cars by the pickupDate, returnDate and carId available in the reservationRequest object
        var filteredReservations = reservations.stream().filter(reservation -> reservation.getPickupDate()
                .equals(reservationRequest.getPickupDate()) && reservation.getReturnDate()
                .equals(reservationRequest.getReturnDate()) && reservation.getCarId()
                .equals(reservationRequest.getCarId())).toList();
        var filteredCars = cars.stream().filter(car -> car.getId().equals(reservationRequest.getCarId())).toList();
        //If the car is not available and the reservation is not available, throw an exception
        if (filteredCars.isEmpty() || !filteredReservations.isEmpty()) {
            throw new RuntimeException("Car not available");
        }
        //calculate days between pickupDate and returnDate
        long days = (reservationRequest.getReturnDate().getTime() - reservationRequest.getPickupDate().getTime()) / (1000 * 60 * 60 * 24);
        //calculate hours by multiplying days by 24
        long hours = days * 24;
        //create a new reservation object with the reservationRequest object and user
        var newReservation = new Reservation();
        newReservation.setMail(user.getEmail());
        newReservation.setCarId(reservationRequest.getCarId());
        newReservation.setReservation(LocalDate.now());
        newReservation.setPickupDate(reservationRequest.getPickupDate());
        newReservation.setReturnDate(reservationRequest.getReturnDate());
        newReservation.setTravellers(reservationRequest.getNumOfTravellers());
        newReservation.setStatus("RESERVED");
        newReservation.setCar(cars.stream().filter(car -> car.getId().equals(reservationRequest.getCarId()))
                .findFirst().orElseThrow().getModel());
        newReservation.setImg(cars.stream().filter(car -> car.getId().equals(reservationRequest.getCarId()))
                .findFirst().orElseThrow().getThumbnail());
        newReservation.setTotal(cars.stream().filter(car -> car.getId().equals(reservationRequest.getCarId()))
                .findFirst().orElseThrow().getPrice().multiply(BigDecimal.valueOf(hours)));
        //save the new reservation object
        reservationRepository.save(newReservation);
        //return a new RentWheelzResponse object with the new ReservationResponse object
        return new RentWheelzResponse<>("success", "Reservation successful",
                ReservationResponse.builder()
                        .bookingId(String.valueOf(newReservation.getId()))
                        .userEmail(newReservation.getMail())
                        .build());
    }

    @Override
    public BookingResponse<List<Reservation>> myReservations (BookingRequest request) {
        //Get all reservations by email
        var bookings = reservationRepository.findByMail(request.getUserEmail());
        //return a new BookingResponse object with the reservations
        return new BookingResponse<>("success",bookings);
    }

    @Override
    public CancelResponse cancelReservation(CancelRequest request) {
        //Get the reservation by bookingId
        var reservation = reservationRepository.findById(request.getBookingId());
        //If the reservation is not present, throw an exception
        if (reservation.isEmpty()) {
            throw new RuntimeException("Reservation not found");
        }
        //update the status of the reservation to CANCELLED
        reservation.get().setStatus("CANCELLED");
        //save the updated reservation
        reservationRepository.save(reservation.get());
        //return a new CancelResponse object with the bookingId
        return new CancelResponse("success", "Your reservation has been cancelled");
    }


}
