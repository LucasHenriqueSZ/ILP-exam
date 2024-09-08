package com.web_exam.web_library.domain.useCases.book;

import com.web_exam.web_library.application.messages.MessagesErrors;
import com.web_exam.web_library.domain.model.Book;
import com.web_exam.web_library.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class NewBook {

    private final BookRepository bookRepository;

    public NewBook(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute(Book book) {
        if (bookRepository.findByIsbn(book.getIsbn()).isPresent()) {
            throw new IllegalArgumentException(MessagesErrors.BOOK_ALREADY_REGISTERED.getMessage());
        }
        book.getStock().setBook(book);
        book.getStock().setAvailable(book.getStock().getQuantity());
        bookRepository.save(book);
    }
}
