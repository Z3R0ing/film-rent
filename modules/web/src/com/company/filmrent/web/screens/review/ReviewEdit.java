package com.company.filmrent.web.screens.review;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.review.Review;

@UiController("filmrent_Review.edit")
@UiDescriptor("review-edit.xml")
@EditedEntityContainer("reviewDc")
@LoadDataBeforeShow
public class ReviewEdit extends StandardEditor<Review> {
}