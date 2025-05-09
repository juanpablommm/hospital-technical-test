-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id serial NOT NULL,
	email varchar(50) NOT NULL,
	fullname varchar(500) NOT NULL,
	password varchar(500) NOT NULL,
	age varchar NOT NULL,
	CONSTRAINT email_unique UNIQUE (email),
	CONSTRAINT users_pk PRIMARY KEY (id),
	CONSTRAINT users_unique UNIQUE (fullname)
);
