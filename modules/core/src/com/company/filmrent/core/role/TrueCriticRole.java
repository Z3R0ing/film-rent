package com.company.filmrent.core.role;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.ScreenAccess;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;

@Role(name = TrueCriticRole.NAME)
public class TrueCriticRole extends AnnotatedRoleDefinition {
    public final static String NAME = "TrueCritic";

    @ScreenAccess(screenIds = {
            "filmrent_Critic.list"
    })
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }
}
