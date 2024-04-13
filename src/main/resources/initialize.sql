DROP TABLE IF EXISTS "user";
CREATE TABLE IF NOT EXISTS "user"
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR,
    last_name   VARCHAR,
    "role"     VARCHAR
);