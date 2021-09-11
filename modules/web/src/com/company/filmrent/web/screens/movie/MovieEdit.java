package com.company.filmrent.web.screens.movie;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.movie.Movie;

@UiController("filmrent_Movie.edit")
@UiDescriptor("movie-edit.xml")
@EditedEntityContainer("movieDc")
@LoadDataBeforeShow
public class MovieEdit extends StandardEditor<Movie> {
}