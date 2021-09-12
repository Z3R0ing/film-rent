package com.company.filmrent.service;

import com.company.filmrent.entity.genres.Genre;
import com.company.filmrent.entity.genres.MovieGenre;
import com.company.filmrent.entity.movie.Movie;

import java.util.List;

public interface MoviesService {
    String NAME = "filmrent_MoviesService";

    /**
     * Метод для получения всех фильмов
     * @return список всех фильмов
     */
    List<Movie> getMovies();

    /**
     * Метод получения списка фильмов по жанру
     * @param genre - жанр
     * @return фильмы с таким жанром or empty list
     */
    List<Movie> getMoviesByGenres(Genre genre);
}