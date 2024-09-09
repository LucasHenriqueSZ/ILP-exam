package com.web_exam.web_library.domain.useCases.book;

import com.web_exam.web_library.application.messages.MessagesErrors;
import com.web_exam.web_library.domain.model.Book;
import com.web_exam.web_library.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class EditBook {

    private final BookRepository bookRepository;

    public EditBook(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute(Book book) {
        Book bookFound = bookRepository.findById(book.getId()).orElseThrow(() ->
                new RuntimeException(MessagesErrors.BOOK_NOT_FOUND.getMessage()));

        bookRepository.findByIsbn(book.getIsbn()).ifPresent(existingBook -> {
            if (!existingBook.getId().equals(bookFound.getId())) {
                throw new IllegalArgumentException(MessagesErrors.BOOK_ALREADY_REGISTERED.getMessage());
            }
        });

        if (book.getStock().getQuantity() < bookFound.getStock().getQuantityLoaned()) {
            throw new IllegalArgumentException("A quantidade de estoque não pode ser menor do que a quantidade emprestada.");
        }

        book.getStock().setBook(book);
        book.getStock().setAvailable(book.getStock().getQuantity() - bookFound.getStock().getQuantityLoaned());
        bookRepository.save(book);
    }
}
