DROP DATABASE clipit;
CREATE DATABASE IF NOT EXISTS clipit;
USE clipit;

CREATE TABLE IF NOT EXISTS `user_info`
(
    `id`         varchar(20) UNIQUE PRIMARY KEY NOT NULL,
    `username`   varchar(20)                    NOT NULL,
    `created_at` timestamp                      NOT NULL default current_timestamp,
    `password`   varchar(20)                    NOT NULL,
    `status`     varchar(20)                             DEFAULT 'active'
);

CREATE TABLE IF NOT EXISTS `video`
(
    `id`           integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `title`        varchar(20),
    `url`          varchar(20),
    `video_length` integer
);

CREATE TABLE IF NOT EXISTS `tag`
(
    `id`       integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `category` varchar(20)                NOT NULL,
    `name`     varchar(20)                NOT NULL
);


CREATE TABLE IF NOT EXISTS `user_profile`
(
    `id`     varchar(20) UNIQUE PRIMARY KEY NOT NULL,
    `gender` varchar(20),
    `height` float,
    `weight` float,
    `age`    integer,
    `goal`   text,
    CONSTRAINT FOREIGN KEY (`id`) REFERENCES `user_info` (`id`)
);

CREATE TABLE IF NOT EXISTS `post`
(
    `id`          integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `title`       varchar(20)                NOT NULL,
    `description` text,
    `writer_id`   varchar(20)                NOT NULL,
    `status`      varchar(20)                NOT NULL DEFAULT 'public',
    `created_at`  timestamp                  NOT NULL default current_timestamp,
    `view_count`  integer                    NOT NULL DEFAULT 0,
    `updated_at`  timestamp                  not null default current_timestamp on update current_timestamp,
    CONSTRAINT FOREIGN KEY (`writer_id`) REFERENCES `user_info` (`id`)
);

CREATE TABLE IF NOT EXISTS `favorite_post`
(
    `user_id` varchar(20) NOT NULL,
    `post_id` integer     NOT NULL,
    PRIMARY KEY (`user_id`, `post_id`),
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
    CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
);

CREATE TABLE IF NOT EXISTS `favorite_tag`
(
    `user_id` varchar(20) NOT NULL,
    `tag_id`  integer     NOT NULL,
    PRIMARY KEY (`user_id`, `tag_id`),
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
    CONSTRAINT FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)

);

CREATE TABLE IF NOT EXISTS `visited_post`
(
    `id`           integer PRIMARY KEY,
    `user_id`      varchar(20),
    `post_id`      integer,
    `visited_date` timestamp default current_timestamp,
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
    CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
);

CREATE TABLE IF NOT EXISTS `post_video`
(
    `post_id`  integer NOT NULL,
    `video_id` integer NOT NULL,
    `title`    varchar(20),
    `index`    integer,
    PRIMARY KEY (`post_id`, `video_id`),
    CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
    CONSTRAINT FOREIGN KEY (`video_id`) REFERENCES `video` (`id`)
);

CREATE TABLE IF NOT EXISTS `mark_video`
(
    `user_id`     varchar(20) NOT NULL,
    `video_id`    integer     NOT NULL,
    `marked_date` timestamp default current_timestamp,
    PRIMARY KEY (`user_id`, `video_id`),
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
    CONSTRAINT FOREIGN KEY (`video_id`) REFERENCES `video` (`id`)
);

CREATE TABLE IF NOT EXISTS `video_tag`
(
    `video_id` integer NOT NULL,
    `tag_id`   integer NOT NULL,
    PRIMARY KEY (`video_id`, `tag_id`),
    CONSTRAINT FOREIGN KEY (`video_id`) REFERENCES `video` (`id`),
    CONSTRAINT FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)
);

CREATE TABLE IF NOT EXISTS `comment`
(
    `id`        integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `post_id`   integer             NOT NULL,
    `writer_id` varchar(20)         NOT NULL,
    `content`   text                NOT NULL,
    CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
    CONSTRAINT FOREIGN KEY (`writer_id`) REFERENCES `user_info` (`id`)
);

SHOW TABLES;

UPDATE post
SET status = 'private'
WHERE id = 1;