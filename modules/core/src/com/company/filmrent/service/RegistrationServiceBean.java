package com.company.filmrent.service;

import com.company.filmrent.core.role.ClientRole;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.security.entity.Group;
import com.haulmont.cuba.security.entity.Role;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.entity.UserRole;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service(RegistrationService.NAME)
public class RegistrationServiceBean implements RegistrationService {

    /**
     * ID of the Group for self-registered users.
     */
    private static final String COMPANY_GROUP_ID = "0fa2b1a5-1d68-4d69-9fbd-dff348347f93";

    /**
     * ID of the Role to be assigned to self-registered users.
     */
    private static final String ERROR_ROLE_ID = "53836cb1-3c83-9795-dc2d-0c7189221e33";

    @Inject
    private DataManager dataManager;

    @Inject
    private Metadata metadata;

    @Inject
    private PasswordEncryption passwordEncryption;


    @Override
    public RegistrationResult registerUser(String login, String password) {

        Group group = dataManager.load(LoadContext.create(Group.class).setId(UUID.fromString(COMPANY_GROUP_ID)));

        // Create a user instance
        User user = metadata.create(User.class);
        user.setLogin(login);
        user.setPassword(passwordEncryption.getPasswordHash(user.getId(), password));

        // Note that the platform does not support the default group out of the box, so here we define the default group id and set it for the newly registered users.
        user.setGroup(group);

        /* Create a link to the role
         * Here we programmatically set the default role.
         * Another way is to set the default role by using the DB scripts. Set IS_DEFAULT_ROLE parameter to true in the insert script for the role.
         * Also, this parameter might be changed in the Role Editor screen.
         */
        UserRole userRole = metadata.create(UserRole.class);
        userRole.setUser(user);
        userRole.setRoleName(ClientRole.NAME);

        // Save new entities
        dataManager.commit(new CommitContext(user, userRole));

        return new RegistrationResult(user);
    }

}