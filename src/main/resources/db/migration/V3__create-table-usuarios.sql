create table usuario (
    id bigint not null auto_increment,
    login varchar(255) not null,
    email varchar(255) not null,
    senha varchar(255) not null,
    primary key (id)
);