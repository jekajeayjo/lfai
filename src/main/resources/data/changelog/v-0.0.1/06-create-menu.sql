create table "menu"
(
    id             bigserial
        constraint "menu_pk"
            primary key not null,
    name          varchar(255),
    description       varchar(255),
    icon   varchar(255),
    url           varchar(255),
    parent_id        bigserial



);
comment
on table "user" is 'Пользователи(Логин,Пароль)';
comment
on column "user".login is 'Логин';
comment
on column "user".password is 'Пароль';
comment
on column "user".number_phone is 'Номе телефона';
comment
on column "user".fk_role is 'Тип роли';
comment
on column "user".mail is 'Электронная почта';
comment
on column "user".fk_user_detail is 'Детальная информация о пользователе';
comment
on column "user".status is 'Статус пользователя';
alter table "menu"
    add constraint "menu_fk"
        foreign key (parent_id) references "menu";


