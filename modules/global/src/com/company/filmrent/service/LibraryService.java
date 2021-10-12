package com.company.filmrent.service;

import com.company.filmrent.entity.library.Library;
import com.company.filmrent.entity.movie.Movie;
import com.company.filmrent.entity.user.Critic;

public interface LibraryService {
    String NAME = "filmrent_LibraryService";

    /**
     * Метод проверяет есть ли фильм в библиотеке критика
     * @param critic - критик для првоерки
     * @return true or false
     */
    public boolean isInLibrary(Movie movie, Critic critic);

    /**
     * Добавляет фильм в библиотеку со статусом <i>isLooked</i>, либо изменяет статус на просмотренный
     * @param movie - фильм
     * @param critic - кому добавляем
     * @param isLooked - просмотренно/непросмотренно
     * @return false если произошла ошибка с БД
     */
    boolean setLooked(Movie movie, Critic critic, boolean isLooked);

    /**
     * Добавляет фильм в библиотеку со статусом <i>isLooked</i>, либо изменяет статус на просмотренный
     * @param movie - фильм
     * @param critic - кому добавляем
     * @return fasle если непросмотрено или нет в библиотеке
     */
    boolean getLooked(Movie movie, Critic critic);

    /**
     * Убирает фильм из библиотеки
     * @param movie - фильм
     * @param critic - кому добавляем
     * @return false если произошла ошибка с БД или фильма нет в бибилиотеке
     */
    boolean removeFromLibrary(Movie movie, Critic critic);

    /**
     * Возвращает фильм в библиотеке
     * @param movie - фильм
     * @param critic - владелец билиотеки
     * @return null если такого фильма нет в библиотеке critic
     */
    Library getMovieInLibrary(Movie movie, Critic critic);
}