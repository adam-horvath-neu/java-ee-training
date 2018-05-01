CREATE TABLE public.t_user (
	username varchar NULL,
	password varchar NULL,
	firstname varchar NULL,
	lastname varchar NULL,
	email varchar NULL,
	phone varchar NULL,
	id serial NOT NULL
)
WITH (
	OIDS=FALSE
) ;