--liquibase formatted sql
--changeset alkosenko:user_link
CREATE TABLE IF NOT EXISTS user_link (
    id SERIAL PRIMARY KEY,
    chat_id INTEGER,
    link_id INTEGER,

    FOREIGN KEY (chat_id) REFERENCES chat (id) ON DELETE CASCADE,
    FOREIGN KEY (link_id) REFERENCES link (id) ON DELETE CASCADE
);
