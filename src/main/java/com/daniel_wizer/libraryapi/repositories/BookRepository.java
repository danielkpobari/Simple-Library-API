package com.daniel_wizer.libraryapi.repositories;

import com.daniel_wizer.libraryapi.models.Book;
import com.daniel_wizer.libraryapi.models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.category = ?1")
    List<Book> findAllByCategory(BookCategory bookCategory);

    @Query("select b from Book b where b.id = ?1")
    Book getBookById(Long id);
}
