alter table users add phoneNumber varchar(20) not null;
alter table users add active boolean not null default true;
alter table users add personalDocument varchar(11) not null;