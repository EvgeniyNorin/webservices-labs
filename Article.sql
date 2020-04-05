CREATE USER myuser WITH PASSWORD 'mypass';
CREATE DATABASE mydb WITH OWNER=myuser;

INSERT INTO public.article (article_id, author_id, h_index, article_name, article_desc, date_added)
VALUES (1, 'authordId', 1, 'articleName', 'articleDesc', 1);

INSERT INTO public.article (article_id, author_id, h_index, article_name, article_desc, date_added)
VALUES (2, 'authordId2', 2, 'articleName2', 'articleDesc2', 2);

INSERT INTO public.article (article_id, author_id, h_index, article_name, article_desc, date_added)
VALUES (3, 'authordId3', 3, 'articleName3', 'articleDesc3', 3);

CREATE TABLE Article
(
    article_id   bigserial primary key,
    author_id    varchar NOT NULL,
    h_index      BIGINT  NOT NULL,
    article_name varchar NOT NULL,
    article_desc varchar NOT NULL,
    date_added   BIGINT  NOT NULL
);