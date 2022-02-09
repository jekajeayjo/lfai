create table "user" (
                           id bigserial constraint "user_pk"
                               primary key not null ,
                           login varchar(255),
                           password varchar(255),
                           number_phone varchar(255),
                           mail varchar(255),
                           fk_role bigserial,
                           fk_user_detail bigserial

);
comment on table "user" is 'Пользователи(Логин,Пароль)';
comment on column "user".login is 'Логин';
comment on column "user".password is 'Пароль';
comment on column "user".number_phone is 'Номе телефона';
comment on column "user".fk_role is 'Тип роли';
comment on column "user".mail is 'Электронная почта';
comment on column "user".fk_user_detail is 'Детальная информация о пользователе';

alter table "user"
    add constraint "role_fk"
        foreign key (fk_role) references "ref_user_role_type" ;
alter table "user"
    add constraint "user_detail_fk"
        foreign key (fk_user_detail) references "user_detail" ;

