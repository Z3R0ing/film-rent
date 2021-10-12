package com.company.filmrent.web.screens.movie;

import com.company.filmrent.entity.genres.Genre;
import com.company.filmrent.entity.library.Library;
import com.company.filmrent.entity.movie.Movie;
import com.company.filmrent.service.GenresService;
import com.company.filmrent.service.MoviesService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@UiController("filmrent_Movies")
@UiDescriptor("movies.xml")
public class Movies extends Screen {

    @Inject
    private GenresService genresService;
    @Inject
    private MoviesService moviesService;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private Fragments fragments;
    @Inject
    private UiComponents uiComponents;
    @Inject
    private VBoxLayout vbox;
    @Inject
    private HBoxLayout genresBox;

    private List<Movie> movies;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        initGenresButton();
        initGridWithFilms();
    }

    private void initGenresButton() {
        genresService.getUsedGenres().forEach(genre -> {
            Button button = uiComponents.create(Button.class);
            button.setCaption(genre.getTitle());
            button.addClickListener(clickEvent -> {
                Movies movies = screenBuilders.screen(this).withScreenClass(Movies.class).withOpenMode(OpenMode.NEW_TAB).build();
                movies.setMovies(moviesService.getMoviesByGenres(genre));
                movies.setCaption(genre.getTitle());
                movies.show();
            });
            genresBox.add(button);
        });
    }

    private void initGridWithFilms() {
        int gridSize = (movies.size() / 2) + 1;
        gridSize = Math.max(gridSize, 4);
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