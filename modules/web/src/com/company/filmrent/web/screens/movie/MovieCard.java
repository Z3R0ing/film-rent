package com.company.filmrent.web.screens.movie;

import com.company.filmrent.entity.movie.Movie;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@UiController("filmrent_MovieCard")
@UiDescriptor("movie-card.xml")
public class MovieCard extends ScreenFragment {

    @Inject
    private UserSession userSession;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private Messages messages;
    @Inject
    private DataManager dataManager;
    @Inject
    private Label<String> dataRelease;
    @Inject
    private Label<String> numOfRating;
    @Inject
    private Label<String> time;
    @Inject
    private Label<String> title;
    @Inject
    private Button more;

    private Movie movie;

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        title.setValue(movie.getTitle());
        time.setValue(messages.formatMessage(this.getClass(), "movie-card.time", movie.getTime()));
        dataRelease.setValue(messages.formatMessage(this.getClass(), "movie-card.dataRelease", sdf.format(movie.getDataRelease())));
        numOfRating.setValue(messages.formatMessage(this.getClass(), "movie-card.numOfRating", movie.getNumOfRating()));
        if(!isLogin()) {
            more.setVisible(false);
        }
    }

    @Subscribe("more")
    public void onMoreClick(Button.ClickEvent event) {
        MovieMore movieMore = screenBuilders.screen(this)
                .withScreenClass(MovieMore.class).build();
        movieMore.setEntityToEdit(movie);
        movieMore.show();
    }

    public void setMovie(Movie movie) {
        this.movie = dataManager.reload(movie, "movie-view");
    }

    private boolean isLogin() {
        return !userSession.getUser().getLoginLowerCase().equals("anonymous");
    }

}