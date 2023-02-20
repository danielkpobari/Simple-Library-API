package com.daniel_wizer.libraryapi.service;

import com.daniel_wizer.libraryapi.payload.response.ApiResponse;
import com.daniel_wizer.libraryapi.payload.response.BookCategoryResponse;
import com.daniel_wizer.libraryapi.models.BookCategory;

import java.util.List;

public interface BookCategoryService {
    List<BookCategoryResponse> getAllCategories();
    BookCategoryResponse getCategory(Long id);
    BookCategoryResponse addCategory(BookCategory category);
    BookCategoryResponse updateCategory(Long id, BookCategory newCategory);
    ApiResponse deleteCategory(Long id);
}
