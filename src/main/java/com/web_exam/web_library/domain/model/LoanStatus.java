package com.web_exam.web_library.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoanStatus {
    PENDING("Pendente"),
    RETURNED("Devolvido"),
    LATE("Atrasado");

    private final String status;
}