INSERT INTO users(name, phone_number, password)
VALUES ('이동엽', '01012341234', '12341234'),
       ('손준호', '01023452345', '23452345'),
       ('손다은', '01034563456', '34563456');

INSERT INTO post(title, content, user_id, views)
VALUES ('title1', 'content1', 1, 0),
       ('title2', 'content2', 2, 0),
       ('title3', 'content3', 3, 0),
       ('title4', 'content4', 1, 0),
       ('title5', 'content5', 2, 0),
       ('title6', 'content6', 3, 0),
       ('title7', 'content7', 2, 0);

INSERT INTO comment(content, post_id, user_id)
VALUES ('comment1', 1, 1),
       ('comment2', 1, 2),
       ('comment2', 1, 3),
       ('comment3', 2, 1),
       ('comment4', 2, 2),
       ('comment5', 2, 3),
       ('comment6', 3, 1),
       ('comment7', 3, 2),
       ('comment8', 3, 3);