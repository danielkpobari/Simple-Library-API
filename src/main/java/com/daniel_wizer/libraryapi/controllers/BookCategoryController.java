package com.daniel_wizer.libraryapi.controllers;

import com.daniel_wizer.libraryapi.models.BookCategory;
import com.daniel_wizer.libraryapi.service.BookCategoryService;
import com.daniel_wizer.libraryapi.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "This is a bad request, please follow the API documentation for the proper request format."),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "The server is down, please make sure that the Application is running")
})
@AllArgsConstructor
@RequestMapping("api/v1/book-category")
public class BookCategoryController {

    private final BookCategoryService bookCategoryService;
    private final BookService bookService;

    @PostMapping("/add-category")
    @ApiOperation(value = "Adds a new category")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addCategory(@Valid @RequestBody BookCategory bookCategory) {
        return new ResponseEntity<>(bookCategoryService.addCategory(bookCategory), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Retrieves all categories in the library")
    public ResponseEntity<?> getAllCategories() {
        return new ResponseEntity<>(bookCategoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}/books")
    @ApiOperation(value = "Retrieves all books under a category, with its ID")
    public ResponseEntity<?> getAllBooksByCategory(@PathVariable("categoryId") Long categoryId) {
        return new ResponseEntity<>(bookService.getBooksByCategory(categoryId), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    @ApiOperation(value = "Retrieves a particular category with its ID")
    public  ResponseEntity<?> getCategory(@PathVariable("categoryId") Long categoryId) {
        return  new ResponseEntity<>(bookCategoryService.getCategory(categoryId), HttpStatus.OK);
    }


    @PutMapping("/update-category/{categoryId}")
    @ApiOperation(value = "Updates a particular category with its ID")
    public ResponseEntity<?> updateCategory(@PathVariable("categoryId") Long categoryId, @Valid @RequestBody BookCategory bookCategory) {
        return new ResponseEntity<>(bookCategoryService.updateCategory(categoryId, bookCategory), HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete-category/{categoryId}")
    @ApiOperation(value = "Deletes a particular category with its ID")
    public ResponseEntity<?> deleteBook(@PathVariable("categoryId") Long categoryId) {

        return new ResponseEntity<>(bookCategoryService.deleteCategory(categoryId), HttpStatus.OK);
    }
}
