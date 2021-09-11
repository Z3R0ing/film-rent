package com.company.filmrent.web.screens.movie;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.movie.Movie;

@UiController("filmrent_Movie.browse")
@UiDescriptor("movie-browse.xml")
@LookupComponent("moviesTable")
@LoadDataBeforeShow
public class MovieBrowse extends StandardLookup<Movie> {
}