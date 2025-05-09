-- public.quotes definition

-- Drop table

-- DROP TABLE public.quotes;

CREATE TABLE public.quotes (
	"date" timestamp NOT NULL,
	id serial4 NOT NULL,
	is_cancel bool NOT NULL,
	id_user int4 NOT NULL,
	id_doctor int4 NOT NULL,
	description text NOT NULL,
	CONSTRAINT quotes_pk PRIMARY KEY (id)
);


-- public.quotes foreign keys

ALTER TABLE public.quotes ADD CONSTRAINT quotes_doctor_fk FOREIGN KEY (id_doctor) REFERENCES public.doctor(id);
ALTER TABLE public.quotes ADD CONSTRAINT quotes_users_fk FOREIGN KEY (id_user) REFERENCES public.users(id);
