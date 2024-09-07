package com.web_exam.web_library.domain.facades;

import com.web_exam.web_library.domain.model.Book;
import com.web_exam.web_library.domain.useCases.book.NewBook;
import org.springframework.stereotype.Component;

@Component
public class BookFacade {

    private final NewBook newBook;

    public BookFacade(NewBook newBook) {
        this.newBook = newBook;
    }

    public void saveBook(Book book) {
        newBook.execute(book);
    }
}
