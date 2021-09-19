-- begin LOCALUSER
alter table LocalUser add constraint FK_LOCALUSER_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
create index IDX_LOCALUSER_ON_USER on LocalUser (USER_ID)^
-- end LOCALUSER
-- begin LIBRARY
alter table Library add constraint FK_LIBRARY_ON_ID_USER foreign key (ID_USER) references LocalUser(ID)^
alter table Library add constraint FK_LIBRARY_ON_ID_MOVIE foreign key (ID_MOVIE) references Movies(ID)^
create index IDX_LIBRARY_ON_ID_USER on Library (ID_USER)^
create index IDX_LIBRARY_ON_ID_MOVIE on Library (ID_MOVIE)^
-- end LIBRARY
-- begin MOVIE_GENRES
alter table Movie_genres add constraint FK_MOVIE_GENRES_ON_MOVIE foreign key (MOVIE_ID) references Movies(ID)^
alter table Movie_genres add constraint FK_MOVIE_GENRES_ON_GENRE foreign key (GENRE_ID) references Genres(ID)^
create index IDX_MOVIE_GENRES_ON_MOVIE on Movie_genres (MOVIE_ID)^
create index IDX_MOVIE_GENRES_ON_GENRE on Movie_genres (GENRE_ID)^
-- end MOVIE_GENRES
-- begin FILMRENT_MOVIE_CAST
alter table FILMRENT_MOVIE_CAST add constraint FK_FILMRENT_MOVIE_CAST_ON_MOVIE foreign key (MOVIE_ID) references Movies(ID)^
alter table FILMRENT_MOVIE_CAST add constraint FK_FILMRENT_MOVIE_CAST_ON_ACTOR foreign key (ACTOR_ID) references FILMRENT_ACTOR(ID)^
create index IDX_FILMRENT_MOVIE_CAST_ON_MOVIE on FILMRENT_MOVIE_CAST (MOVIE_ID)^
create index IDX_FILMRENT_MOVIE_CAST_ON_ACTOR on FILMRENT_MOVIE_CAST (ACTOR_ID)^
-- end FILMRENT_MOVIE_CAST
