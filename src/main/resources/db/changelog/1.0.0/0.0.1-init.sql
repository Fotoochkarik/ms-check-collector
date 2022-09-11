CREATE TABLE receipt.receipt_temp
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data    TEXT,
    created TIMESTAMP WITHOUT TIME ZONE,
    request VARCHAR(255),
    CONSTRAINT pk_receipt_temp PRIMARY KEY (id)
);
comment
on table receipt.receipt_temp is 'Временное хранилище чеков';
comment
on column receipt.receipt_temp.id is 'Идентификатор';
comment
on column receipt.receipt_temp.data is 'Данные полученные с запроса';
comment
on column receipt.receipt_temp.created is 'Дата запроса';
comment
on column receipt.receipt_temp.request is 'Запрос';

ALTER TABLE receipt.receipt_temp
    ADD CONSTRAINT uc_request UNIQUE (request);

-- rollback DROP TABLE receipt.receipt_temp;