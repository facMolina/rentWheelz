package com.example.rentWheelz.service.impl;

import com.example.rentWheelz.dto.user.request.LoginRequest;
import com.example.rentWheelz.dto.user.request.RegisterRequest;
import com.example.rentWheelz.dto.user.response.LoginResponse;
import com.example.rentWheelz.dto.user.response.RegisterResponse;
import com.example.rentWheelz.dto.response.RentWheelzResponse;
import com.example.rentWheelz.model.User;
import com.example.rentWheelz.repostory.UserRepository;
import com.example.rentWheelz.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    //declare a private final attribute of type UserRepository
    private final UserRepository userService;

    @Override
    public RegisterResponse register(RegisterRequest user) {
        //Verify the email does not exist in the database
        //If the email exists, throw an exception
        if (userService.findById(user.getUserMail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        //create a new user object with the registerRequest object
        var newUser = new User();
        newUser.setEmail(user.getUserMail());
        newUser.setName(user.getUserName());
        newUser.setUserPassword(user.getUserPassword());
        newUser.setProofId(user.getProofID());
        //save the user object in the database
        userService.save(newUser);
        //return a new registerResponse object with the status "success" and the message "User registered successfully"
        return new RegisterResponse("success", "User registered successfully");
    }

    //Make a method for login a user. This metod waiting for LoginRequest object and return UserResponse<LoginResponse> object
    public RentWheelzResponse<LoginResponse> login(LoginRequest loginRequest) {
        //Find the user by email
        var user = userService.findById(loginRequest.getEmail());
        //If the user is null, throw an exception
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        //If the user password is not equal to the password in the loginRequest object, throw an exception
        if (!user.get().getUserPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        //return a new UserResponse object with the status "success", the message "User logged in successfully" and a new LoginResponse object with the user id
        return new RentWheelzResponse<>("success", "User logged in successfully",
                LoginResponse.builder().userName(user.get().getName()).userEmail(user.get().getEmail()).proofId(user.get().getProofId()).build());
    }
}
