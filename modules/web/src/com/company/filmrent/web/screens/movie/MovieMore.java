package com.company.filmrent.web.screens.movie;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.movie.Movie;

@UiController("filmrent_Movie.more")
@UiDescriptor("movie-more.xml")
@EditedEntityContainer("movieDc")
@LoadDataBeforeShow
public class MovieMore extends StandardEditor<Movie> {
}