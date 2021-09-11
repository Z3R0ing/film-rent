package com.company.filmrent.service;

import com.company.filmrent.entity.movie.Movie;

import java.util.List;

public interface MoviesService {
    String NAME = "filmrent_MoviesService";

    /**
     * Метод для получения всех фильмов
     * @return список всех фильмов
     */
    public List<Movie> getMovies();
}