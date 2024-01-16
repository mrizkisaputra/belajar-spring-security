create table majors
(
    id varchar(255) not null,
    name varchar(255) not null,
    primary key (id)
);

create table students
(
    id varchar(11) not null,
    name varchar(255) not null,
    id_major varchar(255),
    foreign key (id_major) references majors(id),
    primary key (id)
);