package com.daniel_wizer.libraryapi.payload.response;

import com.daniel_wizer.libraryapi.models.users.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RegistrationResponse implements Serializable{

    @ApiModelProperty(notes = "User's Id")
    private Long userId;

    @ApiModelProperty(notes = "First Name")
    private String firstName;

    @ApiModelProperty(notes = "Last Name")
    private String lastName;

    @ApiModelProperty(notes = "Email")
    private String email;

//    private String phoneNumber; //todo: for later

    @JsonIgnore
    private boolean isActive = true;

    @ApiModelProperty(notes = "User's Address")
    private AddressResponse address;

    public static RegistrationResponse build(UserEntity user){
        return new RegistrationResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.isActive(),
                new AddressResponse(user.getAddress().getAddresss())
        );
    }

}
