drop table T_USER if exists;
drop table T_PARTNER if exists;

create table T_USER (ID integer identity primary key, BSN varchar(9), SURNAME varchar(50),  FIRST_NAME varchar(50) not null, DATE_OF_BIRTH date, PARTNER_ID integer);
create table T_PARTNER (ID integer identity primary key, BSN varchar(9));
