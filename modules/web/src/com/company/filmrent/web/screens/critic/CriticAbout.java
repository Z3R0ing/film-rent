package com.company.filmrent.web.screens.critic;

import com.company.filmrent.entity.user.Critic;
import com.haulmont.cuba.gui.screen.*;

@UiController("filmrent_Critic.about")
@UiDescriptor("critic-about.xml")
@EditedEntityContainer("criticDc")
@LoadDataBeforeShow
public class CriticAbout extends StandardEditor<Critic> {
}