create table "ref_user_role_type"
(
    id bigserial
        constraint "ref-user-type_pk"
            primary key,
    code varchar(255),
    name varchar(255)
);

comment on table "ref_user_role_type" is 'Типы ролей';
comment on column "ref_user_role_type".code is 'Код роли';
comment on column "ref_user_role_type".name is 'Наименование ';

