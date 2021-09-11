package com.company.filmrent.web.screens.movie;

import com.company.filmrent.entity.movie.Movie;
import com.company.filmrent.service.MoviesService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@UiController("filmrent_Movies")
@UiDescriptor("movies.xml")
public class Movies extends Screen {

    @Inject
    private Fragments fragments;
    @Inject
    private UiComponents uiComponents;
    @Inject
    private VBoxLayout vbox;

    private List<Movie> movies;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        int gridSize = (movies.size() / 2) + 1;
        gridSize = (gridSize < 3) ? 3 : gridSize;
        GridLayout gridLayout = uiComponents.create(GridLayout.class);
        gridLayout.setRows(gridSize);
        gridLayout.setColumns(gridSize);
        int elCounter = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (elCounter < movies.size()) {
                    MovieCard movieCard = fragments.create(this, MovieCard.class);
                    movieCard.setMovie(movies.get(elCounter));
                    gridLayout.add(movieCard.getFragment(), col, row);
                    elCounter++;
                } else {
                    break;
                }
            }
        }
        gridLayout.setSpacing(true);
        vbox.add(gridLayout);
        vbox.expand(gridLayout);
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void setCaption(String caption) {
        this.getWindow().setCaption(caption);
    }
}