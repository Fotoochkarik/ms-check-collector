ALTER TABLE receipt.receipt
    ADD CONSTRAINT uk_date_total_sum_receipt UNIQUE (date_time, total_sum);