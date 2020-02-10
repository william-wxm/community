CREATE TABLE question
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title varchar(50),
    description text,
    gmt_create bigint,
    gmt_modified bigint,
    creator bigint,
    comment_count bigint DEFAULT 0,
    view_count bigint DEFAULT 0,
    like_count bigint DEFAULT 0,
    tag varchar(256)
);