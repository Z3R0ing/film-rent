package com.company.filmrent.web.screens.actor;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.actor.Actor;

@UiController("filmrent_Actor.browse")
@UiDescriptor("actor-browse.xml")
@LookupComponent("actorsTable")
@LoadDataBeforeShow
public class ActorBrowse extends StandardLookup<Actor> {
}