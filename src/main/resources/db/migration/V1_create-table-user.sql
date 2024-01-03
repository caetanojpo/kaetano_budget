create table users(

    id bigint not null auto_increment,
    email varchar(100) not null unique,
    username varchar(100) not null unique,
    password varchar(255) not null,
    firstName varchar(100) not null,
    lastName varchar(255) not null,
    birth date,
    street varchar(100) not null,
    number varchar(20) not null,
    complement varchar(100),
    neighborhood varchar(100) not null,
    postalCode varchar(9) not null,
    city varchar(100) not null,
    state varchar(2) not null,
    country varchar(100) not null,

    primary key(id)

)