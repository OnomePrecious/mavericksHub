truncate table users cascade;
truncate table media cascade;
truncate table likes cascade;


insert into users(id, email, password, time_created) values
(200, 'john@email.com', 'password', '2024-06-04T15:03:03.792009700'),
(201, 'jane@email.com', 'password', '2024-06-04T15:03:03.792009700'),
(202, 'johnny@email.com', 'password', '2024-06-04T15:03:03.792009700'),
(203, 'james@email.com', 'password', '2024-06-04T15:03:03.792009700');

insert into media (id, category, description, url, time_created, uploader_id) values
(100, 'ACTION', 'media 1', 'https://www.cloudinary.com/media1', '2024-06-04T15:03:03.792009700', 200),
(101, 'ACTION', 'media 2', 'https://www.cloudinary.com/media2', '2024-06-04T15:03:03.792009700', 200),
(102, 'STEP_MOM', 'media 3', 'https://www.cloudinary.com/media3', '2024-06-04T15:03:03.792009700', 201),
(103, 'COMEDY', 'media 4', 'https://www.cloudinary.com/media4', '2024-06-04T15:03:03.792009700', 200),
(104, 'ROMANCE', 'media 5', 'https://www.cloudinary.com/media5', '2024-06-04T15:03:03.792009700', 201);
insert into likes(id, media_id,  userid, time_liked) values
                                                          (20, 100, 200, '2024-06-04T15:03:03.792009700'),
                                                          (21, 100, 201, '2024-06-04T15:03:03.792009700'),
                                                          (22, 102, 202, '2024-06-04T15:03:03.792009700'),
                                                          (23, 103, 203, '2024-06-04T15:03:03.792009700');



-- insert into dislikes(id, media_id,  user_id, time_disliked) values
--                                  (20, 100, 200, '2024-06-04T15:03:03.792009700'),
--                                                           (21, 100, 201, '2024-06-04T15:03:03.792009700'),
--                                                           (22, 102, 202, '2024-06-04T15:03:03.792009700'),
--                                                           (23, 103, 203, '2024-06-04T15:03:03.792009700');




