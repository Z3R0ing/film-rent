package com.company.filmrent.web.screens.library;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.library.Library;

@UiController("filmrent_Library.edit")
@UiDescriptor("library-edit.xml")
@EditedEntityContainer("libraryDc")
@LoadDataBeforeShow
public class LibraryEdit extends StandardEditor<Library> {
}