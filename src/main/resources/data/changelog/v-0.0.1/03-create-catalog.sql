create table "catalog" (
                                     id bigserial constraint "catalog_pk"
                                         primary key not null ,
                                     name varchar(255),
                                     price bigserial,
                                     description varchar(255),
                                     fk_catalog_type bigserial

);
comment on table "catalog" is 'Товары';
comment on column "catalog".fk_catalog_type is 'Тип товара';
comment on column "catalog".name is 'Наименование';
comment on column "catalog".description is 'Описание';

alter table "catalog"
    add constraint "catalog_type_fk"
        foreign key (fk_catalog_type) references "ref_catalog_type" ;

