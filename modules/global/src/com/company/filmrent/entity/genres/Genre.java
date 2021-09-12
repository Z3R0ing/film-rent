package com.company.filmrent.entity.genres;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "Genres")
@Entity(name = "filmrent_Genre")
@NamePattern("%s|title")
public class Genre extends StandardEntity {
    private static final long serialVersionUID = -8745118533670944749L;

    @NotNull
    @Column(name = "Genre_title", nullable = false)
    @NotEmpty(message = "{msg://filmrent_Genre.title.validation.NotEmpty}")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}