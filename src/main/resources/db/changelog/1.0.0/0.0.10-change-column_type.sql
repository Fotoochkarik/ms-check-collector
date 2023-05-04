-- liquibase formatted sql
-- changeset Fotoochkarik:0.0.10-change-column_type.sql

ALTER TABLE receipt.item ALTER COLUMN nds TYPE DOUBLE PRECISION;
-- rollback ALTER TABLE receipt.item ALTER COLUMN nds TYPE BIGINT;

ALTER TABLE receipt.item ALTER COLUMN sum TYPE DOUBLE PRECISION;
-- rollback ALTER TABLE receipt.item ALTER COLUMN sum TYPE BIGINT;

ALTER TABLE receipt.item ALTER COLUMN price TYPE DOUBLE PRECISION;
-- rollback ALTER TABLE receipt.item ALTER COLUMN price TYPE BIGINT;

ALTER TABLE receipt.item ALTER COLUMN nds_sum TYPE DOUBLE PRECISION;
-- rollback ALTER TABLE receipt.item ALTER COLUMN nds_sum TYPE BIGINT;

ALTER TABLE receipt.meta_data ALTER COLUMN receive_date TYPE TIMESTAMP with time zone USING receive_date::timestamp with time zone;
-- rollback ALTER TABLE receipt.meta_data ALTER COLUMN receive_date TYPE VARCHAR;