insert into T_ADDRESS (STREET,HOUSE_NUMBER, CITY, POST_CODE, COUNTRY) values ('Princsengracht', '1', 'Amsterdam', '1100AA', 'Netherlands');
insert into T_ADDRESS (STREET,HOUSE_NUMBER, CITY, POST_CODE, COUNTRY) values ('Steenwijkweg', '4', 'Zwolle', '8700AA', 'Netherlands');
insert into T_ADDRESS (STREET,HOUSE_NUMBER, CITY, POST_CODE, COUNTRY) values ('Oxford St.', '78', 'London', 'W1 8QP', 'England');

insert into T_PARTNER (BSN) values ('42');
insert into T_PARTNER (BSN) values ('66');
insert into T_PARTNER (BSN) values ('43');
insert into T_PARTNER (BSN) values ('67');

insert into T_USER (BSN, SURNAME, FIRST_NAME, DATE_OF_BIRTH, PARTNER_ID, ADDRESS_ID) values ('123456789', 'De Jong', 'Jack', '1963-03-04', 0, 0);
insert into T_USER (BSN, SURNAME, FIRST_NAME, DATE_OF_BIRTH, PARTNER_ID, ADDRESS_ID) values ('47', 'De Jong', 'Jill', '1959-03-05', 1, 1);
insert into T_USER (BSN, SURNAME, FIRST_NAME, DATE_OF_BIRTH, PARTNER_ID, ADDRESS_ID) values ('48', 'De Jong', 'Jane', '1959-03-05', 2, 2);

