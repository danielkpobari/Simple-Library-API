package com.daniel_wizer.libraryapi.controllers;

import com.daniel_wizer.libraryapi.models.users.enums.ERole;
import com.daniel_wizer.libraryapi.payload.request.LoginRequest;
import com.daniel_wizer.libraryapi.payload.request.RegistrationRequest;
import com.daniel_wizer.libraryapi.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {

    private final UserService registrationService;

    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registers a new User")
    public ResponseEntity<?>  register(@Valid @RequestBody RegistrationRequest userRegistrationRequest) {
        log.info("Creating an admin account");
        return new ResponseEntity<>(registrationService.registration(userRegistrationRequest, ERole.USER), HttpStatus.CREATED);
    }

    @PostMapping(path = "admin/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registers a new Admin")
    public ResponseEntity<?> adminRegistration(@Valid @RequestBody RegistrationRequest adminRegistrationRequest) {
        return new ResponseEntity<>(registrationService.registration(adminRegistrationRequest, ERole.ADMIN), HttpStatus.CREATED);
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Log's in a User/Admin")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        log.info("User logging in: USER Controller");
        return new ResponseEntity<>(registrationService.login(loginRequest), HttpStatus.OK);
    }


}
