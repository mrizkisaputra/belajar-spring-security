create table s_roles
(
    id varchar(255) not null,
    name varchar(255) not null,
    unique (name),
    primary key (id)
);

create table s_users
(
    id varchar(255) not null,
    id_role varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    active boolean,
    unique (username),
    primary key (id),
    foreign key (id_role) references s_roles(id)
);

create table s_permissions
(
    id varchar(255) not null,
    permission_value varchar(255) not null,
    permission_label varchar(255) not null,
    unique (permission_value),
    primary key (id)
);

create table s_roles_permissions
(
    id_role varchar(255),
    id_permission varchar(255),
    primary key (id_role, id_permission),
    foreign key (id_permission) references s_permissions(id),
    foreign key (id_role) references s_roles(id)
);