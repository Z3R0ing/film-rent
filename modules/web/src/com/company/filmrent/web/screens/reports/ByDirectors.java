package com.company.filmrent.web.screens.reports;

import com.company.filmrent.entity.movie.Movie;
import com.company.filmrent.entity.user.Critic;
import com.company.filmrent.service.CriticService;
import com.company.filmrent.service.LibraryService;
import com.company.filmrent.web.screens.movie.MovieCard;
import com.haulmont.cuba.core.global.Messages;
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
import java.util.ArrayList;
import java.util.List;

@UiController("filmrent_ByDirectors")
@UiDescriptor("by-directors.xml")
public class ByDirectors extends Screen {

    @Inject
    private Messages messages;
    @Inject
    private CriticService criticService;
    @Inject
    private LibraryService libraryService;
    @Inject
    private CollectionContainer<Movie> moviesDc;
    @Inject
    private CollectionLoader<Movie> moviesDl;
    @Inject
    private Table<Movie> forExport;
    @Inject
    private TextField<String> directorField;
    @Named("forExport.excel")
    private ExcelAction forExportExcel;

    private Critic critic = null;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        // set file name to export
        forExportExcel.setFileName(messages.getMessage(this.getClass(), "byDirectors.caption"));
        // set query param
        critic = criticService.getCurrentCritic();
        moviesDl.setParameter("director", ("%".concat(directorField.getRawValue()).concat("%")));
        getScreenData().loadAll();
        // Make column in export table with date of looked
        forExport.addGeneratedColumn("isLooked", new Table.PrintableColumnGenerator<Movie, String>() {
            @Override
            public Component generateCell(Movie entity) {
                if (libraryService.isInLibrary(entity, critic)) {
                    return new Table.PlainTextCell(messages.getMessage(ByDirectors.class, "byDirectors.looked"));
                } else {
                    return new Table.PlainTextCell(messages.getMessage(ByDirectors.class, "byDirectors.donnotlooked"));
                }
            }

            @Override
            public String getValue(Movie entity) {
                if (libraryService.isInLibrary(entity, critic)) {
                    return messages.getMessage(ByDirectors.class, "byDirectors.looked");
                } else {
                    return messages.getMessage(ByDirectors.class, "byDirectors.donnotlooked");
                }
            }
        });
    }

    @Subscribe("searchBtn")
    public void onSearchBtnClick(Button.ClickEvent event) {
        moviesDl.setParameter("director", ("%".concat(directorField.getRawValue()).concat("%")));
        getScreenData().loadAll();
    }
}