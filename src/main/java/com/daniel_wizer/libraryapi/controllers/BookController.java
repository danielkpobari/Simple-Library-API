package com.daniel_wizer.libraryapi.controllers;

import com.daniel_wizer.libraryapi.payload.request.BookRequest;
import com.daniel_wizer.libraryapi.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "This is a bad request, please follow the API documentation for the proper request format."),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "The server is down, please make sure that the Application is running")
})
@AllArgsConstructor
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bookService;

    @PostMapping("/add-book")
    @ApiOperation(value = "Adds a book to the library, and under a category")
    public ResponseEntity<?> addBook(@Valid @RequestBody BookRequest bookRequest) {
        return new ResponseEntity<>(bookService.addBook(bookRequest), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Retrieves all books in the library")
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    @ApiOperation(value = "Retrieves a particular book with its ID")
    public  ResponseEntity<?> getBook(@PathVariable("bookId") Long bookId) {
        return  new ResponseEntity<>(bookService.getBook(bookId), HttpStatus.OK);
    }


    @PutMapping("/edit-book/{bookId}")
    @ApiOperation(value = "Updates a particular book based on its ID")
    public ResponseEntity<?> editBook(@PathVariable Long bookId, @Valid @RequestBody BookRequest bookRequest) {
        return new ResponseEntity<>(bookService.updateBook(bookId, bookRequest), HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete-book/{bookId}")
    @ApiOperation(value = "Deletes a particular book with its ID")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {

        return new ResponseEntity<>(bookService.deleteBook(bookId), HttpStatus.OK);
    }
//    @GetMapping("/{categoryId}")
//    @ApiOperation(value = "Retrieves all books under a particular category")
//    public ResponseEntity<?> getBooksByCategory(@PathVariable("categoryId") Long categoryId) {
//        return new ResponseEntity<>(bookService.getBooksByCategory(categoryId), HttpStatus.OK);
//    }
}
