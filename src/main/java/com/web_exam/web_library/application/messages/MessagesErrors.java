package com.web_exam.web_library.application.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessagesErrors {
    BOOK_ALREADY_REGISTERED("Livro já cadastrado"),
    BOOK_NOT_FOUND("Livro não encontrado");

    private final String message;
}
