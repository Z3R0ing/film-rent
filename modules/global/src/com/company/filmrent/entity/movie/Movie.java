package com.company.filmrent.entity.movie;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
}