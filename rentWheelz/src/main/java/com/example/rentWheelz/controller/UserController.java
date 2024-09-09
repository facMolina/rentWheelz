package com.example.rentWheelz.controller;

import com.example.rentWheelz.dto.user.request.LoginRequest;
import com.example.rentWheelz.dto.user.request.RegisterRequest;
import com.example.rentWheelz.dto.user.response.LoginResponse;
import com.example.rentWheelz.dto.user.response.RegisterResponse;
import com.example.rentWheelz.dto.response.RentWheelzResponse;
import com.example.rentWheelz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

        //Declare a final variable of type UserService
        private final UserService userService;

        @PostMapping(value = "/register")
        public RegisterResponse register(@RequestBody RegisterRequest user) {
                return this.userService.register(user);
        }

        //make a post method for login a user
        @PostMapping(value = "/login")
        public RentWheelzResponse<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
                return this.userService.login(loginRequest);
        }
}
