package com.company.filmrent.service;

import com.company.filmrent.entity.library.Library;
import com.company.filmrent.entity.movie.Movie;
import com.company.filmrent.entity.user.Critic;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(LibraryService.NAME)
public class LibraryServiceBean implements LibraryService {

    private static final Logger log = LoggerFactory.getLogger(LibraryServiceBean.class);

    @Inject
    private DataManager dataManager;
    @Inject
    private Metadata metadata;

    @Override
    public boolean isInLibrary(Movie movie, Critic critic) {
        return dataManager.load(Library.class)
                .query("select l from filmrent_Library l where l.movie = :movie and l.critic = :critic")
                .parameter("critic", critic)
                .parameter("movie", movie)
                .view("_minimal")
                .optional()
                .isPresent();
    }

    @Override
    public boolean setLooked(Movie movie, Critic critic, boolean isLooked) {
        try {
            Library movieInLibrary = getMovieInLibrary(movie, critic);
            if (movieInLibrary != null) {
                movieInLibrary.setIsLooked(isLooked);
            } else {
                movieInLibrary = metadata.create(Library.class);
                movieInLibrary.setMovie(movie);
                movieInLibrary.setCritic(critic);
                movieInLibrary.setIsLooked(isLooked);
            }
            dataManager.commit(new CommitContext(movieInLibrary));
            return true;
        } catch (Exception e) {
            log.error("Exception in LibraryServiceBean.setLooked", e);
            return false;
        }
    }

    @Override
    public boolean getLooked(Movie movie, Critic critic) {
        try {
            Library movieInLibrary = getMovieInLibrary(movie, critic);
            if (movieInLibrary != null) {
                return movieInLibrary.getIsLooked();
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("Exception in LibraryServiceBean.getLooked", e);
            return false;
        }
    }

    @Override
    public boolean removeFromLibrary(Movie movie, Critic critic) {
        try {
            Library movieInLibrary = getMovieInLibrary(movie, critic);
            if (movieInLibrary != null) {
                dataManager.remove(movieInLibrary);
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            log.error("Exception in LibraryServiceBean.removeFromLibrary", e);
            return false;
        }
    }

    private Library getMovieInLibrary(Movie movie, Critic critic) {
        return dataManager.load(Library.class)
                .query("select l from filmrent_Library l where l.movie = :movie and l.critic = :critic")
                .parameter("critic", critic)
                .parameter("movie", movie)
                .view("_local")
                .optional()
                .orElse(null);
    }

}