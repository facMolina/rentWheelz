package com.example.rentWheelz.repostory;

import com.example.rentWheelz.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//extends JpaRepository <Reservation, Integer>
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    //Make method to findByMail
    List<Reservation> findByMail(String mail);
}
