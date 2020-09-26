
CREATE TABLE USER (
  ID INT NOT NULL AUTO_INCREMENT,
  USERNAME varchar(100) not null,
  PASSWORD varchar(100) not null,
  PRIMARY KEY (id)
);

CREATE TABLE ROLE (
  ID INT NOT NULL AUTO_INCREMENT,
  NAME varchar(100) NULL,
  PRIMARY KEY (id)
);

CREATE TABLE USER_ROLE
(
  ID INT NOT NULL AUTO_INCREMENT,
  USER_ID INT NOT NULL,
  ROLE_ID INT NOT NULL,
  PRIMARY KEY (id)
);

insert into USER (USERNAME, PASSWORD)
values ('user', 'password');

insert into USER (USERNAME, PASSWORD)
values ('admin', 'password');

insert into ROLE (NAME)
values ('USER');

insert into ROLE (NAME)
values ('ADMIN');

insert into USER_ROLE (USER_ID, ROLE_ID)
values (1, 1);

insert into USER_ROLE (USER_ID, ROLE_ID)
values (2, 2);