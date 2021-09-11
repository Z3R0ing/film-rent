package com.company.filmrent.web.screens.critic;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.user.Critic;

@UiController("filmrent_Critic.edit")
@UiDescriptor("critic-edit.xml")
@EditedEntityContainer("criticDc")
@PrimaryEditorScreen(Critic.class)
@LoadDataBeforeShow
public class CriticEdit extends StandardEditor<Critic> {
}