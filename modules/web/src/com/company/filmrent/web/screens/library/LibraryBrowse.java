package com.company.filmrent.web.screens.library;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.library.Library;

@UiController("filmrent_Library.browse")
@UiDescriptor("library-browse.xml")
@LookupComponent("librariesTable")
@PrimaryLookupScreen(Library.class)
@LoadDataBeforeShow
public class LibraryBrowse extends StandardLookup<Library> {
}