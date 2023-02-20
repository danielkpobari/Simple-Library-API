package com.daniel_wizer.libraryapi.payload.response;

import lombok.Data;

@Data
public class BookResponse {

    private String message;

    private String bookTitle;

    private String bookAuthor;

    private Integer quantity;

    private String categoryName;

    public BookResponse(Long id, String bookTitle, String bookAuthor, Integer quantity, String categoryName) {
        this.message = "Id of this book is " + id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.quantity = quantity;
        this.categoryName = categoryName;
    }
}
