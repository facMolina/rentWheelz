package com.example.rentWheelz.service;

import com.example.rentWheelz.dto.user.request.LoginRequest;
import com.example.rentWheelz.dto.user.request.RegisterRequest;
import com.example.rentWheelz.dto.user.response.LoginResponse;
import com.example.rentWheelz.dto.user.response.RegisterResponse;
import com.example.rentWheelz.dto.response.RentWheelzResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest user);
    RentWheelzResponse<LoginResponse> login(LoginRequest loginRequest);
}
