--Clear the Database
DROP TABLE IF EXISTS "team" CASCADE;
DROP TABLE IF EXISTS "user" CASCADE;
DROP TABLE IF EXISTS "team_user" CASCADE;
DROP TABLE IF EXISTS "project" CASCADE;
DROP TABLE IF EXISTS "project_team" CASCADE;
DROP TABLE IF EXISTS "ticket" CASCADE;

--Create the Database
CREATE TABLE IF NOT EXISTS "user"
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR,
    last_name  VARCHAR
);

CREATE TABLE IF NOT EXISTS "project"
(
    id         SERIAL PRIMARY KEY,
    "name"     VARCHAR,
    code       VARCHAR,
    creator_id BIGINT REFERENCES "user" (id)
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

CREATE TABLE IF NOT EXISTS "team"
(
    id     SERIAL PRIMARY KEY,
    "name" VARCHAR
);

CREATE TABLE IF NOT EXISTS "project_team"
(
    project_id BIGINT REFERENCES project (id),
    team_id    BIGINT REFERENCES team (id)
);

CREATE TABLE IF NOT EXISTS "team_user"
(
    team_id BIGINT REFERENCES team (id),
    user_id BIGINT REFERENCES "user" (id),
    role    VARCHAR
);