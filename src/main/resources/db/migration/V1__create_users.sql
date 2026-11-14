CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    telegram_id BIGINT NOT NULL UNIQUE,
    user_name VARCHAR(256)
);
