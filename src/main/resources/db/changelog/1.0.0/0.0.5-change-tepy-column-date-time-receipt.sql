ALTER TABLE receipt.receipt DROP COLUMN date_time;

ALTER TABLE receipt.receipt
    ADD date_time TIMESTAMP;