package com.daniel_wizer.libraryapi.payload.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookRequest {

    @NotBlank(message = "Title cannot be empty")
    @ApiModelProperty(notes = "Book Title")
    @Size(min = 2, message = "Title cannot be less than 3 characters")
    private String bookTitle;

    @NotBlank(message = "Author cannot be empty")
    @ApiModelProperty(notes = "Book Author")
    @Size(min = 2, message = "Book Author name cannot be less than 3 characters")
    private String bookAuthor;

    @NotNull
    @ApiModelProperty(notes = "Book Quantity")
    @Min(value = 0, message = "Quantity cannot be less than 0")
    private Integer quantity;

    @NotNull
    @ApiModelProperty(notes = "Category ID")
    @Min(value = 1, message = "Category ID cannot be less than 1")
    private Long categoryId;
}
