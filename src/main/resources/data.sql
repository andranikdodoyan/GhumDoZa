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

INSERT INTO team_user(id, team_id, user_id)
VALUES ('65dc404f-cf68-46fb-832d-79760cf3620b', 'efdc3ab6-a454-48ef-a287-0c933eb0d5de',
        'fbb63c65-270e-4da6-bfb8-8ee67e560c4d'),
       ('0b131b9c-5e05-4b79-ad86-73f29e4d1544', 'efdc3ab6-a454-48ef-a287-0c933eb0d5de',
        'b293084a-1fe1-458b-8218-bcdccf1418f5'),
       ('7e2dc2cf-aeb6-4d93-8625-259f7de1a7b2', 'efdc3ab6-a454-48ef-a287-0c933eb0d5de',
        'b0d3c291-fccd-4c69-a62f-d70836e4ef12'),
       ('3865971f-42ee-4f34-901b-1ac33f77a168', 'efdc3ab6-a454-48ef-a287-0c933eb0d5de',
        '34ecf170-8715-446b-8264-daefcc097ded'),
       ('c76d9ea4-b6b7-4ac9-8b88-754b5aa32f2f', 'efdc3ab6-a454-48ef-a287-0c933eb0d5de',
        '5bf16ecb-e5df-4b9b-85ca-f442dd692082'),
       ('b13096b8-1d11-4ee5-8fbc-877abf8a86c0', 'efdc3ab6-a454-48ef-a287-0c933eb0d5de',
        'a6cac03a-fe57-493b-a323-52d34e7989f7'),
       ('c0455b16-fca0-44c5-b7cb-0568b331ef77', 'efdc3ab6-a454-48ef-a287-0c933eb0d5de',
        '69194f3c-273d-4948-923d-06e532122361'),
       ('a1202d57-33b6-467b-86f8-4e6f23654786', 'efdc3ab6-a454-48ef-a287-0c933eb0d5de',
        'b032cf45-fcba-43b9-b2ae-fe0802762c49'),
       ('d91b2e28-f23c-4743-9d15-ec85d825f52a', 'efdc3ab6-a454-48ef-a287-0c933eb0d5de',
        '3adf2ea9-f3c4-4018-938b-361734f6938a'),
       ('15e993b3-93e3-4fa6-aa05-37a03248741f', 'efdc3ab6-a454-48ef-a287-0c933eb0d5de',
        '0a8ba285-0558-4e7b-85fd-b32b8b1c2a4f'),
       ('1e0677c6-d627-4573-be5a-91aa0d7094de', 'd6c545a1-32cb-4034-a74b-1e11c51658ce',
        'fbb63c65-270e-4da6-bfb8-8ee67e560c4d'),
       ('9c3497b5-598a-4237-889d-1826731120a8', 'd6c545a1-32cb-4034-a74b-1e11c51658ce',
        'b293084a-1fe1-458b-8218-bcdccf1418f5'),
       ('cc4e25cb-bccd-4f4e-9ae5-bd28b20ff6bf', 'd6c545a1-32cb-4034-a74b-1e11c51658ce',
        '34ecf170-8715-446b-8264-daefcc097ded'),
       ('c36fef20-d23f-4b2a-b9e6-c417b14deae4', 'd6c545a1-32cb-4034-a74b-1e11c51658ce',
        '5bf16ecb-e5df-4b9b-85ca-f442dd692082'),
       ('c9218cf6-a7c3-4ec8-89b7-81db7dce102d', 'd6c545a1-32cb-4034-a74b-1e11c51658ce',
        'a6cac03a-fe57-493b-a323-52d34e7989f7'),
       ('66bd91ae-2616-4d76-9c4c-0cd6bf7476c0', '93802199-17ab-4cea-8b70-5e783480ef52',
        'fbb63c65-270e-4da6-bfb8-8ee67e560c4d'),
       ('0f9f79f7-8cd9-4af2-9d0a-442aaac1070d', '93802199-17ab-4cea-8b70-5e783480ef52',
        'b293084a-1fe1-458b-8218-bcdccf1418f5'),
       ('3f3ab490-f9a7-48fb-b54f-37b0570bf1e7', '93802199-17ab-4cea-8b70-5e783480ef52',
        'b0d3c291-fccd-4c69-a62f-d70836e4ef12'),
       ('c5638ab5-b300-48b2-b908-f41b0d7fc22f', '93802199-17ab-4cea-8b70-5e783480ef52',
        '0a8ba285-0558-4e7b-85fd-b32b8b1c2a4f'),
       ('d9fd0f95-a595-4af6-94f7-a2a9fb3caf22', '2296fbc1-90ab-49b8-8043-470af3015e79',
        'b0d3c291-fccd-4c69-a62f-d70836e4ef12'),
       ('59a5e318-57d7-47cf-b446-a1ad3b15f6fc', '2296fbc1-90ab-49b8-8043-470af3015e79',
        'b032cf45-fcba-43b9-b2ae-fe0802762c49'),
       ('b2e6633c-c622-4e2f-b27b-0aaa2c3beb13', '2296fbc1-90ab-49b8-8043-470af3015e79',
        '3adf2ea9-f3c4-4018-938b-361734f6938a');

INSERT INTO project(id, "name", code, creator_id)
VALUES ('0d4a3a6f-021c-4b7b-b342-6f78589b5564', 'Capstone', 'CPS',
        '0a8ba285-0558-4e7b-85fd-b32b8b1c2a4f'),
       ('bd09feb2-156b-4d7a-972d-ce83a2ecd228', 'Kvartal''s project', 'KVP',
        'b0d3c291-fccd-4c69-a62f-d70836e4ef12'),
       ('2742ca8f-9b6d-4950-8a0b-ce47bc1fb833', 'Shirak', 'SH',
        'a6cac03a-fe57-493b-a323-52d34e7989f7'),
       ('d6ecf171-ba66-4271-bbbe-499c17628bbf', 'AUA studies', 'AUA',
        '5bf16ecb-e5df-4b9b-85ca-f442dd692082');

INSERT INTO project_team(id, project_id, team_id)
VALUES ('586c8726-1e61-4459-bad0-d02202555efa', '0d4a3a6f-021c-4b7b-b342-6f78589b5564',
        '93802199-17ab-4cea-8b70-5e783480ef52'),
       ('30f1203e-184c-459c-a8b9-ee16dd57bc65', 'bd09feb2-156b-4d7a-972d-ce83a2ecd228',
        '2296fbc1-90ab-49b8-8043-470af3015e79'),
       ('331fc29e-d8cf-42dc-8a09-5ca6306b2850', '2742ca8f-9b6d-4950-8a0b-ce47bc1fb833',
        'd6c545a1-32cb-4034-a74b-1e11c51658ce'),
       ('51aeb1ad-009b-4455-9c2d-1d763191abba', 'd6ecf171-ba66-4271-bbbe-499c17628bbf',
        'efdc3ab6-a454-48ef-a287-0c933eb0d5de');

INSERT INTO ticket(id, project_id, serial_id, headline, body, creator_id, assignee_id)
VALUES ('9187d91e-4792-4589-ac15-fcbc13570459', '0d4a3a6f-021c-4b7b-b342-6f78589b5564', 1,
        'First ever ticket''s headline', 'the body of the ticket',
        'fbb63c65-270e-4da6-bfb8-8ee67e560c4d',
        'b293084a-1fe1-458b-8218-bcdccf1418f5');

INSERT INTO comment(id, ticket_id, body, creator_id, created_at)
VALUES ('8dde53c6-dbb1-4044-92c4-b1da631c4834', '9187d91e-4792-4589-ac15-fcbc13570459',
        'comment body', 'b0d3c291-fccd-4c69-a62f-d70836e4ef12', now())