package com.company.filmrent.web.screens.moviecast;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.actor.MovieCast;

@UiController("filmrent_MovieCast.edit")
@UiDescriptor("movie-cast-edit.xml")
@EditedEntityContainer("movieCastDc")
@LoadDataBeforeShow
public class MovieCastEdit extends StandardEditor<MovieCast> {
}