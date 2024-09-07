package com.web_exam.web_library.domain.facades;

import com.web_exam.web_library.domain.model.Book;
import com.web_exam.web_library.domain.useCases.book.AllBooks;
import com.web_exam.web_library.domain.useCases.book.DeleteBook;
import com.web_exam.web_library.domain.useCases.book.NewBook;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookFacade {

    private final NewBook newBook;
    private final AllBooks allBooks;
    private final DeleteBook deleteBook;

    public void saveBook(Book book) {
        newBook.execute(book);
    }

    public Page<Book> listBooks(int page, int size) {
        return allBooks.execute(page, size);
    }

    public void deleteBook(Long id) {
        deleteBook.execute(id);
    }
}
