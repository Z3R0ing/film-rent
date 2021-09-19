package com.company.filmrent.entity.review;

import com.company.filmrent.entity.movie.Movie;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Table(name = "Review")
@Entity(name = "filmrent_Review")
@NamePattern("Review on %s|movie")
public class Review extends StandardEntity {
    private static final long serialVersionUID = 9158151522904282186L;

    @Column(name = "Text_of_review", nullable = false)
    @NotEmpty(message = "{filmrent_Review.textOfReview.validation.NotEmpty}")
    String textOfReview;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Movie_id")
    private Movie movie;
}