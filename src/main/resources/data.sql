-- Populate Data to tables
INSERT INTO "user"(id, first_name, last_name)
values ('fbb63c65-270e-4da6-bfb8-8ee67e560c4d', 'Edmond', 'Zalinyan'),
       ('b293084a-1fe1-458b-8218-bcdccf1418f5', 'Andranik', 'Dodoyan'),
       ('b0d3c291-fccd-4c69-a62f-d70836e4ef12', 'Partev', 'Ghumashyan'),
       ('34ecf170-8715-446b-8264-daefcc097ded', 'Eduard', 'Aghajanyan'),
       ('5bf16ecb-e5df-4b9b-85ca-f442dd692082', 'Vahagn', 'Baghumian'),
       ('a6cac03a-fe57-493b-a323-52d34e7989f7', 'Arman', 'Vostanikyan'),
       ('69194f3c-273d-4948-923d-06e532122361', 'Rafael', 'Mkrtchyan'),
       ('b032cf45-fcba-43b9-b2ae-fe0802762c49', 'Narek', 'Otaryan'),
       ('3adf2ea9-f3c4-4018-938b-361734f6938a', 'Mushegh', 'Zakaryan'),
       ('0a8ba285-0558-4e7b-85fd-b32b8b1c2a4f', 'Hayk', 'Melkonyan');

INSERT INTO team(id, "name")
values ('efdc3ab6-a454-48ef-a287-0c933eb0d5de', 'AUA'),
       ('d6c545a1-32cb-4034-a74b-1e11c51658ce', 'Shirakatsy'),
       ('93802199-17ab-4cea-8b70-5e783480ef52', 'GhumDoZa'),
       ('2296fbc1-90ab-49b8-8043-470af3015e79', 'Kvartal');

INSERT INTO team_user(team_id, user_id)
VALUES ('efdc3ab6-a454-48ef-a287-0c933eb0d5de', 'fbb63c65-270e-4da6-bfb8-8ee67e560c4d'),
       ('efdc3ab6-a454-48ef-a287-0c933eb0d5de', 'b293084a-1fe1-458b-8218-bcdccf1418f5'),
       ('efdc3ab6-a454-48ef-a287-0c933eb0d5de', 'b0d3c291-fccd-4c69-a62f-d70836e4ef12'),
       ('efdc3ab6-a454-48ef-a287-0c933eb0d5de', '34ecf170-8715-446b-8264-daefcc097ded'),
       ('efdc3ab6-a454-48ef-a287-0c933eb0d5de', '5bf16ecb-e5df-4b9b-85ca-f442dd692082'),
       ('efdc3ab6-a454-48ef-a287-0c933eb0d5de', 'a6cac03a-fe57-493b-a323-52d34e7989f7'),
       ('efdc3ab6-a454-48ef-a287-0c933eb0d5de', '69194f3c-273d-4948-923d-06e532122361'),
       ('efdc3ab6-a454-48ef-a287-0c933eb0d5de', 'b032cf45-fcba-43b9-b2ae-fe0802762c49'),
       ('efdc3ab6-a454-48ef-a287-0c933eb0d5de', '3adf2ea9-f3c4-4018-938b-361734f6938a'),
       ('efdc3ab6-a454-48ef-a287-0c933eb0d5de', '0a8ba285-0558-4e7b-85fd-b32b8b1c2a4f'),
       ('d6c545a1-32cb-4034-a74b-1e11c51658ce', 'fbb63c65-270e-4da6-bfb8-8ee67e560c4d'),
       ('d6c545a1-32cb-4034-a74b-1e11c51658ce', 'b293084a-1fe1-458b-8218-bcdccf1418f5'),
       ('d6c545a1-32cb-4034-a74b-1e11c51658ce', '34ecf170-8715-446b-8264-daefcc097ded'),
       ('d6c545a1-32cb-4034-a74b-1e11c51658ce', '5bf16ecb-e5df-4b9b-85ca-f442dd692082'),
       ('d6c545a1-32cb-4034-a74b-1e11c51658ce', 'a6cac03a-fe57-493b-a323-52d34e7989f7'),
       ('93802199-17ab-4cea-8b70-5e783480ef52', 'fbb63c65-270e-4da6-bfb8-8ee67e560c4d'),
       ('93802199-17ab-4cea-8b70-5e783480ef52', 'b293084a-1fe1-458b-8218-bcdccf1418f5'),
       ('93802199-17ab-4cea-8b70-5e783480ef52', 'b0d3c291-fccd-4c69-a62f-d70836e4ef12'),
       ('93802199-17ab-4cea-8b70-5e783480ef52', '0a8ba285-0558-4e7b-85fd-b32b8b1c2a4f'),
       ('2296fbc1-90ab-49b8-8043-470af3015e79', 'b0d3c291-fccd-4c69-a62f-d70836e4ef12'),
       ('2296fbc1-90ab-49b8-8043-470af3015e79', 'b032cf45-fcba-43b9-b2ae-fe0802762c49'),
       ('2296fbc1-90ab-49b8-8043-470af3015e79', '3adf2ea9-f3c4-4018-938b-361734f6938a');

INSERT INTO project(id, "name", code, creator_id)
VALUES ('0d4a3a6f-021c-4b7b-b342-6f78589b5564', 'Capstone', 'CPS', '0a8ba285-0558-4e7b-85fd-b32b8b1c2a4f'),
       ('bd09feb2-156b-4d7a-972d-ce83a2ecd228', 'Kvartal''s project', 'KVP', 'b0d3c291-fccd-4c69-a62f-d70836e4ef12'),
       ('2742ca8f-9b6d-4950-8a0b-ce47bc1fb833', 'Shirak', 'SH', 'a6cac03a-fe57-493b-a323-52d34e7989f7'),
       ('d6ecf171-ba66-4271-bbbe-499c17628bbf', 'AUA studies', 'AUA', '5bf16ecb-e5df-4b9b-85ca-f442dd692082');

INSERT INTO project_team(project_id, team_id)
VALUES ('0d4a3a6f-021c-4b7b-b342-6f78589b5564', '93802199-17ab-4cea-8b70-5e783480ef52'),
       ('bd09feb2-156b-4d7a-972d-ce83a2ecd228', '2296fbc1-90ab-49b8-8043-470af3015e79'),
       ('2742ca8f-9b6d-4950-8a0b-ce47bc1fb833', 'd6c545a1-32cb-4034-a74b-1e11c51658ce'),
       ('d6ecf171-ba66-4271-bbbe-499c17628bbf', 'efdc3ab6-a454-48ef-a287-0c933eb0d5de');

INSERT INTO ticket(id, project_id, serial_id, headline, body, creator_id, assignee_id)
VALUES ('9187d91e-4792-4589-ac15-fcbc13570459', '0d4a3a6f-021c-4b7b-b342-6f78589b5564', 1,
        'First ever ticket''s headline', 'the body of the ticket', 'fbb63c65-270e-4da6-bfb8-8ee67e560c4d',
        'b293084a-1fe1-458b-8218-bcdccf1418f5');