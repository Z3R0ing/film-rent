package com.company.filmrent.web.screens.genre;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.genres.Genre;

@UiController("filmrent_Genre.edit")
@UiDescriptor("genre-edit.xml")
@EditedEntityContainer("genreDc")
@LoadDataBeforeShow
public class GenreEdit extends StandardEditor<Genre> {
}