insert into s_roles(id, name)
values ('R001', 'ROLE_ADMIN');

insert into s_roles(id, name)
values ('R002', 'ROLE_ADMINISTRANE');

insert into s_roles(id, name)
values ('R003', 'ROLE_STUDENTS');


insert into s_users(id, id_role, username, password, active)
values ('U001', 'R003', '2019110024', '$2a$12$ShtRwB.rK.sGTM3NjsYuYelDS63VilV49xwK51AwsNP3wsevXu9gm', true);

insert into s_users(id, id_role, username, password, active)
values ('U002', 'R001', 'admin', '$2a$12$hn8xGyje1R8tbk3nyBRw0eQraIKWfm0xaF2sAnb9Q4RgJrckxTso.', true);

insert into s_users(id, id_role, username, password, active)
values ('U003', 'R002', 'administrane', '$2a$12$ic73yL2AL9U6c.PUnvst8uqPXRF/GrWUda04odOuxYZaTfHsEzxcK', true);


insert into s_permissions(id, permission_value, permission_label)
values ('P001', 'STUDENT:READ', 'Read Students');

insert into s_permissions(id, permission_value, permission_label)
values ('P002', 'STUDENT:WRITE', 'Write Students');

insert into s_permissions(id, permission_value, permission_label)
values ('P003', 'COURSE:READ', 'Read Courses');

insert into s_permissions(id, permission_value, permission_label)
values ('P004', 'COURSE:WRITE', 'Write Courses');


insert into s_roles_permissions(id_role, id_permission)
values ('R001', 'P001');

insert into s_roles_permissions(id_role, id_permission)
values ('R001', 'P002');

insert into s_roles_permissions(id_role, id_permission)
values ('R001', 'P003');

insert into s_roles_permissions(id_role, id_permission)
values ('R001', 'P004');

insert into s_roles_permissions(id_role, id_permission)
values ('R002', 'P001');

insert into s_roles_permissions(id_role, id_permission)
values ('R003', 'P003');
