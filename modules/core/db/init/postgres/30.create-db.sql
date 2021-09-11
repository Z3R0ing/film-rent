insert into SEC_ROLE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, LOC_NAME, DESCRIPTION, ROLE_TYPE, IS_DEFAULT_ROLE, SYS_TENANT_ID, SECURITY_SCOPE)
values ('5fef97c8-77c8-5354-3288-a261ffe5944e', 1, '2021-09-11 23:28:58', 'admin', '2021-09-11 23:30:18', 'admin', null, null, 'Anonymous', null, null, 0, null, null, 'GENERIC_UI');

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_, ROLE_ID)
values ('f248d4c4-e851-bf35-7140-27dc3180625e', 1, '2021-09-12 01:10:32', 'admin', '2021-09-12 01:10:32', null, null, null, 10, 'extMainScreen', 1, '5fef97c8-77c8-5354-3288-a261ffe5944e');

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_, ROLE_ID)
values ('6425d93b-0037-6c06-0914-eeb3ab37b18c', 1, '2021-09-11 23:28:58', 'admin', '2021-09-11 23:28:58', null, null, null, 10, 'login', 1, '5fef97c8-77c8-5354-3288-a261ffe5944e');

insert into SEC_USER_ROLE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, USER_ID, ROLE_ID, ROLE_NAME)
values ('207a54a7-d134-9fbb-6f0d-65552a73caa7', 1, '2021-09-11 23:31:03', 'admin', '2021-09-11 23:31:03', null, null, null, 'a405db59-e674-4f63-8afe-269dda788fe8', '5fef97c8-77c8-5354-3288-a261ffe5944e', null);
