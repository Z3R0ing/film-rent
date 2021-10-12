package com.company.filmrent.web.screens.actor;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.actor.Actor;

@UiController("filmrent_Actor.edit")
@UiDescriptor("actor-edit.xml")
@EditedEntityContainer("actorDc")
@LoadDataBeforeShow
public class ActorEdit extends StandardEditor<Actor> {
}