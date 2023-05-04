CREATE TABLE receipt.item
(
    id                     UUID NOT NULL,
    nds                    BIGINT,
    sum                    BIGINT,
    name                   VARCHAR(255),
    price                  BIGINT,
    nds_sum                BIGINT,
    quantity               BIGINT,
    payment_type           INTEGER,
    product_type           INTEGER,
    properties_item        VARCHAR(255),
    items_quantity_measure INTEGER,
    CONSTRAINT pk_item PRIMARY KEY (id)
);
comment
on table receipt.item is 'Временное хранилище чеков';
comment
on column receipt.item.id is 'Идентификатор';
comment
on column receipt.item.quantity is 'количество';
comment
on column receipt.item.name is 'наименование товара';
comment
on column receipt.item.sum is 'стоимость предмета расчета с учетом скидок и наценок';
comment
on column receipt.item.price is 'цена за единицу';
comment
on column receipt.item.properties_item is 'дополнительный реквизит предмета расчета';
comment
on column receipt.item.nds is 'ставка НДС';
comment
on column receipt.item.nds_sum is 'сумма НДС за предмет расчета';
comment
on column receipt.item.product_type is 'признак предмета расчета';
comment
on column receipt.item.payment_type is 'признак способа расчета';
comment
on column receipt.item.items_quantity_measure is 'единица измерения предмета расчета';

-- rollback DROP TABLE receipt.item;