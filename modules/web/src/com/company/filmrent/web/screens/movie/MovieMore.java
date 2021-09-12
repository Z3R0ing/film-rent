package com.company.filmrent.web.screens.movie;

import com.company.filmrent.entity.genres.MovieGenre;
import com.company.filmrent.entity.user.Critic;
import com.company.filmrent.service.CriticService;
import com.company.filmrent.service.LibraryService;
import com.company.filmrent.service.MoviesService;
import com.company.filmrent.web.NotificationsHelper;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.PopupButton;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.movie.Movie;

import javax.inject.Inject;

@UiController("filmrent_Movie.more")
@UiDescriptor("movie-more.xml")
@EditedEntityContainer("movieDc")
public class MovieMore extends StandardEditor<Movie> {

    @Inject
    private InstanceContainer<Movie> movieDc;
    @Inject
    private InstanceLoader<Movie> movieDl;
    @Inject
    private CriticService criticService;
    @Inject
    private PopupButton popupAdd;
    @Inject
    private LibraryService libraryService;
    @Inject
    private Messages messages;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private MoviesService moviesService;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        movieDl.load();
        Critic critic = criticService.getCurrentCritic();
        if (critic != null) {
            if (libraryService.isInLibrary(getEditedEntity(), critic)) {
                popupAdd.setCaption(messages.getMessage(this.getClass(), "movieMore.changeStatus"));
            }
        } else {
            popupAdd.setVisible(false);
        }
    }

    @Subscribe("popupAdd.addLooked")
    public void onPopupAddAddLooked(Action.ActionPerformedEvent event) {
        if (libraryService.setLooked(getEditedEntity(), criticService.getCurrentCritic(), true)) {
            popupAdd.setCaption(messages.getMessage(this.getClass(), "movieMore.changeStatus"));
            movieDl.load();
        } else {
            NotificationsHelper.getDBFailNotification(this.getWindow()).show();
        }
    }

    @Subscribe("popupAdd.addUnLooked")
    public void onPopupAddAddUnLooked(Action.ActionPerformedEvent event) {
        if (libraryService.setLooked(getEditedEntity(), criticService.getCurrentCritic(), false)) {
            popupAdd.setCaption(messages.getMessage(this.getClass(), "movieMore.changeStatus"));
            movieDl.load();
        } else {
            NotificationsHelper.getDBFailNotification(this.getWindow()).show();
        }
    }

    public void openMoviesOfGenre(Entity item, String columnId) {
        MovieGenre movieGenre = (MovieGenre) item;
        Movies movies = screenBuilders.screen(this).withScreenClass(Movies.class).withOpenMode(OpenMode.NEW_TAB).build();
        movies.setMovies(moviesService.getMoviesByGenres(movieGenre.getGenre()));
        movies.setCaption(movieGenre.getGenre().getTitle());
        movies.show();
    }
    
}