-- begin LOCALUSER
alter table LocalUser add constraint FK_LOCALUSER_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
create index IDX_LOCALUSER_ON_USER on LocalUser (USER_ID)^
-- end LOCALUSER
