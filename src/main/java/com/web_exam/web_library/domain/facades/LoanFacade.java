package com.web_exam.web_library.domain.facades;

import com.web_exam.web_library.domain.model.Loan;
import com.web_exam.web_library.domain.useCases.loan.AllLoans;
import com.web_exam.web_library.domain.useCases.loan.ConfirmReturnLoan;
import com.web_exam.web_library.domain.useCases.loan.FindConfirmReturnLoan;
import com.web_exam.web_library.domain.useCases.loan.NewLoan;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoanFacade {

    private final NewLoan newLoan;
    private final AllLoans allLoans;
    private final FindConfirmReturnLoan findConfirmReturnLoan;
    private final ConfirmReturnLoan confirmReturnLoan;

    public void saveLoan(Loan loan) {
        newLoan.saveLoan(loan);
    }

    public Page<Loan> listLoans(int page, int size) {
        return allLoans.execute(page, size);
    }

    public Loan findLoanConfirmReturn(Long id) {
        return findConfirmReturnLoan.execute(id);
    }

    public void confirmReturnLoan(Long id) {
        confirmReturnLoan.execute(id);
    }
}
