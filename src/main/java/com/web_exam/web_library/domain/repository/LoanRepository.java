package com.web_exam.web_library.domain.repository;

import com.web_exam.web_library.domain.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
