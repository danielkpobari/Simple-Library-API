package com.daniel_wizer.libraryapi.repositories;

import com.daniel_wizer.libraryapi.models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

}
