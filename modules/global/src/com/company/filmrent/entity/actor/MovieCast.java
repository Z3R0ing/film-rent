package com.company.filmrent.entity.actor;

import com.company.filmrent.entity.movie.Movie;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;

@Table(name = "FILMRENT_MOVIE_CAST")
@Entity(name = "filmrent_MovieCast")
@NamePattern("%s in &s|actor,movie")
public class MovieCast extends StandardEntity {
    private static final long serialVersionUID = -5744447493895148753L;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Movie_id")
    private Movie movie;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Actor_id")
    private Actor actor;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}