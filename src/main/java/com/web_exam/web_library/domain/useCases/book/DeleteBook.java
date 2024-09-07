package com.web_exam.web_library.domain.useCases.book;

import com.web_exam.web_library.domain.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteBook {

    private final BookRepository bookRepository;

    public void execute(Long id) {
        // TODO: verificar se nao tem livro emprestado
        bookRepository.deleteById(id);
    }

}
