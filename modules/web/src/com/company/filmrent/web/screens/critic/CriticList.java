package com.company.filmrent.web.screens.critic;

import com.company.filmrent.service.CriticService;
import com.company.filmrent.web.screens.library.LibraryScreen;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.user.Critic;

import javax.inject.Inject;

@UiController("filmrent_Critic.list")
@UiDescriptor("critic-list.xml")
@LookupComponent("criticsTable")
public class CriticList extends StandardLookup<Critic> {

    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private CriticService criticService;
    @Inject
    private CollectionLoader<Critic> criticsDl;
    @Inject
    private Table<Critic> criticsTable;

    @Subscribe
    public void onInit(InitEvent event) {
        criticsTable.setItemClickAction(new BaseAction("itemClickAction")
                .withHandler(actionPerformedEvent -> {
                    System.out.println("em");
                    Critic critic = criticsTable.getSingleSelected();
                    if (critic != null) {
                        LibraryScreen libraryScreen = screenBuilders.screen(this).withScreenClass(LibraryScreen.class).withOpenMode(OpenMode.THIS_TAB).build();
                        libraryScreen.setCritic(critic);
                        libraryScreen.show();
                    }
                }));
    }
    
    

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        criticsDl.setParameter("rang", criticService.getNeededRang());
        getScreenData().loadAll();
    }
}