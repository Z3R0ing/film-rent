package com.company.filmrent.web.screens.critic;

import com.company.filmrent.entity.user.Critic;
import com.company.filmrent.service.CriticService;
import com.company.filmrent.web.screens.library.LibraryScreen;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("filmrent_Critic.about")
@UiDescriptor("critic-about.xml")
public class CriticAbout extends Screen {

    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private CriticService criticService;

    private Critic critic;
    @Inject
    private TextField<String> userName;
    @Inject
    private TextField<String> userRangField;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        if (critic == null) {
            setCritic(criticService.getCurrentCritic());
        }
        userName.setValue(critic.getUser().getLogin());
        userRangField.setValue(String.valueOf(critic.getUserRang()));
    }

    @Subscribe("libraryBtn")
    public void onLibraryBtnClick(Button.ClickEvent event) {
        LibraryScreen library = screenBuilders.screen(this).withScreenClass(LibraryScreen.class).withOpenMode(OpenMode.THIS_TAB).build();
        library.setCritic(critic);
        library.show();
    }

    public void setCritic(Critic critic) {
        this.critic = critic;
    }
}