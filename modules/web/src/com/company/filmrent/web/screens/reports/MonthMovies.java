package com.company.filmrent.web.screens.reports;

import com.company.filmrent.entity.movie.Movie;
import com.company.filmrent.entity.user.Critic;
import com.company.filmrent.service.CriticService;
import com.company.filmrent.service.LibraryService;
import com.company.filmrent.web.screens.movie.MovieCard;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.actions.list.ExcelAction;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import javax.inject.Named;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@UiController("filmrent_MonthMovies")
@UiDescriptor("month-movies.xml")
public class MonthMovies extends Screen {

    @Inject
    private UiComponents uiComponents;
    @Inject
    private Fragments fragments;
    @Inject
    private TimeSource timeSource;
    @Inject
    private Messages messages;
    @Inject
    private CriticService criticService;
    @Inject
    private LibraryService libraryService;
    @Inject
    private CollectionLoader<Movie> moviesDl;
    @Inject
    private CollectionContainer<Movie> moviesDc;
    @Inject
    private VBoxLayout vbox;
    @Inject
    private Table<Movie> forExport;
    @Named("forExport.excel")
    private ExcelAction forExportExcel;
    @Inject
    private Label<String> moviesCount;

    private Critic critic = null;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        // set file name to export
        forExportExcel.setFileName(messages.getMessage(this.getClass(), "monthMovies.caption"));
        // sets parameters for query
        critic = criticService.getCurrentCritic();
        moviesDl.setParameter("critic", critic);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeSource.currentTimestamp());
        calendar.add(Calendar.MONTH, -1);
        moviesDl.setParameter("monthAgo", calendar.getTime());
        getScreenData().loadAll();
        // Make visual movies list
        List<Movie> movies = moviesDc.getItems();
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
        // set count of movies
        moviesCount.setValue(moviesCount.getRawValue().concat(" " + movies.size()));
        // Make column in export table with date of looked
        forExport.addGeneratedColumn("whenLooked", new Table.PrintableColumnGenerator<Movie, String>() {
            @Override
            public Component generateCell(Movie entity) {
                DateFormat df = new SimpleDateFormat("dd MMM yyyy");
                return new Table.PlainTextCell(df.format(libraryService.getMovieInLibrary(entity, critic).getUpdateTs()));
            }

            @Override
            public String getValue(Movie entity) {
                DateFormat df = new SimpleDateFormat("dd MMM yyyy");
                return df.format(libraryService.getMovieInLibrary(entity, critic).getUpdateTs());
            }
        });
    }
    
}