package com.web_exam.web_library.application.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessagesSuccess {
    BOOK_CREATED("Livro cadastrado com sucesso.");

    private final String message;
}
