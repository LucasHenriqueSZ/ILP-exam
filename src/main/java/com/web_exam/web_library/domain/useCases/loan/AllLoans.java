package com.web_exam.web_library.domain.useCases.loan;

import com.web_exam.web_library.domain.model.Loan;
import com.web_exam.web_library.domain.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AllLoans {

    private final LoanRepository loanRepository;

    public Page<Loan> execute(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return loanRepository.findAll(pageable);
    }
}
