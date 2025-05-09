-- DROP TYPE public.specialityenum;

CREATE TYPE public.specialityenum AS ENUM (
	'DERMATOLOGIA',
	'GINECOLOGÍA',
	'ODONTOLOGÍA',
	'OTORRINOLARINGOLOGÍA');


-- public.doctor definition

-- Drop table

-- DROP TABLE public.doctor;

CREATE TABLE public.doctor (
	id serial4 NOT NULL,
	fullname varchar NOT NULL,
	speciality public.specialityenum NOT NULL,
	CONSTRAINT doctor_pk PRIMARY KEY (id),
	CONSTRAINT doctor_unique UNIQUE (fullname)
);
