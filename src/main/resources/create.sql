-- Table: public.user_account

-- DROP TABLE IF EXISTS public.user_account;

CREATE TABLE IF NOT EXISTS public.user_account
(
    user_id integer NOT NULL DEFAULT nextval('user_account_user_id_seq'::regclass),
    password character varying(100) COLLATE pg_catalog."default" NOT NULL,
    username character varying(100) COLLATE pg_catalog."default" NOT NULL,
    email character varying(100) COLLATE pg_catalog."default",
    role character varying(100) COLLATE pg_catalog."default",
    enabled boolean,
    CONSTRAINT user_account_pkey PRIMARY KEY (user_id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_account
    OWNER to postgres;


//------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS public.comment
(
    comment_id integer NOT NULL DEFAULT nextval('user_account_user_id_seq'::regclass) PRIMARY KEY,
    commenter character varying(100) COLLATE pg_catalog."default" NOT NULL,
    comment_info character varying(100) COLLATE pg_catalog."default" NOT NULL,
    comment_time DATE  NULL,
    user_id integer NULL ,
    FOREIGN KEY (user_id) REFERENCES user_account(user_id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_account
    OWNER to postgres;