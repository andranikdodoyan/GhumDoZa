--Clear the Database
DROP TABLE IF EXISTS "team" CASCADE;
DROP TABLE IF EXISTS "user" CASCADE;
DROP TABLE IF EXISTS "team_user" CASCADE;
DROP TABLE IF EXISTS "project_user" CASCADE;
DROP TABLE IF EXISTS "project" CASCADE;
DROP TABLE IF EXISTS "project_team" CASCADE;
DROP TABLE IF EXISTS "ticket" CASCADE;
DROP TABLE IF EXISTS "comment" CASCADE;

--Create the Database
CREATE TABLE IF NOT EXISTS "user"
(
    id         UUID PRIMARY KEY,
    first_name VARCHAR,
    last_name  VARCHAR,
    "login"    VARCHAR,
    "password" VARCHAR
);

CREATE TABLE IF NOT EXISTS "project"
(
    id          UUID PRIMARY KEY,
    "name"      VARCHAR,
    code        VARCHAR UNIQUE,
    creator_id  UUID REFERENCES "user" (id),
    description VARCHAR
);

CREATE TABLE IF NOT EXISTS "ticket"
(
    id          UUID PRIMARY KEY,
    project_id  UUID REFERENCES project (id),
    serial_id   VARCHAR,
    "headline"  VARCHAR,
    body        VARCHAR,
    creator_id  UUID REFERENCES "user" (id),
    assignee_id UUID REFERENCES "user" (id),
    status      VARCHAR DEFAULT 'OPEN_DEV'
);

CREATE TABLE IF NOT EXISTS "team"
(
    id     UUID PRIMARY KEY,
    "name" VARCHAR
);

CREATE TABLE IF NOT EXISTS "project_team"
(
    id         UUID PRIMARY KEY,
    project_id UUID REFERENCES project (id),
    team_id    UUID REFERENCES team (id)
);

CREATE TABLE IF NOT EXISTS "team_user"
(
    id      UUID PRIMARY KEY,
    team_id UUID REFERENCES team (id),
    user_id UUID REFERENCES "user" (id),
    "role"  VARCHAR
);

CREATE TABLE IF NOT EXISTS "project_user"
(
    id         UUID PRIMARY KEY,
    project_id UUID REFERENCES project (id),
    user_id    UUID REFERENCES "user" (id),
    "role"     VARCHAR
);

CREATE TABLE IF NOT EXISTS "comment"
(
    id         UUID PRIMARY KEY,
    ticket_id  UUID REFERENCES ticket (id),
    body       VARCHAR,
    creator_id UUID REFERENCES "user" (id),
    created_at TIMESTAMP
);