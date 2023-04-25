--liquibase formatted sql
--changeset alkosenko:link
CREATE TABLE IF NOT EXISTS link (
    id SERIAL PRIMARY KEY,
    url TEXT NOT NULL,
    ref INTEGER
);