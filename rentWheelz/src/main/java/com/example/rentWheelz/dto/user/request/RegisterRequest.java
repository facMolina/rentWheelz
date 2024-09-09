package com.example.rentWheelz.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    //Make private attributes userName, userMail, userPassword,
    private String userName;
    private String userMail;
    private String userPassword;
    private String proofID;
}
