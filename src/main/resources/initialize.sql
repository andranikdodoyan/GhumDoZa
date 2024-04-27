DROP TABLE IF EXISTS "user";
DROP TABLE IF EXISTS "project";
DROP TABLE IF EXISTS "ticket";

CREATE TABLE IF NOT EXISTS "user"
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR,
    last_name  VARCHAR,
    "role"     VARCHAR
);

CREATE TABLE IF NOT EXISTS "project"
(
    id     SERIAL PRIMARY KEY,
    "name" VARCHAR,
    code   VARCHAR
);

CREATE TABLE IF NOT EXISTS "ticket"
(
    id          SERIAL PRIMARY KEY,
    project_id  BIGINT REFERENCES project (id),
    serial_id   VARCHAR,
    "headline"  VARCHAR,
    body        VARCHAR,
    creator_id  BIGINT REFERENCES "user" (id),
    assignee_id BIGINT REFERENCES "user" (id)
);