ALTER TABLE receipt.receipt
    RENAME COLUMN ecash_total_sum TO e_cash_total_sum;

COMMENT
ON COLUMN receipt.receipt.e_cash_total_sum	IS 'форма расчета — электронными';