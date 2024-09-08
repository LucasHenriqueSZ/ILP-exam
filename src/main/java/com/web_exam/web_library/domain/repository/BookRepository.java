package com.web_exam.web_library.domain.repository;

import com.web_exam.web_library.domain.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);

    @Query("SELECT b FROM Book b WHERE LOWER(b.isbn) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(b.title) LIKE LOWER(CONCAT('%', :search, '%')) ")
    List<Book> searchBooksByIsbnOrTitle(@Param("search") String search, Pageable pageable);
}
