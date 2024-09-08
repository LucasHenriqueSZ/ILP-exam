package com.web_exam.web_library.domain.useCases.loan;

import com.web_exam.web_library.domain.model.Loan;
import com.web_exam.web_library.domain.model.LoanStatus;
import com.web_exam.web_library.domain.model.Stock;
import com.web_exam.web_library.domain.repository.LoanRepository;
import com.web_exam.web_library.domain.repository.StockRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class NewLoan {

    private final LoanRepository loanRepository;
    private final StockRepository stockRepository;

    @Transactional
    public void saveLoan(Loan loan) {
        Stock stock = loan.getBook().getStock();
        if (stock.getAvailable() <= 0) {
            throw new IllegalArgumentException("Livro indisponível.");
        }

        loan.setStatus(LoanStatus.PENDING);
        loan.setLoanDate(LocalDate.now());
        loanRepository.save(loan);

        stock.setAvailable(stock.getAvailable() - 1);
        stockRepository.save(stock);
    }
}
