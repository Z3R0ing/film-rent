package com.company.filmrent.web.screens.review;

import com.haulmont.cuba.gui.screen.*;
import com.company.filmrent.entity.review.Review;

@UiController("filmrent_Review.browse")
@UiDescriptor("review-browse.xml")
@LookupComponent("reviewsTable")
@LoadDataBeforeShow
public class ReviewBrowse extends StandardLookup<Review> {
}