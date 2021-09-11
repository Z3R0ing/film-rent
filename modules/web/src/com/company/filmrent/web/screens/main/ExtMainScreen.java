package com.company.filmrent.web.screens.main;

import com.company.filmrent.service.MoviesService;
import com.company.filmrent.web.NotificationsHelper;
import com.company.filmrent.web.screens.movie.Movies;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.security.global.UserSession;
import com.haulmont.cuba.web.app.main.MainScreen;

import javax.inject.Inject;


@UiController("extMainScreen")
@UiDescriptor("ext-main-screen.xml")
public class ExtMainScreen extends MainScreen {

    @Inject
    private UserSession userSession;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private MoviesService moviesService;
    @Inject
    private Messages messages;

    @Subscribe("movieBtn")
    public void onMovieBtnClick(Button.ClickEvent event) {
        if(isLogin()) {
            Movies movies = screenBuilders.screen(this).withScreenClass(Movies.class).build();
            movies.setMovies(moviesService.getMovies());
            movies.setCaption(messages.getMessage(this.getClass(), "extMainScreen.films"));
            movies.show();
        } else {
            NotificationsHelper.getUnauthNotification(this.getWindow()).show();
        }
    }

    @Subscribe("profileBtn")
    public void onProfileBtnClick(Button.ClickEvent event) {
        if(isLogin()) {

        } else {
            NotificationsHelper.getUnauthNotification(this.getWindow()).show();
        }
    }

    @Subscribe("libraryBtn")
    public void onLibraryBtnClick(Button.ClickEvent event) {
        if(isLogin()) {

        } else {
            NotificationsHelper.getUnauthNotification(this.getWindow()).show();
        }
    }

    private boolean isLogin() {
        return !userSession.getUser().getLoginLowerCase().equals("anonymous");
    }
}