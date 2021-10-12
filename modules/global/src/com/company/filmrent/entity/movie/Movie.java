package com.company.filmrent.entity.movie;

import com.company.filmrent.entity.actor.MovieCast;
import com.company.filmrent.entity.genres.MovieGenre;
import com.company.filmrent.entity.review.Review;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Table(name = "Movies")
@Entity(name = "filmrent_Movie")
@NamePattern("%s|title")
public class Movie extends StandardEntity {
    private static final long serialVersionUID = -50537463377635136L;

    @Column(name = "Movie_title", nullable = false)
    @NotEmpty(message = "{msg://filmrent_Movie.title.validation.NotEmpty}")
    @NotNull
    private String title;

    @Column(name = "Movie_time", nullable = false)
    @Min(message = "{msg://filmrent_Movie.time.validation.Min}", value = 1)
    @NotNull(message = "{msg://filmrent_Movie.time.validation.NotNull}")
    private Integer time;

    @Temporal(TemporalType.DATE)
    @Column(name = "Movie_data_release", nullable = false)
    @NotNull(message = "{msg://filmrent_Movie.dataRelease.validation.NotNull}")
    private Date dataRelease;

    @Column(name = "Num_of_rating", nullable = false)
    @NotNull
    private Integer numOfRating;

    @Column(name = "Movie_director", nullable = false)
    @NotEmpty(message = "{msg://filmrent_Movie.director.validation.NotEmpty}")
    @NotNull
    private String director;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "movie")
    private List<MovieGenre> movieGenres;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "movie")
    private List<MovieCast> movieCasts;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    public Integer getNumOfRating() {
        return numOfRating;
    }

    public void setNumOfRating(Integer numOfRating) {
        this.numOfRating = numOfRating;
    }

    public Date getDataRelease() {
        return dataRelease;
    }

    public void setDataRelease(Date dataRelease) {
        this.dataRelease = dataRelease;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieGenre> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(List<MovieGenre> movieGenres) {
        this.movieGenres = movieGenres;
    }

    public List<MovieCast> getMovieCasts() {
        return movieCasts;
    }

    public void setMovieCasts(List<MovieCast> movieCasts) {
        this.movieCasts = movieCasts;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}