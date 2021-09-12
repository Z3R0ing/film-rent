package com.company.filmrent.core.role;

import com.company.filmrent.entity.library.Library;
import com.company.filmrent.entity.movie.Movie;
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

@Role(name = CriticRole.NAME)
public class CriticRole extends AnnotatedRoleDefinition {
    public final static String NAME = "Critic";

    @EntityAccess(entityClass = Movie.class,
            operations = {EntityOp.READ})
    @EntityAccess(entityClass = Critic.class,
            operations = {EntityOp.READ})
    @EntityAccess(entityClass = Library.class,
            operations = {EntityOp.READ, EntityOp.CREATE, EntityOp.DELETE, EntityOp.UPDATE})
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityClass = Movie.class, modify = "*")
    @EntityAttributeAccess(entityClass = Critic.class, modify = "*")
    @EntityAttributeAccess(entityClass = Library.class, modify = "*")
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }

    @ScreenAccess(screenIds = {
            "extMainScreen",
            "filmrent_Critic.about",
            "filmrent_Movies",
            "filmrent_MovieCard",
            "filmrent_Movie.more",
            "filmrent_library",
            "filmRentMenu"
    })
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }

    @Override
    public String getLocName() {
        return "Клиент";
    }
}
