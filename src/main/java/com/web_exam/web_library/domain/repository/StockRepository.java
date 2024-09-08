package com.web_exam.web_library.domain.repository;

import com.web_exam.web_library.domain.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
