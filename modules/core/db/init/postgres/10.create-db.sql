-- begin MOVIES
create table Movies (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    Movie_title varchar(255) not null,
    Movie_time integer not null,
    Movie_data_release date not null,
    Num_of_rating integer not null,
    --
    primary key (ID)
)^
-- end MOVIES
-- begin LOCALUSER
create table LocalUser (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    User_rang integer,
    User_id uuid,
    --
    primary key (ID)
)^
-- end LOCALUSER
