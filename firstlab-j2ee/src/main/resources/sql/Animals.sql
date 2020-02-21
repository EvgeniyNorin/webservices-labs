CREATE TABLE ARTICLE
(
  article_id   bigserial primary key,
  author_id    varchar NOT NULL,
  h_index      BIGINT  NOT NULL,
  article_name varchar NOT NULL,
  article_desc varchar NOT NULL,
  date_added   BIGINT  NOT NULL
);