-- DROP TABLE IF EXISTS comments;
-- DROP TABLE IF EXISTS patients;
-- DROP TABLE IF EXISTS doctors;

--
-- CREATE TABLE public.patients (
--     id bigint NOT NULL,
--     address character varying(255),
--     birth__day timestamp without time zone NOT NULL,
--     country character varying(255),
--     first_name character varying(255) NOT NULL,
--     last_name character varying(255) NOT NULL,
--     sex character varying(255) NOT NULL,
--     state character varying(255)
-- );
--
-- CREATE TABLE public.doctors (
--     id bigint NOT NULL,
--     first_name character varying(255) NOT NULL,
--     last_name character varying(255) NOT NULL
-- );
--
-- CREATE TABLE public.comments (
--     id bigint NOT NULL,
--     date_creating timestamp without time zone NOT NULL,
--     text text,
--     id_doctor bigint NOT NULL,
--     id_patient bigint NOT NULL
-- );
--
INSERT INTO patients (id, first_name, last_name, birthday, sex, country, state, address)
VALUES (1, 'Marie', 'Green', '2001-09-12', 'female', 'USA', 'Indiana', 'Union City'),
       (2, 'Janette', 'Logan', '2001-09-12', 'female', 'USA', 'Georgia', 'North Carolina'),
       (3, 'Cleo', 'Joyce', '1998-10-2', 'male', 'USA', 'Florida', 'Loper'),
       (4, 'Jayson', 'Balfour', '1995-3-28', 'male', 'USA', 'Manitoba', 'Bloomer'),
       (5, 'Isabel', 'Sharlene', '1990-6-4', 'female', 'USA', 'Indiana', 'Union City'),
       (6, 'Kenny', 'Braidy', '2002-7-9', 'male', 'USA', 'Florida', 'Rush Lake'),
       (7, 'Angie', 'Andy', '2000-8-15', 'female', 'USA', 'Indiana', 'Lancaster'),
       (8, 'Bruce', 'Tayler', '2001-9-7', 'male', 'USA', 'Georgia', 'Richwood'),
       (9, 'Emmy', 'Ambrosine', '1998-4-3', 'female', 'USA', 'Arizona', 'Broom Hill'),
       (10, 'Fancy', 'Forrest', '1998-11-17', 'female', 'USA', 'West Virginia', 'Ladd');

INSERT INTO doctors(id, first_name, last_name)
VALUES (1, 'Sheridan', 'Norris'),
       (2, 'Damian', 'Zayden'),
       (3, 'Paulie', 'Loren'),
       (4, 'Blaze', 'Dane'),
       (5, 'Claud', 'Casimir'),
       (6, 'Hamnet', 'Amery'),
       (7, 'Norbert', 'Meade'),
       (8, 'Benton', 'Reilly'),
       (9, 'Sidney', 'Landen');

INSERT INTO comments (id, date_creating, text, id_doctor, id_patient)
VALUES (1, '2020-09-16 14:15:39.16246', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. ' ||
           'Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer ' ||
           'took a galley of type and scrambled it to make a type specimen book. It has survived not only five ' ||
           'centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was ' ||
           'popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more ' ||
           'recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 1, 1),
       (2, '2020-10-16 19:25:19.16246', 'It is a long established fact that a reader will be distracted by the ' ||
           'readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a ' ||
           'more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making ' ||
           'it look like readable English.', 8, 1),
       (3, '2020-10-26 14:15:39.16246', 'Many desktop publishing packages and web page editors now use Lorem Ipsum as ' ||
           'their default model text, and a search for ''lorem ipsum'' will uncover many web sites still in their ' ||
           'infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose ' ||
           '(injected humour and the like).', 3, 1),
       (4, '2020-07-16 13:15:39.16246', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. ' ||
           'Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer ' ||
           'took a galley of type and scrambled it to make a type specimen book. It has survived not only five ' ||
           'centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was ' ||
           'popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more ' ||
           'recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 4, 2),
       (5, '2020-07-16 14:15:39.16246', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. ' ||
           'Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer ' ||
           'took a galley of type and scrambled it to make a type specimen book. It has survived not only five ' ||
           'centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was ' ||
           'popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more ' ||
           'recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 7, 3),
       (6, '2020-08-12 10:35:39.16246', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent posuere ' ||
           'eu diam sed tempor. Nam volutpat euismod nisl, vel varius tellus varius quis. Mauris at est eu nisi ' ||
           'porttitor blandit. Nunc vitae lorem rhoncus, fermentum odio sit amet, rhoncus mi. Nulla rutrum leo in ' ||
           'risus auctor, non eleifend enim malesuada. Aliquam pharetra urna ut condimentum facilisis. Curabitur ' ||
           'congue et turpis quis lobortis. Quisque nec quam nec lacus ultrices luctus at sit amet velit. Vivamus ' ||
           'in risus gravida, dictum urna in, consequat massa. Aliquam faucibus semper lectus in gravida. Donec ' ||
           'porttitor justo vitae leo maximus consectetur. Sed et sapien non leo tempor gravida. Sed semper viverra ' ||
           'nisl. Maecenas vestibulum commodo rutrum. ', 8, 3),
       (7, '2020-10-11 14:15:39.16246', 'It is a long established fact that a reader will be distracted by the ' ||
           'readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a ' ||
           'more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making ' ||
           'it look like readable English.', 1, 4),
       (8, '2020-10-29 13:21:39.16246', 'Phasellus placerat turpis in fringilla facilisis. Mauris vehicula, tortor ' ||
           'sit amet cursus faucibus, arcu ex aliquet felis, vitae euismod ex massa sed lectus. Duis a scelerisque ' ||
           'ex. Donec ultricies a neque at luctus. Nulla fringilla bibendum tincidunt. Vivamus venenatis vitae mi eu ' ||
           'scelerisque.', 8, 4),
       (9, '2020-11-16 14:45:39.16246', 'Morbi congue risus eu urna faucibus auctor. Mauris hendrerit, massa ' ||
           'ullamcorper congue ullamcorper, nunc turpis accumsan elit, nec tristique lectus ex a metus', 4, 4),
       (10, '2020-11-18 14:15:39.16246', 'It is a long established fact that a reader will be distracted by the ' ||
            'readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a ' ||
            'more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making ' ||
            'it look like readable English.', 1, 4),
       (11, '2020-08-10 17:15:39.16246', 'It is a long established fact that a reader will be distracted by the ' ||
            'readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a ' ||
            'more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making ' ||
            'it look like readable English.', 1, 5),
       (12, '2020-09-01 10:11:39.16246', 'Sed sed eleifend justo, vel varius arcu. Cras viverra in justo vitae ' ||
            'venenatis. Maecenas commodo accumsan turpis sit amet pretium. Nunc blandit diam magna, vitae placerat ' ||
            'odio hendrerit non. Nunc viverra lorem in consectetur tempor. Ut dapibus, orci et porttitor egestas, ' ||
            'orci orci egestas dui, a suscipit ligula diam sit amet metus. Curabitur tincidunt lobortis ipsum vel ' ||
            'volutpat. In volutpat tortor sit amet erat aliquam, id semper magna tempus.', 7, 5),
       (13, '2020-09-15 11:14:39.16246', 'Quisque libero leo, vehicula id fermentum in, porttitor at sem. Donec ' ||
            'consectetur sem ex, id efficitur odio porta sit amet.', 2, 5),
       (14, '2020-09-29 12:30:39.16246', 'Quisque libero leo, vehicula id fermentum in, porttitor at sem. Donec ' ||
            'consectetur sem ex, id efficitur odio porta sit amet.', 4, 5),
       (15, '2020-10-10 11:30:39.16246', 'Quisque libero leo, vehicula id fermentum in, porttitor at sem. Donec ' ||
            'consectetur sem ex, id efficitur odio porta sit amet.', 1, 5),
       (16, '2020-07-12 14:10:39.16246', 'It is a long established fact that a reader will be distracted by the ' ||
            'readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has ' ||
            'a more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', ' ||
            'making it look like readable English.', 5, 6),
       (17, '2020-07-19 10:15:39.16246', 'Nulla elementum sollicitudin risus ac malesuada. Donec hendrerit erat ut ' ||
            'arcu vehicula, sit amet lacinia ligula auctor.', 6, 6),
       (18, '2020-06-16 12:15:39.16246', 'Nam ut luctus est. Quisque id nulla pretium, commodo diam bibendum, ' ||
            'aliquam sapien. Proin id lectus quis tortor dignissim dictum et sed est. Integer in tempus dolor. ' ||
            'Vestibulum ornare, diam in lobortis porta, magna libero laoreet dui, in pellentesque justo mauris non ' ||
            'urna. Sed at nisl mattis ex molestie pellentesque. Mauris vulputate nisi quis interdum posuere. ' ||
            'Aliquam enim nibh, tempor non quam quis, ornare vulputate nulla.', 1, 7),
       (19, '2020-07-17 11:15:39.16246', 'Maecenas elementum quam at leo rhoncus, eu maximus nulla finibus. ' ||
            'Praesent vel felis varius, euismod quam quis, aliquam ex. Sed auctor ac massa at laoreet. Suspendisse ' ||
            'accumsan cursus felis, vitae eleifend mi laoreet sed. Fusce porttitor eleifend ornare. ', 2, 7),
       (20, '2020-08-16 10:25:39.16246', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. ' ||
            'Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer ' ||
            'took a galley of type and scrambled it to make a type specimen book. It has survived not only five ' ||
            'centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was ' ||
            'popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more ' ||
            'recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 3, 7),
       (21, '2020-09-23 12:18:39.16246', 'Maecenas elementum quam at leo rhoncus, eu maximus nulla finibus. ' ||
            'Praesent vel felis varius, euismod quam quis, aliquam ex. Sed auctor ac massa at laoreet. Suspendisse ' ||
            'accumsan cursus felis, vitae eleifend mi laoreet sed. Fusce porttitor eleifend ornare. ', 6, 8),
       (22, '2020-10-16 11:15:39.16246', 'Phasellus placerat turpis in fringilla facilisis. Mauris vehicula, tortor ' ||
            'sit amet cursus faucibus, arcu ex aliquet felis, vitae euismod ex massa sed lectus. Duis a scelerisque ' ||
            'ex. Donec ultricies a neque at luctus. Nulla fringilla bibendum tincidunt. Vivamus venenatis vitae mi eu ' ||
            'scelerisque.', 1, 9),
       (23, '2020-10-26 15:15:39.16246', 'It is a long established fact that a reader will be distracted by the ' ||
            'readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a ' ||
            'more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making ' ||
            'it look like readable English.', 1, 9),
       (24, '2020-05-16 13:15:39.16246', 'Sed sed eleifend justo, vel varius arcu. Cras viverra in justo vitae ' ||
            'venenatis. Maecenas commodo accumsan turpis sit amet pretium. Nunc blandit diam magna, vitae placerat ' ||
            'odio hendrerit non.', 7, 10),
       (25, '2020-06-20 10:25:39.16246', 'Nunc viverra lorem in consectetur tempor. Ut dapibus, orci et porttitor ' ||
            'egestas, orci orci egestas dui, a suscipit ligula diam sit amet metus. Curabitur tincidunt lobortis ' ||
            'ipsum vel volutpat. In volutpat tortor sit amet erat aliquam, id semper magna tempus.', 2, 10),
       (26, '2020-07-12 14:30:39.16246', 'Quisque libero leo, vehicula id fermentum in, porttitor at sem. Donec ' ||
            'consectetur sem ex, id efficitur odio porta sit amet.', 8, 10),
       (27, '2020-08-20 10:35:39.16246', 'Maecenas lectus lorem, iaculis sit amet eleifend quis, semper condimentum ' ||
            'mi. Nulla elementum sollicitudin risus ac malesuada.', 5, 10),
       (28, '2020-09-10 15:15:39.16246', 'Donec hendrerit erat ut arcu vehicula, sit amet lacinia ligula auctor. ', 6, 10);

