package com.company.filmrent.service;

import com.company.filmrent.entity.genres.Genre;
import com.company.filmrent.entity.genres.MovieGenre;
import com.company.filmrent.entity.movie.Movie;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(MoviesService.NAME)
public class MoviesServiceBean implements MoviesService {

    @Inject
    private DataManager dataManager;

    @Override
    public List<Movie> getMovies() {
        return dataManager.load(Movie.class)
                .query("select m from filmrent_Movie m")
                .view("movie-view")
                .list();
    }

    @Override
    public List<Movie> getMoviesByGenres(Genre genre) {
        return dataManager.load(Movie.class)
                .query("select mg.movie from filmrent_MovieGenre mg where mg.genre = :genre")
                .parameter("genre", genre)
                .view("movie-view")
                .list();
    }
}