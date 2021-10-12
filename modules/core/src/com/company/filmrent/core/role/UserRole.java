package com.company.filmrent.core.role;

import com.company.filmrent.entity.actor.Actor;
import com.company.filmrent.entity.actor.MovieCast;
import com.company.filmrent.entity.genres.Genre;
import com.company.filmrent.entity.genres.MovieGenre;
import com.company.filmrent.entity.library.Library;
import com.company.filmrent.entity.movie.Movie;
import com.company.filmrent.entity.review.Review;
import com.company.filmrent.entity.user.Critic;
import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.EntityAccess;
import com.haulmont.cuba.security.app.role.annotation.EntityAttributeAccess;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.ScreenAccess;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;

@Role(name = UserRole.NAME)
public class UserRole extends AnnotatedRoleDefinition {
    public final static String NAME = "User";

    @EntityAccess(entityName = "*", operations = {EntityOp.READ})
    @EntityAccess(entityClass = Movie.class,
            operations = {EntityOp.READ, EntityOp.UPDATE})
    @EntityAccess(entityClass = Library.class,
            operations = {EntityOp.READ, EntityOp.CREATE, EntityOp.DELETE, EntityOp.UPDATE})
    @EntityAccess(entityClass = Review.class,
            operations = {EntityOp.READ, EntityOp.CREATE, EntityOp.DELETE, EntityOp.UPDATE})
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityName = "*", view = "*")
    @EntityAttributeAccess(entityClass = Movie.class, modify = "reviews")
    @EntityAttributeAccess(entityClass = Library.class, modify = "*")
    @EntityAttributeAccess(entityClass = Review.class, modify = "*")
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }

    @ScreenAccess(screenIds = {
            "help",
            "aboutWindow",
            "settings",
            "filmRentMenu",
            "extMainScreen",
            "filmrent_Critic.about",
            "filmrent_Movies",
            "filmrent_MovieCard",
            "filmrent_Movie.more",
            "filmrent_library",
            "filmrent_Review.edit",
            "filmrent_Review.browse",
            "filmrent_MonthMovies",
            "filmrent_MoviesGenres",
            "filmrent_ByDirectors"
    })
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }

    @Override
    public String getLocName() {
        return "Пользователь";
    }
}
