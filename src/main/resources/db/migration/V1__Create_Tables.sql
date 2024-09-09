CREATE TABLE IF NOT EXISTS web_library.books
(
    bok_id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    bok_author           VARCHAR(255)  NOT NULL,
    bok_description      VARCHAR(1000) NULL,
    bok_gender           VARCHAR(100)  NOT NULL,
    bok_isbn             VARCHAR(255)  NOT NULL,
    bok_publication_date DATE          NOT NULL,
    bok_title            VARCHAR(255)  NOT NULL
    );

CREATE TABLE IF NOT EXISTS web_library.loans
(
    lon_id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    lon_borrower_cpf  VARCHAR(255)                 NULL,
    lon_borrower_name VARCHAR(255)                 NOT NULL,
    lon_due_date      DATE                         NOT NULL,
    lon_date          DATE                         NULL,
    lon_price         DOUBLE                       NOT NULL,
    lon_return_date   DATE                         NULL,
    lon_status        ENUM ('PENDING', 'RETURNED') NULL,
    bok_id            BIGINT                       NOT NULL,
    CONSTRAINT FK_loans_books FOREIGN KEY (bok_id) REFERENCES web_library.books (bok_id)
    );

CREATE TABLE IF NOT EXISTS web_library.stock
(
    stk_id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    stk_available INT    NULL,
    stk_quantity  INT    NOT NULL,
    stk_bok_id    BIGINT NULL,
    CONSTRAINT UQ_stock_bok_id UNIQUE (stk_bok_id),
    CONSTRAINT FK_stock_books FOREIGN KEY (stk_bok_id) REFERENCES web_library.books (bok_id)
    );
