#Screens
Main page
![Main page](screenshots/main.png "Main page")
Login page
![Login page](screenshots/login.png "Login page")
Films view
![Films view](screenshots/filmsView.png "Films view")
Film card
![Film card](screenshots/filmAbout.png "Film card")
Films list
![Films list](screenshots/films.png "Films list")
Edit film
![Edit film](screenshots/filmEdit.png "Edit film")
Critic card
![Critic card](screenshots/criticAbout.png "Critic card")
Critics list
![Critics list](screenshots/critics.png "Critics list")
Critic edit
![Critic edit](screenshots/criticsEdit.png "Critic edit")
Library view
![Library view](screenshots/libraryView.png "Library view")
Library list
![Library list](screenshots/libraryList.png "Library edit")
Library edit
![Library list](screenshots/libraryEdit.png "Library edit")

#SQL scripts

```sql
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
alter table LocalUser add constraint FK_LOCALUSER_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
create index IDX_LOCALUSER_ON_USER on LocalUser (USER_ID)^
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
alter table Library add constraint FK_LIBRARY_ON_ID_USER foreign key (ID_USER) references LocalUser(ID)^
alter table Library add constraint FK_LIBRARY_ON_ID_MOVIE foreign key (ID_MOVIE) references Movies(ID)^
create index IDX_LIBRARY_ON_ID_USER on Library (ID_USER)^
create index IDX_LIBRARY_ON_ID_MOVIE on Library (ID_MOVIE)^
-- end LIBRARY
```