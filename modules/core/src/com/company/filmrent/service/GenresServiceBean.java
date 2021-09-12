package com.company.filmrent.service;

import com.company.filmrent.entity.genres.Genre;
import com.company.filmrent.entity.movie.Movie;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(GenresService.NAME)
public class GenresServiceBean implements GenresService {

    @Inject
    private DataManager dataManager;

    @Override
    public List<Genre> getUsedGenres() {
        return dataManager.load(Genre.class)
                .query("select g from filmrent_Genre g where g in (select mg.genre from filmrent_MovieGenre mg)")
                .view("_base")
                .list();
    }
}