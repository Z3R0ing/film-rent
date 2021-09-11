package com.company.filmrent.web.screens.critic;

import com.company.filmrent.entity.user.Critic;
import com.haulmont.cuba.gui.screen.*;

@UiController("filmrent_Critic.browse")
@UiDescriptor("critic-browse.xml")
@LookupComponent("criticTable")
@LoadDataBeforeShow
public class CriticBrowse extends StandardLookup<Critic> {
}