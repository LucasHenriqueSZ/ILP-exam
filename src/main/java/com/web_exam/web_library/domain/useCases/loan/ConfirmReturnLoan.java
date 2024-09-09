package com.web_exam.web_library.domain.useCases.loan;

import com.web_exam.web_library.domain.model.Loan;
import com.web_exam.web_library.domain.model.LoanStatus;
import com.web_exam.web_library.domain.repository.LoanRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class ConfirmReturnLoan {

    private final LoanRepository loanRepository;

    @Transactional
    public void execute(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado."));
        if (loan.getReturnDate() != null) {
            throw new RuntimeException("Empréstimo já devolvido.");
        }
        loan.setReturnDate(LocalDate.now());
        loan.setStatus(LoanStatus.RETURNED);
        loan.getBook().getStock().setAvailable(loan.getBook().getStock().getAvailable() + 1);
        loanRepository.save(loan);
    }
}
