CREATE TABLE comment
(
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    parent_id bigint NOT NULL,
    type int NOT NULL,
    commentator bigint NOT NULL,
    comment varchar(1024) ,
    gmt_create bigint NOT NULL,
    gmt_modified bigint NOT NULL,
    like_count bigint DEFAULT 0 NOT NULL
);