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
    User_rang integer not null,
    User_id uuid not null,
    --
    primary key (ID)
)^
-- end LOCALUSER
-- begin LIBRARY
create table Library (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    Id_user uuid not null,
    Id_movie uuid not null,
    isLooked boolean not null,
    --
    primary key (ID)
)^
-- end LIBRARY
-- begin GENRES
create table Genres (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    Genre_title varchar(255) not null,
    --
    primary key (ID)
)^
-- end GENRES
-- begin MOVIE_GENRES
create table Movie_genres (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    Movie_id uuid not null,
    Genre_id uuid not null,
    --
    primary key (ID)
)^
-- end MOVIE_GENRES
-- begin FILMRENT_ACTOR
create table FILMRENT_ACTOR (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    Actor_firstname varchar(255),
    Actor_lastname varchar(255),
    Actor_gender varchar(255),
    --
    primary key (ID)
)^
-- end FILMRENT_ACTOR
-- begin FILMRENT_MOVIE_CAST
create table FILMRENT_MOVIE_CAST (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    Movie_id uuid not null,
    Actor_id uuid not null,
    --
    primary key (ID)
)^
-- end FILMRENT_MOVIE_CAST
