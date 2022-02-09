create table "user_detail" (
                           id bigserial constraint "user_detail_pk"
                               primary key not null ,
                           fam varchar(255),
                           im varchar(255),
                           ot varchar(255),
                           number_phone varchar(255)

);
comment on table "user_detail" is 'Детальная инфомрация о пользователях';
comment on column "user_detail".fam is 'Фамилия';
comment on column "user_detail".im is 'Имя';
comment on column "user_detail".ot is 'Отечество';
comment on column "user_detail".number_phone is 'Номертелефона';



