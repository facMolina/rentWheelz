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

@Data
@Entity
@Table(name = "RENT_USERS")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class User {
    //create private attributes name, email, password and proofId. All of them are strings.
    @Id
    @Column(name = "userEmail", nullable = false, unique = true)
    private String email;
    @Column(name = "userName", nullable = false, unique = true)
    private String Name;
    @Column(name = "userPassword ", nullable = false, unique = true)
    private String userPassword;
    @Column(name = "proofId", nullable = false, unique = true)
    private String proofId;
}
