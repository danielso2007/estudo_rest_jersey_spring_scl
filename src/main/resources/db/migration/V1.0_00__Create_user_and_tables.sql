DO
$body$
BEGIN
   IF NOT EXISTS (
      SELECT *
      FROM   pg_catalog.pg_user
      WHERE  usename = 'scluser') THEN

      CREATE ROLE scluser LOGIN ENCRYPTED PASSWORD 'md5ab2a1669fb4c9f79636be77931c06c99' SUPERUSER CREATEDB CREATEROLE VALID UNTIL 'infinity' CONNECTION LIMIT -1;
      COMMENT ON ROLE scluser IS 'Usuário do sistema de cadastro de livros.';
   END IF;
END
$body$;

ALTER DATABASE scl OWNER TO scluser;

CREATE TABLE public.book(
   id bigserial NOT NULL, 
   author character varying(100) NOT NULL, 
   cover_url character varying(255), 
   description text NOT NULL,
   isbn character varying(45) NOT NULL, 
   status character varying(40) NOT NULL, 
   title character varying(100) NOT NULL, 
   total_page bigint NOT NULL, 
   year_published character varying(45) NOT NULL, 
   CONSTRAINT pk_book PRIMARY KEY (id), 
   CONSTRAINT const_uniq_title UNIQUE (title)
) WITH ( OIDS = FALSE );

ALTER TABLE public.book OWNER TO scluser;

COMMENT ON TABLE public.book IS 'Tabela de livros';