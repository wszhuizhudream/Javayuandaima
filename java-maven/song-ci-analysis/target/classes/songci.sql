create database if not exists songci;
use songci;
create table if not exists songci_info(
  title varchar(64) not null,
  dynasty varchar(32) not null,
  author varchar(12) not null,
  content varchar(1024) not null
);