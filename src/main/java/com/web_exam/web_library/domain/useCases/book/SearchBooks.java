package com.web_exam.web_library.domain.useCases.book;

import com.web_exam.web_library.domain.model.Book;
import com.web_exam.web_library.domain.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchBooks {

    private final BookRepository bookRepository;

    public List<Book> execute(String query) {
        Pageable pageable = PageRequest.of(0, 5);
        return bookRepository.searchBooksByIsbnOrTitle(query, pageable);
    }

}
