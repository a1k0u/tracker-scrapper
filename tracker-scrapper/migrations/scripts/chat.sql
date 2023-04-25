--liquibase formatted sql
--changeset alkosenko:chat
CREATE TABLE IF NOT EXISTS chat (
    id INTEGER PRIMARY KEY
);