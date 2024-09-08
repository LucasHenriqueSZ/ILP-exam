package com.web_exam.web_library.domain.facades;

import com.web_exam.web_library.domain.model.Loan;
import com.web_exam.web_library.domain.useCases.loan.NewLoan;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoanFacade {

    private final NewLoan newLoan;

    public void saveLoan(Loan loan) {
        newLoan.saveLoan(loan);
    }
}
