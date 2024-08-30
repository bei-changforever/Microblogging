Create table if not exists user_account(
                                           user_id SERIAL NOT NULL  PRIMARY KEY,
                                           password varchar(100) Not NUll,
    username varchar(100) Not NUll,
    email varchar(100) Not NUll,
    role varchar(100)  NUll,
    enabled Boolean  NUll
    );

//-------------------------------
CREATE TABLE IF NOT EXISTS public.user_account
(
    user_id integer NOT NULL DEFAULT nextval('user_account_user_id_seq'::regclass),
    password character varying(100) COLLATE pg_catalog."default" NOT NULL,
    username character varying(100) COLLATE pg_catalog."default" NOT NULL,
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    role character varying(100) COLLATE pg_catalog."default",
    enabled boolean,
    CONSTRAINT user_account_pkey PRIMARY KEY (user_id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_account
    OWNER to postgres;