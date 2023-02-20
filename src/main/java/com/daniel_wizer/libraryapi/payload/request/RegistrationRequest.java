package com.daniel_wizer.libraryapi.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegistrationRequest {

    @NotBlank(message = "First Name cannot be empty")
    @Size(min = 3, max = 20, message = "first name must be between 3 and 20 characters long")
    @ApiModelProperty(notes = "User's First Name")
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty")
    @Size(min = 3, max = 20, message = "first name must be between 3 and 20 characters long")
    @ApiModelProperty(notes = "User's Last Name")
    private String lastName;

    @NotBlank(message = "email cannot be empty")
    @Email(message = "Email should be valid")
    @ApiModelProperty(notes = "User's Email")
    private String email;

    @JsonIgnore
    private boolean isActive = true;

    @NotBlank(message = "Address cannot be empty")
    @Size(min = 3, max = 50, message = "Address must be between 3 and 50 characters long")
    @ApiModelProperty(notes = "User's Address")
    private String address;

    @NotBlank(message = "please enter a password")
    @Size(min = 8, message = "password length must be more than 7, Must contain An Uppercase, Lowercase and a number")
    @ApiModelProperty(notes = "User's password")
    private String password;

    @NotBlank(message = "please enter same password as before")
    @Size(min = 8, message = "password must match")
    @ApiModelProperty(notes = "Confirm password")
    private String confirmPassword;

}
