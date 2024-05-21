INSERT INTO `user_info`(id, username, password)
VALUES ('admin', 'admin', 'admin'),
       ('tester', 'tester', 'tester');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('18cbaac1-980d-389f-b', 'christ19', '1980-09-15 15:52:15', '7cadb00cb2ed083632b1');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('2ab152e9-c67f-3b4f-a', 'floy28', '1984-12-16 01:36:30', '9c678cfeeb9bc4fa5f86');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('2b657742-0299-3be5-a', 'larson.emily', '2006-04-10 12:27:34', '5564392baa13d3e00a72');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('32b3d156-c958-3b94-8', 'fullrich', '1988-07-21 08:01:05', '4fe02434325c9669fcef');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('3553501c-8b0d-36bb-9', 'kihn.holly', '2015-11-10 05:53:51', 'b0f19a0453f00129149d');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('3612b9fe-20d5-3b81-a', 'gilberto.reichert', '1989-12-22 01:43:28', 'e50e180b704891f8087b');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('518f61ea-ad3a-345c-9', 'ethelyn.weissnat', '2002-05-12 12:45:38', '661211abc4491fa1f241');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('56556701-935c-3205-8', 'rosie.quitzon', '2005-12-01 17:03:05', 'f9a9e3e95fc22090cab9');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('5c03e06f-0657-38d3-a', 'jettie84', '2018-05-21 00:10:00', 'd960f82a8ee75d0db739');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('61f3856b-c3a3-3a40-a', 'erica.renner', '2005-06-10 01:57:17', '8361079fb03cf65803e7');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('6d2d7853-9f59-33e7-a', 'whansen', '2010-12-22 01:46:40', 'b5a235d57193db94d387');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('7f89de3a-1060-3cca-b', 'payton39', '2003-05-15 08:28:20', 'fb86a46e8ad13672e9d9');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('89bfb0f1-d054-363f-a', 'lowell.huel', '1977-02-08 13:50:43', 'e426f86de757fa95e194');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('93820cd1-77ac-3bd7-b', 'schaefer.tressa', '1984-06-21 02:55:38', '7c0a366f63241f1b3015');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('97487d08-7f87-36e5-a', 'moen.olaf', '2002-04-16 04:54:43', 'c3697ec469a8200031f4');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('9dfe61d6-4944-3cfe-a', 'herta.grant', '2004-03-30 17:28:00', '1a7c16d84b4580ca5cf8');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('aa3ac0ef-e122-3cb9-8', 'hollie.stehr', '1995-11-08 20:05:22', '9827f6943f495a5c7527');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('e0389da4-8f5d-39ab-b', 'uroob', '2004-02-29 04:32:09', 'b504ef580dfec17c3e69');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('e9a3a153-d423-3cf3-a', 'sonny.runolfsdottir', '1983-12-13 15:33:09', 'f95750c6c3638c403619');
INSERT INTO `user_info` (`id`, `username`, `created_at`, `password`)
VALUES ('f86537c6-215c-3ef1-9', 'pacocha.rylan', '1999-07-15 02:59:37', '06e725165aa2877eea29');

SELECT *
FROM user_info;

INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('18cbaac1-980d-389f-b', 'at', NULL, NULL, 49, 'Sint modi ullam quia delectus quia vel.');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('2ab152e9-c67f-3b4f-a', 'velit', NULL, NULL, 47,
        'Qui pariatur voluptatem consequuntur reprehenderit qui neque.');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('2b657742-0299-3be5-a', 'voluptatem', NULL, NULL, 18, '');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('32b3d156-c958-3b94-8', 'qui', NULL, NULL, 20, '');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('3553501c-8b0d-36bb-9', 'sed', NULL, NULL, 43, '');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('3612b9fe-20d5-3b81-a', 'ut', NULL, NULL, 47, 'Ea ut sapiente quo voluptas.');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('518f61ea-ad3a-345c-9', 'vero', NULL, NULL, 17, '');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('56556701-935c-3205-8', 'aperiam', NULL, NULL, 46, '');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('5c03e06f-0657-38d3-a', 'blanditiis', NULL, NULL, 49, '');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('61f3856b-c3a3-3a40-a', 'quisquam', NULL, NULL, 24, 'Ad perferendis doloribus quia dolore ut sit.');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('6d2d7853-9f59-33e7-a', 'excepturi', NULL, NULL, 56, 'Rem voluptatum officiis recusandae vero.');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('7f89de3a-1060-3cca-b', 'eligendi', NULL, NULL, 32, 'Dolores enim vero beatae autem ad.');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('89bfb0f1-d054-363f-a', 'ex', NULL, NULL, 22, '');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('93820cd1-77ac-3bd7-b', 'quibusdam', NULL, NULL, 19, 'Facere in pariatur omnis consequatur autem saepe.');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('97487d08-7f87-36e5-a', 'ipsum', NULL, NULL, 12, '');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('9dfe61d6-4944-3cfe-a', 'qui', NULL, NULL, 37, '');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('aa3ac0ef-e122-3cb9-8', 'omnis', NULL, NULL, 26, 'Adipisci quia numquam deserunt eius qui cupiditate.');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('e0389da4-8f5d-39ab-b', 'quidem', NULL, NULL, 50, 'Expedita amet dolores sunt sit maxime.');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('e9a3a153-d423-3cf3-a', 'corporis', NULL, NULL, 24,
        'Distinctio cum molestiae delectus nihil amet quod officiis veniam.');
INSERT INTO `user_profile` (`id`, `gender`, `height`, `weight`, `age`, `goal`)
VALUES ('f86537c6-215c-3ef1-9', 'et', NULL, NULL, 17, 'Earum error enim quia ducimus eum.');
INSERT INTO `user_profile`
VALUES ('admin', 'F', 100, 100, 100, '자신감 갖기!'),
       ('tester', 'M', 200, 200, 200, '습관 만들기');

INSERT INTO `post`(`title`, `description`, `writer_id`)
VALUES ('test', 'test', 'tester');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Vel explicabo eaque ',
        'Quod fugiat voluptatum labore consequatur iure exercitationem. Amet error in et veniam et. Aut et autem enim illum. Et consequuntur tenetur quia iusto.',
        '18cbaac1-980d-389f-b', 'public', '2014-04-15 10:34:51', 75, '1996-07-11 12:15:58');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Tempore doloribus al',
        'Voluptas dolores minus itaque exercitationem tempora autem. Veniam dolor non dignissimos dolore omnis. Non nisi dolor sequi rerum voluptatem minus.',
        '2ab152e9-c67f-3b4f-a', 'public', '1992-08-15 10:18:11', 47, '2003-06-06 02:36:17');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Culpa quis quibusdam',
        'Ipsum velit sit suscipit voluptas voluptatum quis. Nulla ab necessitatibus pariatur natus distinctio. Et vel harum ratione dolor sit.',
        '2b657742-0299-3be5-a', 'public', '2011-08-21 02:58:17', 48, '1974-12-10 22:30:09');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Cumque ut voluptatum',
        'Nihil qui dolor incidunt dolor repellendus. Placeat rerum necessitatibus amet consequatur autem quas aperiam. Nihil quam adipisci neque est. Quia vitae consequatur labore sed.',
        '32b3d156-c958-3b94-8', 'public', '2013-08-08 18:34:31', 89, '1973-12-21 04:58:31');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Sed fugit aut molest',
        'Minima quisquam odio voluptates quae vitae quia. Nam quam sunt aspernatur in. Officiis minima veniam voluptatum et et. Omnis soluta aut minus dicta sunt debitis.',
        '3553501c-8b0d-36bb-9', 'public', '2022-11-24 15:59:31', 52, '2018-01-08 14:04:53');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Quis libero et tenet',
        'Debitis sed adipisci harum occaecati. Quia similique facilis facilis quia repudiandae qui. Illo voluptas sit sit nesciunt.',
        '3612b9fe-20d5-3b81-a', 'public', '2007-03-24 14:32:48', 45, '1973-07-05 16:19:34');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Sequi quia voluptate',
        'Facere perferendis fugit voluptatibus consequatur voluptas ab provident ipsa. Consequuntur est distinctio veniam dolor voluptas.',
        '518f61ea-ad3a-345c-9', 'public', '1980-08-07 18:02:29', 18, '1977-05-14 21:18:29');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Quisquam ea accusant',
        'Incidunt fuga aut eos iste et numquam. Necessitatibus ut at similique incidunt numquam id. Tempore deserunt rerum voluptatem eius molestias harum.',
        '56556701-935c-3205-8', 'public', '2015-01-26 14:47:19', 61, '1984-11-28 20:45:53');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Ut eaque sint est et',
        'Eveniet saepe totam reprehenderit enim possimus iure at. Et dignissimos debitis quae enim. Totam ut minima rerum. Maxime aliquam tenetur sint necessitatibus quam voluptates similique.',
        '5c03e06f-0657-38d3-a', 'public', '2003-11-24 21:32:08', 28, '1996-02-18 05:23:14');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Provident fuga incid',
        'Ut vero modi quos quam. Nihil beatae voluptates sit. Enim ab ut eum dolore neque quia eveniet atque. Nisi fugit ea rerum aut.',
        '61f3856b-c3a3-3a40-a', 'public', '1974-01-31 19:10:28', 33, '1992-01-23 22:38:41');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Nihil et error est a',
        'Culpa natus sed eveniet magni reiciendis. Sequi magni ex sapiente corrupti. Laborum aliquam unde praesentium eum quaerat. Nisi labore magni quam quia.',
        '6d2d7853-9f59-33e7-a', 'public', '1985-04-25 14:36:20', 68, '1997-11-22 16:37:07');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Vitae hic deleniti s', 'Eos odio beatae id voluptas asperiores harum ea. Praesentium nam est eum atque.',
        '7f89de3a-1060-3cca-b', 'public', '1982-02-11 02:00:57', 85, '2015-02-10 00:20:32');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Cum odit optio aut a',
        'Necessitatibus inventore ipsum minus modi. Culpa consequatur alias dolorem officia repudiandae aperiam in. Quas soluta dolorem necessitatibus ut dolores aut non quas.',
        '89bfb0f1-d054-363f-a', 'public', '2013-04-19 11:15:24', 61, '2005-06-25 10:12:27');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Quaerat aut impedit ',
        'Ut et et praesentium voluptas. Natus est quasi distinctio sapiente sint et voluptas. Perferendis omnis inventore aliquid est.',
        '93820cd1-77ac-3bd7-b', 'public', '1981-04-18 04:17:01', 83, '1993-04-20 00:55:02');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Aliquam sed at accus',
        'In et enim neque ut recusandae. Eligendi a illum eius et a. Et quidem non quia molestiae. Facilis dolores ea eum.',
        '97487d08-7f87-36e5-a', 'public', '2020-03-16 21:05:31', 18, '1975-10-17 10:00:58');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Sint atque veritatis',
        'Corporis similique nihil iusto reprehenderit. Inventore ut assumenda porro enim omnis eius. Exercitationem omnis eius expedita corrupti et perferendis.',
        '9dfe61d6-4944-3cfe-a', 'public', '2011-05-07 21:14:13', 28, '1996-01-20 22:10:45');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Numquam quidem aut r',
        'Quo nulla quod molestias molestiae officia dignissimos. Rerum soluta veritatis tempore recusandae libero. Quo eius consequuntur optio labore eveniet. Alias dolore odit voluptatibus sed quos quia aut.',
        'aa3ac0ef-e122-3cb9-8', 'public', '2015-04-19 14:33:59', 89, '1984-02-18 07:19:20');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Veritatis ea tenetur',
        'Sint quaerat ex placeat est sunt aut dolorem est. Id sed expedita amet aut quis corporis eveniet. Quas quis nam dicta rerum.',
        'e0389da4-8f5d-39ab-b', 'public', '2023-07-17 05:39:51', 5, '1970-10-24 02:44:51');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Dolores cumque aut a',
        'Pariatur vel rem occaecati culpa autem. Eaque quasi ea autem est. Quas tenetur delectus expedita.',
        'e9a3a153-d423-3cf3-a', 'public', '1983-06-05 05:06:26', 12, '1986-12-27 11:21:27');
INSERT INTO `post` (`title`, `description`, `writer_id`, `status`, `created_at`, `view_count`, `updated_at`)
VALUES ('Ea qui recusandae si', 'Dolores voluptates aut vel. Et ut et pariatur perspiciatis.',
        'f86537c6-215c-3ef1-9', 'public', '2023-04-18 23:22:33', 53, '2004-08-15 06:20:08');

INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (1, '18cbaac1-980d-389f-b',
        'Dolores et saepe voluptatem voluptas dolor. Sequi voluptas ad vel vitae repellat et tenetur. Et molestiae enim quidem sunt quibusdam labore.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (2, '2ab152e9-c67f-3b4f-a',
        'Explicabo quaerat earum minima sed aspernatur vel. Corrupti voluptatem aut natus omnis. Aut est sed laborum similique amet culpa voluptatum.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (3, '2b657742-0299-3be5-a',
        'Natus cumque placeat quo dolor maxime natus in consectetur. Quam accusantium aperiam odit earum ut quia odit. Omnis quisquam magnam veritatis blanditiis.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (4, '32b3d156-c958-3b94-8',
        'Reiciendis blanditiis et officia quia perferendis voluptate. Iste perspiciatis accusantium sed corrupti vel aut laudantium natus. Vel repellat nobis praesentium nostrum assumenda voluptates quam.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (5, '3553501c-8b0d-36bb-9',
        'Dolores et rem placeat dolore dolores doloremque explicabo distinctio. Qui nam et voluptatum odio autem ipsum. Maiores dolorem possimus ipsa consequatur minus at. Ab laboriosam nulla et molestiae.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (6, '3612b9fe-20d5-3b81-a',
        'Hic incidunt eum voluptas ipsum impedit. Voluptas sed at iste qui dolores. Velit ducimus ut non.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (7, '518f61ea-ad3a-345c-9',
        'Aut commodi ad non. Reiciendis accusantium laudantium iusto velit. Porro suscipit aut consequatur cupiditate non necessitatibus excepturi. Aut odit eum nihil in odit.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (8, '56556701-935c-3205-8',
        'Beatae eos quo cupiditate error aut et commodi. Iste molestias delectus atque cumque porro molestias animi. Voluptate non molestiae impedit eligendi.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (9, '5c03e06f-0657-38d3-a',
        'Et sint fuga et laborum cum inventore et. Consequatur molestiae est corporis vero. Minima sapiente et sit voluptas repudiandae similique rerum. Expedita nulla non cupiditate quaerat dolor.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (10, '61f3856b-c3a3-3a40-a',
        'Expedita ratione voluptatem et nostrum cum. Qui ullam eius est dignissimos dolor ratione non. Numquam et est fugit saepe ut ad. Et dicta at velit est tempore.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (11, '6d2d7853-9f59-33e7-a',
        'Nesciunt pariatur impedit dicta et voluptatem repudiandae. Ipsam iusto praesentium exercitationem. Impedit voluptatibus numquam illum ut sit quia incidunt. Ullam alias sed porro assumenda esse autem.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (12, '7f89de3a-1060-3cca-b',
        'Quibusdam quidem doloremque est voluptate. Ut voluptatibus animi quisquam corrupti quia architecto molestiae. Tempore beatae et mollitia doloremque iure neque a. Et consequuntur a minima ut et rem.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (13, '89bfb0f1-d054-363f-a',
        'Amet eos ab quibusdam repellat quaerat. Vel magnam et officiis fugiat sit placeat ab. Animi qui laboriosam perspiciatis et itaque.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (14, '93820cd1-77ac-3bd7-b',
        'Dignissimos esse corrupti tempora enim laboriosam. Non repellendus est officia aliquid aut cupiditate. Fugit et quia sit eaque qui.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (15, '97487d08-7f87-36e5-a',
        'Et inventore voluptatem blanditiis nam. Molestias molestias repellendus impedit sed eum temporibus. Et sint fuga laudantium dolorum. Veritatis doloribus excepturi doloribus ut.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (16, '9dfe61d6-4944-3cfe-a',
        'Modi officiis aut in aut. Laudantium nihil aperiam dignissimos est omnis. Fugit et iusto voluptas ea accusantium modi vel. Et pariatur voluptas nesciunt.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (17, 'aa3ac0ef-e122-3cb9-8',
        'Necessitatibus omnis autem rerum impedit in. Ipsam non veritatis cum sed tenetur. Alias doloremque magni qui vero repudiandae ea. Sint deleniti sit non ex quaerat.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (18, 'e0389da4-8f5d-39ab-b',
        'Sit reprehenderit reprehenderit laboriosam dolor repellat aut. Vel exercitationem sequi id consequatur deleniti velit libero. Reiciendis voluptatem debitis sed totam.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (19, 'e9a3a153-d423-3cf3-a',
        'Qui quo rerum tempore eius aut in quod. Nulla provident ut qui numquam. Qui ipsa impedit est facere nobis quia. Repellat similique laudantium earum est voluptatibus est aut odit.');
INSERT INTO `comment` (`post_id`, `writer_id`, `content`)
VALUES (20, 'f86537c6-215c-3ef1-9',
        'Fuga qui accusantium dolor et sed. Sapiente corrupti dolores consectetur. Quo dolores incidunt unde est molestias.');


INSERT INTO `tag` (`id`, `name`)
VALUES (8, 'accusamus');
INSERT INTO `tag` (`id`, `name`)
VALUES (12, 'ad');
INSERT INTO `tag` (`id`, `name`)
VALUES (18, 'aut');
INSERT INTO `tag` (`id`, `name`)
VALUES (4, 'consequatur');
INSERT INTO `tag` (`id`, `name`)
VALUES (7, 'consequuntur');
INSERT INTO `tag` (`id`, `name`)
VALUES (14, 'eaque');
INSERT INTO `tag` (`id`, `name`)
VALUES (19, 'eligendi');
INSERT INTO `tag` (`id`, `name`)
VALUES (11, 'et');
INSERT INTO `tag` (`id`, `name`)
VALUES (3, 'in');
INSERT INTO `tag` (`id`, `name`)
VALUES (6, 'inventore');
INSERT INTO `tag` (`id`, `name`)
VALUES (17, 'laudantium');
INSERT INTO `tag` (`id`, `name`)
VALUES (20, 'minus');
INSERT INTO `tag` (`id`, `name`)
VALUES (9, 'molestiae');
INSERT INTO `tag` (`id`, `name`)
VALUES (13, 'numquam');
INSERT INTO `tag` (`id`, `name`)
VALUES (2, 'praesentium');
INSERT INTO `tag` (`id`, `name`)
VALUES (16, 'quam');
INSERT INTO `tag` (`id`, `name`)
VALUES (1, 'qui');
INSERT INTO `tag` (`id`, `name`)
VALUES (5, 'repudiandae');
INSERT INTO `tag` (`id`, `name`)
VALUES (15, 'tenetur');
INSERT INTO `tag` (`id`, `name`)
VALUES (10, 'veritatis');

INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (1, 1);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (2, 2);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (3, 3);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (4, 4);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (5, 5);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (6, 6);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (7, 7);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (8, 8);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (9, 9);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (10, 10);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (11, 11);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (12, 12);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (13, 13);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (14, 14);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (15, 15);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (16, 16);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (17, 17);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (18, 18);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (19, 19);
INSERT INTO `post_tag` (`post_id`, `tag_id`)
VALUES (20, 20);


#
# TABLE STRUCTURE FOR: post_video
#


INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (2, 'Voluptas nesciunt do', 'http://wintheiser.co', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (3, 'Similique repellendu', 'http://www.weissnat.', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (11, 'Est consequatur expe', 'http://www.rice.com/', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (21, 'Totam tenetur illo m', 'http://pagacziemann.', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (22, 'Asperiores asperiore', 'http://barrows.net/', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (29, 'Voluptatem et et qui', 'http://thompson.com/', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (30, 'Error mollitia odit ', 'http://www.kunze.biz', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (31, 'Dolore dolore non hi', 'http://hillljohnson.', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (33, 'Laboriosam odit qui ', 'http://brekkecrona.c', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (35, 'Optio qui voluptatem', 'http://www.hilpertra', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (48, 'Et velit error quia ', 'http://parisian.com/', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (56, 'Amet eum qui qui fug', 'http://www.rogahn.co', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (66, 'Nemo ab beatae commo', 'http://lakin.com/', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (72, 'Et molestiae pariatu', 'http://www.grant.com', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (73, 'Blanditiis et mollit', 'http://www.tromp.inf', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (80, 'Similique adipisci s', 'http://barrows.com/', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (82, 'Atque non ut dolore ', 'http://mcglynnwunsch', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (90, 'Inventore adipisci q', 'http://www.connellya', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (91, 'Asperiores velit vol', 'http://www.barrowspr', NULL);
INSERT INTO `video` (`id`, `title`, `url`, `video_length`)
VALUES (94, 'Sequi eius cupiditat', 'http://tromp.com/', NULL);



INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (1, 2, 2);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (2, 3, 4);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (3, 11, 1);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (4, 21, 2);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (5, 22, 5);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (6, 29, 2);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (7, 30, 3);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (8, 31, 4);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (9, 33, 5);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (10, 35, 1);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (11, 48, 1);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (12, 56, 3);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (13, 66, 3);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (14, 72, 2);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (15, 73, 5);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (16, 80, 4);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (17, 82, 4);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (18, 90, 3);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (19, 91, 3);
INSERT INTO `post_video` (`post_id`, `video_id`, `index`)
VALUES (20, 94, 5);

SELECT post.id,
       post.title,
       post.description,
       post.writer_id,
       post.status,
       post.created_at,
       post.view_count,
       post.updated_at
#        tag.id      as tag_id,
#        tag.name    as tag_name,
#        tag.id      as tag_id,
#        tag.name    as tag_name,
#        video.id    as video_id,
#        video.title as video_title,
#        video.url   as video_url,
#        video_length,
#        post_video.index,
#        visited_post.visited_at,
#        post_age_range.age_range,
#        post_body_part.body_part,
#        post_strength.strength
FROM post
         LEFT JOIN visited_post on post.id = visited_post.post_id
         LEFT JOIN post_tag on post.id = post_tag.post_id
         LEFT JOIN tag on post_tag.tag_id = tag.id
         LEFT JOIN post_video on post.id = post_video.post_id
         LEFT JOIN video on post_video.video_id = video.id
         LEFT JOIN post_age_range on post.id = post_age_range.post_id
         LEFT JOIN post_body_part on post.id = post_body_part.post_id
         LEFT JOIN post_strength on post.id = post_strength.post_id
WHERE visited_post.user_id = 'admin';

UPDATE post
SET view_count = view_count + 1
WHERE id = 2;

select *
from post
where post.status != 'disabled'
  and post.id in (select post_id
                  from visited_post vp
                  where vp.user_id = 'user2'
                    and vp.post_id = post.id
                  order by vp.visited_at)
;

select *
from visited_post;


SELECT post.id,
       post.title,
       post.description,
       post.writer_id,
       post.writer_name,
       post.status,
       post.created_at,
       post.view_count,
       post.updated_at,
       tag.id           as tag_id,
       tag.name         as tag_name,
       video.id         as video_id,
       video.title      as video_title,
       video.url        as video_url,
       video_length,
       post_video.index as video_index,
       post_age_range.age_range,
       post_body_part.body_part,
       post_strength.strength
from (select v_post.post_id, v_post.visited_at, post.*
      from post,
           (select user_id,
                   post_id,
                   visited_at,
                   ROW_NUMBER() over (PARTITION BY vp.post_id order by vp.post_id desc) as RN
            from visited_post vp) as v_post
      where status != 'disabled'
        and post.writer_id != 'user2'
        and v_post.user_id = 'user2'
        and v_post.post_id = post.id
        and RN = 1
      order by v_post.visited_at
      limit 5) as post
         LEFT JOIN post_tag on post.id = post_tag.post_id
         LEFT JOIN tag on post_tag.tag_id = tag.id
         LEFT JOIN post_video on post.id = post_video.post_id
         LEFT JOIN video on post_video.video_id = video.id
         LEFT JOIN post_age_range on post.id = post_age_range.post_id
         LEFT JOIN post_body_part on post.id = post_body_part.post_id
         LEFT JOIN post_strength on post.id = post_strength.post_id;

select v_post.post_id, v_post.visited_at, post.*
from post,
     (select user_id,
             post_id,
             visited_at,
             ROW_NUMBER() over (PARTITION BY vp.post_id order by vp.post_id desc) as RN
      from visited_post vp) as v_post
where status != 'disabled'
  and post.writer_id != 'user2'
  and v_post.user_id = 'user2'
  and v_post.post_id = post.id
  and RN = 1
order by v_post.visited_at
limit 5