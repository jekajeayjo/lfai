create table "ref_user_status"
(
    id bigserial
        constraint "ref_user_status_pk"
            primary key,
    code varchar(255),
    name varchar(255)
);

comment on table "ref_user_status" is 'Типы статусов';
comment on column "ref_user_status".code is 'Код статуса';
comment on column "ref_user_status".name is 'Наименование ';

