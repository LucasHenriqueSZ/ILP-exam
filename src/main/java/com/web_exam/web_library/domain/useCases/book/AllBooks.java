package com.web_exam.web_library.domain.useCases.book;

import com.web_exam.web_library.domain.model.Book;
import com.web_exam.web_library.domain.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AllBooks {
    private final BookRepository bookRepository;

    public AllBooks(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<Book> execute(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findAll(pageable);
    }
}
