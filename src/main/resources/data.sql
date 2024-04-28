-- Populate Data to tables
INSERT INTO "user"(id, first_name, last_name)
values (1, 'Edmond', 'Zalinyan'),
       (2, 'Andranik', 'Dodoyan'),
       (3, 'Partev', 'Ghumashyan'),
       (4, 'Eduard', 'Aghajanyan'),
       (5, 'Vahagn', 'Baghumian'),
       (6, 'Arman', 'Vostanikyan'),
       (7, 'Rafael', 'Mkrtchyan'),
       (8, 'Narek', 'Otaryan'),
       (9, 'Mushegh', 'Zakaryan'),
       (10, 'Hayk', 'Melkonyan'),
       (11, 'Aram', 'Asatryan'),
       (12, 'Arkadi', 'Dumikyan');

INSERT INTO team(id, "name")
values (1, 'AUA'),
       (2, 'Shirakatsy'),
       (3, 'GhumDoZa'),
       (4, 'Kvartal');

INSERT INTO team_user(team_id, user_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (1, 7),
       (1, 8),
       (1, 9),
       (1, 10),
       (2, 1),
       (2, 2),
       (2, 4),
       (2, 5),
       (2, 6),
       (3, 1),
       (3, 2),
       (3, 3),
       (3, 10),
       (4, 3),
       (4, 8),
       (4, 9);

INSERT INTO project(id, "name", code, creator_id)
VALUES (1, 'Capstone', 'CPS', 10),
       (2, 'Kvartal''s project', 'KVP', 3),
       (3, 'Shirak', 'SH', 6),
       (4, 'AUA studies', 'AUA', 5);

INSERT INTO project_team(project_id, team_id)
VALUES (1, 3),
       (2, 4),
       (3, 2),
       (4, 1);