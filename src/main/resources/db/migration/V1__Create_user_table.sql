create table user
(
  id bigint auto_increment primary key,
  bio varchar(256) null,
  avatar varchar(256) null,
  account_id   varchar(100) null,
  name         varchar(50)  null,
  token        varchar(36)     null,
  gmt_create   bigint      null,
  gmt_modified bigint      null
);
