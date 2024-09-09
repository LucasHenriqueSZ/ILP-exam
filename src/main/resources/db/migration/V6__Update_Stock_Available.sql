UPDATE web_library.stock AS s
    JOIN (SELECT bok_id, COUNT(*) AS loan_count
          FROM web_library.loans
          WHERE lon_status = 'PENDING'
          GROUP BY bok_id) AS l ON s.stk_bok_id = l.bok_id
SET s.stk_available = s.stk_available - l.loan_count
WHERE s.stk_available >= l.loan_count;