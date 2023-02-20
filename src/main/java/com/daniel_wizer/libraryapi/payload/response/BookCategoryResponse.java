package com.daniel_wizer.libraryapi.payload.response;

import lombok.Data;

@Data
public class BookCategoryResponse {

    private String message;

    private String category;

    public BookCategoryResponse(Long id, String category) {
        this.message = "ID for this category is " + id;
        this.category = category;
    }
}
