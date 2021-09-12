package com.company.filmrent.web.screens.genre;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.genres.Genre;

@UiController("filmrent_Genre.browse")
@UiDescriptor("genre-browse.xml")
@LookupComponent("genresTable")
@LoadDataBeforeShow
public class GenreBrowse extends StandardLookup<Genre> {
}