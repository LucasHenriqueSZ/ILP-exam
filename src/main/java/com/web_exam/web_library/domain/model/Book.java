package com.web_exam.web_library.domain.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bok_id")
    private Long id;

    @NotBlank(message = "O título não pode estar em branco.")
    @Size(max = 255, message = "O título não pode ter mais de 255 caracteres.")
    @Column(name = "bok_title")
    private String title;

    @NotBlank(message = "O autor não pode estar em branco.")
    @Size(max = 255, message = "O autor não pode ter mais de 255 caracteres.")
    @Column(name = "bok_author")
    private String author;

    @NotBlank(message = "O gênero não pode estar em branco.")
    @Size(max = 100, message = "O gênero não pode ter mais de 100 caracteres.")
    @Column(name = "bok_gender")
    private String gender;

    @Size(max = 1000, message = "A descrição não pode ter mais de 1000 caracteres.")
    @Column(name = "bok_description")
    private String description;

    @NotBlank(message = "O ISBN não pode estar em branco.")
    @Pattern(regexp = "\\d{3}-\\d-\\d{2}-\\d{6}-\\d|\\d{13}", message = "O ISBN fornecido é inválido.")
    @Column(name = "bok_isbn")
    private String isbn;

    @NotNull(message = "A data de publicação não pode ser nula.")
    @PastOrPresent(message = "A data de publicação não pode estar no futuro.")
    @Column(name = "bok_publication_date")
    private LocalDate publicationDate;

    @Valid
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Stock stock;
}
