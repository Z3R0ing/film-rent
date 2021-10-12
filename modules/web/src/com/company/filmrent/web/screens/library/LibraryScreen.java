package com.company.filmrent.web.screens.library;

import com.company.filmrent.entity.user.Critic;
import com.company.filmrent.service.CriticService;
import com.company.filmrent.web.screens.movie.MovieCard;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.library.Library;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@UiController("filmrent_library")
@UiDescriptor("library.xml")
public class LibraryScreen extends Screen {

    @Inject
    private CollectionLoader<Library> librariesDl;
    @Inject
    private CriticService criticService;
    @Inject
    private Messages messages;
    @Inject
    private CollectionContainer<Library> librariesDc;
    @Inject
    private UiComponents uiComponents;
    @Inject
    private Fragments fragments;
    @Inject
    private GroupBoxLayout lookedBox;
    @Inject
    private GroupBoxLayout unlookedBox;
    @Inject
    private Label<String> criticName;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        Critic lookedCritic = criticService.getCurrentCritic();
        Critic libraryCritic = (Critic) librariesDl.getParameter("critic");
        if (libraryCritic == null) {
            setCritic(lookedCritic);
            libraryCritic = (Critic) librariesDl.getParameter("critic");
        }
        if (lookedCritic.equals(libraryCritic)) {
            getWindow().setCaption(messages.getMessage(this.getClass(), "libraryScreen.caption"));
        } else {
            getWindow().setCaption(messages.formatMessage(this.getClass(), "libraryScreen.captionOther", libraryCritic.getUser().getLogin()));
        }
        librariesDl.load();
        criticName.setValue(messages.formatMessage(this.getClass(), "libraryScreen.captionOther", libraryCritic.getUser().getLogin()));
        List<Library> moviesInLibrary = librariesDc.getItems();
        List<Library> looked = moviesInLibrary.stream()
                .filter(Library::getIsLooked)
                .collect(Collectors.toList());
        List<Library> unlooked = moviesInLibrary.stream()
                .filter(library -> !library.getIsLooked())
                .collect(Collectors.toList());
        initGridWithFilms(looked, lookedBox);
        initGridWithFilms(unlooked, unlookedBox);
    }


    private void initGridWithFilms(List<Library> moviesInLibrary, OrderedContainer parent) {
        int gridSize = (moviesInLibrary.size() / 2) + 1;
        gridSize = (gridSize < 4) ? 4 : gridSize;
        GridLayout gridLayout = uiComponents.create(GridLayout.class);
        gridLayout.setRows(gridSize);
        gridLayout.setColumns(gridSize);
        int elCounter = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (elCounter < moviesInLibrary.size()) {
                    MovieCard movieCard = fragments.create(this, MovieCard.class);
                    movieCard.setMovie(moviesInLibrary.get(elCounter).getMovie());
                    gridLayout.add(movieCard.getFragment(), col, row);
                    elCounter++;
                } else {
                    break;
                }
            }
        }
        gridLayout.setSpacing(true);
        parent.add(gridLayout);
    }

    public void setCritic(Critic critic) {
        librariesDl.setParameter("critic", critic);
    }

}