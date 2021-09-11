package com.company.filmrent.web.screens.main;

import com.company.filmrent.service.CriticService;
import com.company.filmrent.service.MoviesService;
import com.company.filmrent.web.NotificationsHelper;
import com.company.filmrent.web.screens.critic.CriticAbout;
import com.company.filmrent.web.screens.movie.Movies;
import com.haulmont.cuba.core.global.Messages;
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
    private MoviesService moviesService;
    @Inject
    private CriticService criticService;
    @Inject
    private UserSession userSession;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private Messages messages;

    @Subscribe("movieBtn")
    public void onMovieBtnClick(Button.ClickEvent event) {
        Movies movies = screenBuilders.screen(this).withScreenClass(Movies.class).build();
        movies.setMovies(moviesService.getMovies());
        movies.setCaption(messages.getMessage(this.getClass(), "extMainScreen.films"));
        movies.show();
    }

    @Subscribe("profileBtn")
    public void onProfileBtnClick(Button.ClickEvent event) {
        if(isLogin()) {
            CriticAbout criticAbout = screenBuilders.screen(this).withScreenClass(CriticAbout.class).build();
            criticAbout.setEntityToEdit(criticService.getCriticByUser(userSession.getUser()));
            criticAbout.show();
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