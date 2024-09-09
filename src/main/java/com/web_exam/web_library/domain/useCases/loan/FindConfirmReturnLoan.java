package com.web_exam.web_library.domain.useCases.loan;

import com.web_exam.web_library.domain.model.Loan;
import com.web_exam.web_library.domain.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindConfirmReturnLoan {

    private final LoanRepository loanRepository;

    public Loan execute(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado."));
        if (loan.getReturnDate() != null) {
            throw new RuntimeException("Empréstimo já devolvido.");
        }
        return loan;
    }
}
