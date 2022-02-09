create table "ref_catalog_type"
(
    id bigserial
        constraint "ref-catalog-type_pk"
            primary key,
    code varchar(255),
    name varchar(255)
);

comment on table "ref_catalog_type" is 'Типы ролей';
comment on column "ref_catalog_type".code is 'Код';
comment on column "ref_catalog_type".name is 'Наименование ';

