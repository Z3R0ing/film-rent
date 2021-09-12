package com.company.filmrent.web.screens.moviegenre;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.genres.MovieGenre;

@UiController("filmrent_MovieGenre.edit")
@UiDescriptor("movie-genre-edit.xml")
@EditedEntityContainer("movieGenreDc")
@LoadDataBeforeShow
public class MovieGenreEdit extends StandardEditor<MovieGenre> {
}