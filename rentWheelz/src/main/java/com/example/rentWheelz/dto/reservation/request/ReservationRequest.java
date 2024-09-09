package com.example.rentWheelz.dto.reservation.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    private Date pickupDate;
    private Date returnDate;
    private Integer numOfTravellers;
    private String carId;
}
