package com.company.filmrent.core.role;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.Role;

@Role(name = ClientRole.NAME)
public class ClientRole extends AnnotatedRoleDefinition {
    public final static String NAME = "Client";

    @Override
    public String getLocName() {
        return "Клиент";
    }
}
