package com.company.filmrent.web.screens.review;

import com.company.filmrent.service.CriticService;
import com.company.filmrent.web.NotificationsHelper;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.review.Review;

import javax.inject.Inject;

@UiController("filmrent_Review.edit")
@UiDescriptor("review-edit.xml")
@EditedEntityContainer("reviewDc")
@LoadDataBeforeShow
public class ReviewEdit extends StandardEditor<Review> {
    @Inject
    private CriticService criticService;

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        if (criticService.addRang(null, 1)) {
            NotificationsHelper.getRangUpNotification(getWindow());
        }
    }
}