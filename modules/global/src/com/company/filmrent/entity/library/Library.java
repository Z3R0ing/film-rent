package com.company.filmrent.entity.library;

import com.company.filmrent.entity.movie.Movie;
import com.company.filmrent.entity.user.Critic;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "Library")
@Entity(name = "filmrent_Library")
@NamePattern("%s-%s|critic,movie")
public class Library extends StandardEntity {
    private static final long serialVersionUID = 4628245281481461523L;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_user")
    @NotNull
    private Critic critic;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_movie")
    @NotNull
    private Movie movie;

    @Column(name = "isLooked", nullable = false)
    @NotNull
    private Boolean isLooked = false;

    public Critic getCritic() {
        return critic;
    }

    public void setCritic(Critic critic) {
        this.critic = critic;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Boolean getIsLooked() {
        return isLooked;
    }

    public void setIsLooked(Boolean looked) {
        isLooked = looked;
    }
}