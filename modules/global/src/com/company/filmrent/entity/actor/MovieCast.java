package com.company.filmrent.entity.actor;

import com.company.filmrent.entity.movie.Movie;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Table(name = "Movies_cast")
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

    @Column(name = "Role", nullable = false)
    @NotEmpty(message = "{filmrent_MovieCast.role.validation.NotEmpty}")
    private String role;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}