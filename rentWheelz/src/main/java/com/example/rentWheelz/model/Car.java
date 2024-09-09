package com.example.rentWheelz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Data
@Entity
@Table(name = "CARS")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Car {
    // add private attributes id, model, registration, availability, brand, price and thumbnail
    @Id
    @Column(name = "carId", nullable = false, unique = true)
    private String id;
    @Column(name = "carModel", nullable = false)
    private String model;
    @Column(name = "registrationNumber", nullable = false, unique = true)
    private String registration;
    @Column(name = "carAvailability", nullable = false)
    private String availability;
    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "pricePerHour", nullable = false)
    private BigDecimal price;
    @Column(name = "thumbnail", nullable = false)
    private String thumbnail;
}
