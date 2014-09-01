drop table T_USER if exists;
drop table T_PARTNER if exists;
drop table T_ADDRESS if exists;


create table T_USER (ID integer identity primary key, BSN varchar(9), SURNAME varchar(50),  FIRST_NAME varchar(50) not null, DATE_OF_BIRTH date, PARTNER_ID integer, ADDRESS_ID integer);
create table T_PARTNER (ID integer identity primary key, BSN varchar(9));
create table T_ADDRESS (ID integer identity primary key, STREET varchar(50), HOUSE_NUMBER varchar(10), CITY varchar(50), POST_CODE varchar(10), COUNTRY varchar(50));
