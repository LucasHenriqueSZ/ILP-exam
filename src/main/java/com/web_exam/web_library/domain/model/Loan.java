package com.web_exam.web_library.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lon_id")
    private Long id;

    @NotBlank(message = "O nome do tomador não pode estar em branco.")
    @Column(name = "lon_borrower_name")
    private String borrowerName;

    @CPF(message = "O CPF fornecido é inválido.")
    @Column(name = "lon_borrower_cpf")
    private String borrowerCpf;

    @Column(name = "lon_date")
    @PastOrPresent(message = "A data do empréstimo não pode ser futura.")
    private LocalDate loanDate;

    @Column(name = "lon_due_date")
    @NotNull(message = "A data de vencimento não pode estar em branco.")
    @Future(message = "A data de vencimento não pode ser passada.")
    private LocalDate dueDate;

    @Column(name = "lon_return_date")
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "lon_status")
    private LoanStatus status;

    @Column(name = "lon_late")
    private boolean late;

    @Column(name = "lon_price")
    @NotNull(message = "O preço do empréstimo não pode ser nulo.")
    @Positive(message = "O preço do empréstimo não pode ser negativo.")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bok_id")
    @NotNull(message = "O empréstimo deve estar associado a um livro.")
    private Book book;
}
