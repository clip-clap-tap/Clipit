CREATE DATABASE `clipit`;

USE `clipit`;

CREATE TABLE `user` (
  `id` varchar(20) UNIQUE PRIMARY KEY NOT NULL,
  `username` varchar(20) NOT NULL,
  `created_at` timestamp NOT NULL default current_timestamp,
  `password` varchar(20) NOT NULL,
  `status` varchar(20) DEFAULT 'active'
);

CREATE TABLE `video` (
  `id` integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `title` varchar(20),
  `url` varchar(20),
  `video_length` integer
);

CREATE TABLE `tag` (
  `id` integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `category` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL
);

CREATE TABLE `routine` (
  `id` integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

CREATE TABLE `user_info` (
  `user_id` varchar(20) UNIQUE PRIMARY KEY NOT NULL,
  `gender` varchar(20),
  `height` float,
  `weight` float,
  `age` integer,
  `goal` text,
  CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

CREATE TABLE `post` (
  `id` integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `description` text,
  `writer_id` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'public',
  `created_at` timestamp NOT NULL default current_timestamp,
  `view_count` integer NOT NULL DEFAULT 0,
  `routine_id` integer NOT NULL,
  `updated_at` timestamp not null default current_timestamp on update current_timestamp,
  CONSTRAINT FOREIGN KEY (`writer_id`) REFERENCES `user` (`id`),
  CONSTRAINT FOREIGN KEY (`routine_id`) REFERENCES `routine` (`id`)
);

CREATE TABLE `favorite_post` (
  `user_id` varchar(20) UNIQUE NOT NULL,
  `post_id` integer UNIQUE NOT NULL,
  PRIMARY KEY (`user_id`, `post_id`),
  CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
);

CREATE TABLE `favorite_tag` (
  `user_id` varchar(20) UNIQUE NOT NULL,
  `tag_id` integer UNIQUE NOT NULL,
  PRIMARY KEY (`user_id`, `tag_id`),
  CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)
  
);

CREATE TABLE `visited_post` (
  `id` integer PRIMARY KEY,
  `user_id` varchar(20),
  `post_id` integer,
  `visited_date` timestamp default current_timestamp,
  CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
);

CREATE TABLE `routine_video` (
  `routine_id` integer UNIQUE NOT NULL,
  `video_id` integer UNIQUE NOT NULL,
  `title` varchar(20),
  `index` integer,
  PRIMARY KEY (`routine_id`, `video_id`),
  CONSTRAINT FOREIGN KEY (`routine_id`) REFERENCES `routine` (`id`),
  CONSTRAINT FOREIGN KEY (`video_id`) REFERENCES `video` (`id`)
);

CREATE TABLE `mark_video` (
  `user_id` varchar(20) UNIQUE NOT NULL,
  `video_id` integer UNIQUE NOT NULL,
  `marked_date` timestamp default current_timestamp,
  PRIMARY KEY (`user_id`, `video_id`),
  CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT FOREIGN KEY (`video_id`) REFERENCES `video` (`id`)
);

CREATE TABLE `video_tag` (
  `video_id` integer UNIQUE NOT NULL,
  `tag_id` integer UNIQUE NOT NULL,
  PRIMARY KEY (`video_id`, `tag_id`),
  CONSTRAINT FOREIGN KEY (`video_id`) REFERENCES `video` (`id`),
  CONSTRAINT FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)
);

CREATE TABLE `comment` (
  `id` integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `post_id` integer NOT NULL,
  `writer_id` varchar(20) NOT NULL,
  `content` text NOT NULL,
  CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
  CONSTRAINT FOREIGN KEY (`writer_id`) REFERENCES `user` (`id`)
);

SHOW TABLES;
