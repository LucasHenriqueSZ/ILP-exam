package com.web_exam.web_library.application.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessagesSuccess {
    BOOK_CREATED("Livro cadastrado com sucesso."),
    BOOK_DELETED("Livro excluído com sucesso."),
    BOOK_UPDATED("Livro atualizado com sucesso."),
    LOAN_CREATED("Empréstimo realizado com sucesso."),
    LOAN_RETURNED("Empréstimo devolvido com sucesso.");

    private final String message;
}
