CREATE TABLE receipt.meta_data
(
    id           UUID NOT NULL,
    ofd_id       VARCHAR,
    address      VARCHAR,
    subtype      VARCHAR,
    receive_date VARCHAR,
    CONSTRAINT pk_meta_data PRIMARY KEY (id)
);

CREATE TABLE receipt.receipt
(
    id                         UUID NOT NULL,
    code                       FLOAT,
    usr                        VARCHAR,
    nds10                      FLOAT,
    nds18                      FLOAT,
    nds0                       FLOAT,
    ndsNo                      FLOAT,
    fns_url                    VARCHAR,
    region                     VARCHAR,
    user_inn                   VARCHAR,
    date_time                  VARCHAR,
    kkt_reg_id                 VARCHAR,
    metadata_id                UUID,
    operator                   VARCHAR,
    total_sum                  FLOAT,
    credit_sum                 FLOAT,
    number_kkt                 VARCHAR,
    fiscal_sign                FLOAT,
    prepaid_sum                FLOAT,
    retail_place               VARCHAR,
    shift_number               FLOAT,
    cash_total_sum             FLOAT,
    provision_sum              FLOAT,
    ecash_total_sum            FLOAT,
    operation_type             FLOAT,
    redefine_mask              FLOAT,
    request_number             FLOAT,
    fiscal_drive_number        VARCHAR,
    message_fiscal_sign        FLOAT,
    retail_place_address       VARCHAR,
    applied_taxation_type      FLOAT,
    fiscal_document_number     FLOAT,
    fiscal_document_format_ver FLOAT,
    CONSTRAINT pk_receipt PRIMARY KEY (id)
);

comment
on column receipt.receipt.code is 'код документа «Кассовый чек» всегда равен «3», код «БСО» — «4»';
  comment
on column receipt.receipt.retail_place_address is	'адрес расчетов';
  comment
on column receipt.receipt.date_time is 'дата, время';
  comment
on column receipt.receipt.user_inn is 'ИНН пользователя';
  comment
on column receipt.receipt.operator is 'кассир';
  comment
on column receipt.receipt.total_sum is 'ИТОГ';
  comment
on column receipt.receipt.cash_total_sum is 'форма расчета — наличными';
  comment
on column receipt.receipt.kkt_reg_id is 'регистрационный номер ККТ';
  comment
on column receipt.receipt.shift_number is 'номер смены';
  comment
on column receipt.receipt.fiscal_document_number is 'порядковый номер фискального документа';
  comment
on column receipt.receipt.fiscal_drive_number is 'заводской номер фискального накопителя';
  comment
on column receipt.receipt.request_number	is 'номер чека за смену';
  comment
on column receipt.receipt.usr is 'наименование пользователя';
  comment
on column receipt.receipt.operation_type	is 'признак расчета';
  comment
on column receipt.receipt.applied_taxation_type is 'применяемая система налогообложения';
--   comment
-- on column receipt.receipt.items	is 'предметы расчета	Array[объект]';
  comment
on column receipt.receipt.fns_url is	'адрес сайта ФНС';
  comment
on column receipt.receipt.fiscal_sign is	'фискальный признак документа';
  comment
on column receipt.receipt.ecash_total_sum	is 'форма расчета — электронными';
  comment
on column receipt.receipt.nds18	is 'НДС итога чека со ставкой 18%';
  comment
on column receipt.receipt.nds10 is 'НДС итога чека со ставкой 10%';
  comment
on column receipt.receipt.nds0	is 'НДС итога чека со ставкой 0%';
  comment
on column receipt.receipt.ndsNo	is 'сумма расчета по чеку без НДС';
  comment
on column receipt.receipt.retail_place is 'место расчетов';
  comment
on column receipt.receipt.fiscal_document_format_ver is 'номер версии ФФД';
  comment
on column receipt.receipt.prepaid_sum is 'сумма по чеку (БСО) предоплатой (зачетом аванса и (или) предыдущих платежей)';
  comment
on column receipt.receipt.credit_sum	 is 'сумма по чеку (БСО) постоплатой (в кредит)';
  comment
on column receipt.receipt.credit_sum	 is 'сумма по чеку (БСО) постоплатой (в кредит)';
  comment
on column receipt.receipt.provision_sum	is 'сумма по чеку (БСО) встречным предоставлением';

ALTER TABLE receipt.receipt
    ADD CONSTRAINT FK_RECEIPT_ON_METADATA FOREIGN KEY (metadata_id) REFERENCES receipt.meta_data (id);

-- rollback DROP TABLE receipt.meta_data;
-- rollback DROP TABLE receipt.receipt;