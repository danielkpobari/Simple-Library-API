package com.daniel_wizer.libraryapi.service;


import com.daniel_wizer.libraryapi.models.users.enums.ERole;
import com.daniel_wizer.libraryapi.payload.request.LoginRequest;
import com.daniel_wizer.libraryapi.payload.request.RegistrationRequest;
import com.daniel_wizer.libraryapi.payload.response.LoginResponse;
import com.daniel_wizer.libraryapi.payload.response.RegistrationResponse;

public interface UserService {

    RegistrationResponse registration(RegistrationRequest userRegistrationRequest, ERole eRole);

    LoginResponse login(LoginRequest loginRequest);
}
