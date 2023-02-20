package com.daniel_wizer.libraryapi.payload.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable {

    @ApiModelProperty(notes = "Login Message")
    private String message;

    @ApiModelProperty(notes = "Access Token")
    private String access_token;

    @ApiModelProperty(notes = "Role")
    private String role;

    public LoginResponse(String token, String role) {
        this.message = "Welcome, you are logged in";
        this.access_token = token;
        this.role = role;
    }
}
