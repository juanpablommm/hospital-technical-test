-- DROP TYPE public.specialityenum;

CREATE TYPE public.speciality AS ENUM (
	'DERMATOLOGIA',
	'GINECOLOGIA',
	'ODONTOLOGIA',
	'OTORRINOLARINGOLOGIA',
	'MEDICO_GENERAL',
	'PEDIATRIA');


-- public.doctor definition

-- Drop table

-- DROP TABLE public.doctor;

CREATE TABLE public.doctors (
	id serial4 NOT NULL,
	full_name varchar NOT NULL,
	speciality public.speciality NOT NULL,
	CONSTRAINT doctor_pk PRIMARY KEY (id),
	CONSTRAINT doctor_unique UNIQUE (full_name)
);
