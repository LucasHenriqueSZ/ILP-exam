package com.web_exam.web_library.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stk_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "stk_bok_id", referencedColumnName = "bok_id")
    private Book book;


    @NotNull(message = "A quantidade não pode ser nula.")
    @Column(name = "stk_quantity")
    private Integer quantity;
}