package com.web_exam.web_library.domain.useCases.book;

import com.web_exam.web_library.application.messages.MessagesErrors;
import com.web_exam.web_library.domain.model.Book;
import com.web_exam.web_library.domain.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindBookById {

    private final BookRepository bookRepository;

    public Book execute(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new RuntimeException(MessagesErrors.BOOK_NOT_FOUND.getMessage()));
    }
}
