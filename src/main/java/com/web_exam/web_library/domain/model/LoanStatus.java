package com.web_exam.web_library.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoanStatus {
    PENDING("Pendente"),
    RETURNED("Devolvido");

    private final String status;
}