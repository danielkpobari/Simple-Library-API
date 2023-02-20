package com.daniel_wizer.libraryapi.payload.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {

    @NotBlank(message = "email cannot be empty")
    @Email(message = "Email should be valid")
    @ApiModelProperty(notes = "User's Email")
    private String email;

    @NotBlank(message = "please enter a password")
    @Size(min = 8, message = "password length must be more than 7, Must contain An Uppercase, Lowercase and a number")
    @ApiModelProperty(notes = "User's password")
    private String password;
}
