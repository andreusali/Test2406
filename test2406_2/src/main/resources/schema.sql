
drop table if exists book;
drop table if exists author;

CREATE TABLE BOOK (
	id bigint not null,
	TITLE VARCHAR(255) not null);


CREATE TABLE AUTHOR (
	id bigint not null,
	name VARCHAR(255) not null,
	PRIMARY KEY (ID));