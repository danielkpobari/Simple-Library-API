package com.daniel_wizer.libraryapi.service.implementation;

import com.daniel_wizer.libraryapi.repositories.BookCategoryRepository;
import com.daniel_wizer.libraryapi.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBeans;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookCategoryRepository bookCategoryRepository;


    @Test
    void shouldRetrieveABook() {

    }

    @Test
    void ShouldAddBook() {
    }

    @Test
    void shouldDeleteBook() {

    }
}