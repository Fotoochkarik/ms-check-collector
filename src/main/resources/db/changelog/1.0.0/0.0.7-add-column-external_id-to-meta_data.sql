ALTER TABLE receipt.meta_data
    ADD external_id BIGINT;

COMMENT
ON COLUMN receipt.meta_data.external_id IS 'Внешний индетификатор мета данных';