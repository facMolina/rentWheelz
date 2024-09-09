package com.example.rentWheelz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "RESERVATIONS")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Reservation {
    //add private attributes id, mail, carId, reservation, pickupDate, returnDate, travellers, status, car, img and total
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId", nullable = false, unique = true)
    private Integer id;
    @Column(name = "userEmail", nullable = false)
    private String mail;
    @Column(name = "carId", nullable = false)
    private String carId;
    @Column(name = "reservationDate", nullable = false)
    private LocalDate reservation;
    @Column(name = "pickupDate", nullable = false)
    private Date pickupDate;
    @Column(name = "returnDate", nullable = false)
    private Date returnDate;
    @Column(name = "numOfTravellers", nullable = false)
    private Integer travellers;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "carName", nullable = false)
    private String car;
    @Column(name = "img", nullable = false)
    private String img;
    @Column(name = "total", nullable = false)
    private BigDecimal total;
}
