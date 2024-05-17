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

CREATE TABLE IF NOT EXISTS `user_profile`
(
    `id`     varchar(20) UNIQUE PRIMARY KEY NOT NULL,
    `gender` varchar(20),
    `height` float,
    `weight` float,
    `age`    integer,
    `goal`   text,
    CONSTRAINT FOREIGN KEY (`id`) REFERENCES `user_info` (`id`) on delete cascade
);


CREATE TABLE IF NOT EXISTS `post`
(
    `id`          integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `title`       varchar(20)                NOT NULL,
    `description` text,
    `writer_id`   varchar(20)                NOT NULL,
    `writer_name` varchar(20)                NOT NULL,
    `status`      varchar(20)                NOT NULL DEFAULT 'public',
    `created_at`  timestamp                  NOT NULL default current_timestamp,
    `view_count`  integer                    NOT NULL DEFAULT 0,
    `updated_at`  timestamp                  not null default current_timestamp on update current_timestamp,
    CONSTRAINT FOREIGN KEY (`writer_id`) REFERENCES `user_info` (`id`) on delete cascade
);

CREATE TABLE IF NOT EXISTS `video`
(
    `id`           varchar(20) UNIQUE PRIMARY KEY NOT NULL,
    `title`        varchar(200),
    `url`          varchar(100),
    `video_length` integer
);

CREATE TABLE IF NOT EXISTS `tag`
(
    `id`   integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` varchar(20) UNIQUE         NOT NULL

);

CREATE TABLE IF NOT EXISTS `post_age_range`
(
    `post_id`   integer NOT NULL,
    `age_range` integer,
    FOREIGN KEY (`post_id`) references post (`id`) on delete cascade,
    PRIMARY KEY (`post_id`, `age_range`)
);

CREATE TABLE IF NOT EXISTS `post_body_part`
(
    `post_id`   integer NOT NULL,
    `body_part` VARCHAR(20),
    FOREIGN KEY (`post_id`) references post (`id`) on delete cascade,
    PRIMARY KEY (`post_id`, `body_part`)
);

CREATE TABLE IF NOT EXISTS `post_strength`
(
    `post_id`  integer UNIQUE PRIMARY KEY NOT NULL,
    `strength` integer,
    FOREIGN KEY (`post_id`) references post (`id`) on delete cascade
);


CREATE TABLE IF NOT EXISTS `favorite_post`
(
    `user_id` varchar(20) NOT NULL,
    `post_id` integer     NOT NULL,
    PRIMARY KEY (`user_id`, `post_id`),
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) on delete cascade,
    CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) on delete cascade
);

CREATE TABLE IF NOT EXISTS `favorite_tag`
(
    `user_id` varchar(20) NOT NULL,
    `tag_id`  integer     NOT NULL,
    PRIMARY KEY (`user_id`, `tag_id`),
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) on delete cascade,
    CONSTRAINT FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) on delete cascade

);

CREATE TABLE IF NOT EXISTS `visited_post`
(
    `id`         integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `user_id`    varchar(20),
    `post_id`    integer,
    `visited_at` timestamp default current_timestamp,
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) on delete cascade,
    CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) on delete cascade
);

CREATE TABLE IF NOT EXISTS `post_video`
(
    `post_id`  integer     NOT NULL,
    `video_id` varchar(20) NOT NULL,
    `index`    integer,
    PRIMARY KEY (`post_id`, `video_id`),
    CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) on delete cascade,
    CONSTRAINT FOREIGN KEY (`video_id`) REFERENCES `video` (`id`) on delete cascade
);

CREATE TABLE IF NOT EXISTS `mark_video`
(
    `user_id`   varchar(20) NOT NULL,
    `video_id`  varchar(20) NOT NULL,
    `marked_at` timestamp default current_timestamp,
    PRIMARY KEY (`user_id`, `video_id`),
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) on delete cascade,
    CONSTRAINT FOREIGN KEY (`video_id`) REFERENCES `video` (`id`) on delete cascade
);

CREATE TABLE IF NOT EXISTS `post_tag`
(
    `post_id` integer NOT NULL,
    `tag_id`  integer NOT NULL,
    PRIMARY KEY (`post_id`, `tag_id`),
    CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) on delete cascade,
    CONSTRAINT FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) on delete cascade
);

CREATE TABLE IF NOT EXISTS `comment`
(
    `id`        integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `post_id`   integer             NOT NULL,
    `writer_id` varchar(20)         NOT NULL,
    `content`   text                NOT NULL,
    CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) on delete cascade,
    CONSTRAINT FOREIGN KEY (`writer_id`) REFERENCES `user_info` (`id`) on delete cascade
);

