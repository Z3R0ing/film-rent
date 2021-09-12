package com.company.filmrent.service;

import com.company.filmrent.entity.genres.Genre;

import java.util.List;

public interface GenresService {
    String NAME = "filmrent_GenresService";

    List<Genre> getUsedGenres();
}