 CREATE TABLE public.personen
(
    pers_id integer NOT NULL,
    nachname text COLLATE pg_catalog."default",
    vorname text COLLATE pg_catalog."default",
    rolle text COLLATE pg_catalog."default",
    CONSTRAINT com_monitoring_telegrams_pkey PRIMARY KEY (pers_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.personen
    OWNER to q450811;


CREATE TABLE public."Tasks"
(
    task_id integer NOT NULL,
    description character varying COLLATE pg_catalog."default",
    "createDate" date,
    "startDate" date,
    "completeDate" date,
    "assignedPersonId" integer,
    status character varying COLLATE pg_catalog."default",
    "deleteFlag" character varying COLLATE pg_catalog."default",
    CONSTRAINT "Tasks_pkey" PRIMARY KEY (task_id),
    CONSTRAINT "assignedPersonId" FOREIGN KEY ("assignedPersonId")
        REFERENCES public.personen (pers_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Tasks"
    OWNER to q450811;