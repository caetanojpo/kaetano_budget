alter table users drop column active;
alter table users add userStatus varchar(20) not null DEFAULT 'ACTIVE';
alter table users add createDateTime timestamp;
alter table users add updateDateTime timestamp;