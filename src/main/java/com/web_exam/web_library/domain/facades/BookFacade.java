package com.web_exam.web_library.domain.facades;

import com.web_exam.web_library.domain.model.Book;
import com.web_exam.web_library.domain.useCases.book.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookFacade {

    private final NewBook newBook;
    private final EditBook editBook;
    private final AllBooks allBooks;
    private final DeleteBook deleteBook;
    private final FindBookById findBookById;

    public void saveBook(Book book) {
        newBook.execute(book);
    }

    public Page<Book> listBooks(int page, int size) {
        return allBooks.execute(page, size);
    }

    public void deleteBook(Long id) {
        deleteBook.execute(id);
    }

    public Book findBookById(Long id) {
        return findBookById.execute(id);
    }

    public void editBook(Book book) {
        editBook.execute(book);
    }
}
