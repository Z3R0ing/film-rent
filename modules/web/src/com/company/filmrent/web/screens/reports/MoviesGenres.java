package com.company.filmrent.web.screens.reports;

import com.company.filmrent.entity.genres.MovieGenre;
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
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.GridLayout;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.VBoxLayout;
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

@UiController("filmrent_MoviesGenres")
@UiDescriptor("movies-genres.xml")
public class MoviesGenres extends Screen {

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
    private CollectionLoader<MovieGenre> movieGenresDl;
    @Inject
    private CollectionContainer<MovieGenre> movieGenresDc;
    @Inject
    private Table<MovieGenre> forExport;
    @Named("forExport.excel")
    private ExcelAction forExportExcel;

    Critic critic = null;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        // set file name to export
        forExportExcel.setFileName(messages.getMessage(this.getClass(), "moviesGenres.caption"));
        // sets parameters for query
        critic = criticService.getCurrentCritic();
        movieGenresDl.setParameter("critic", critic);
        getScreenData().loadAll();
        // Make column in export table with date of looked
        forExport.addGeneratedColumn("whenLooked", new Table.PrintableColumnGenerator<MovieGenre, String>() {
            @Override
            public Component generateCell(MovieGenre entity) {
                DateFormat df = new SimpleDateFormat("dd MMM yyyy");
                return new Table.PlainTextCell(df.format(libraryService.getMovieInLibrary(entity.getMovie(), critic).getUpdateTs()));
            }

            @Override
            public String getValue(MovieGenre entity) {
                DateFormat df = new SimpleDateFormat("dd MMM yyyy");
                return df.format(libraryService.getMovieInLibrary(entity.getMovie(), critic).getUpdateTs());
            }
        });
    }

}