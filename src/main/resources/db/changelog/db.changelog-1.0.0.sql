--liquibase formatted sql

create table company (
	id						numeric NOT NULL PRIMARY KEY,
	name				varchar(100),
	created_on				timestamp DEFAULT timezone('utc', now()),					
	updated_on				timestamp
);

create table employee (
	id						numeric NOT NULL PRIMARY KEY,
	name				varchar(100),
  company_id		numeric NOT NULL, 
	created_on				timestamp DEFAULT timezone('utc', now()),					
	updated_on				timestamp
);