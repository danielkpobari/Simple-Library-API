package com.daniel_wizer.libraryapi.payload.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FavoriteRequest {


    @NotNull
    @ApiModelProperty(notes = "Book ID")
    @Min(value = 1, message = " Book ID cannot be less than 1")
    private Long bookId;


    @NotNull(message = "id cannot be null")
    @ApiModelProperty(notes = "User's Id")
    @Min(value = 1, message = " User ID cannot be less than 1")
    private Long userId;

}
