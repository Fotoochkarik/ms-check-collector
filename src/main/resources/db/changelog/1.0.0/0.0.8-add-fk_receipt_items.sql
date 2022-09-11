ALTER TABLE receipt.item
    ADD COLUMN receipt_id UUID;
ALTER TABLE receipt.item
    ADD CONSTRAINT FK_ITEM_ON_RECEIPT FOREIGN KEY (receipt_id) REFERENCES receipt.receipt (id);