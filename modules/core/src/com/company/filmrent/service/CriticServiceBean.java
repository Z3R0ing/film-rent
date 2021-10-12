package com.company.filmrent.service;

import com.company.filmrent.core.role.TrueCriticRole;
import com.company.filmrent.entity.user.Critic;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.entity.UserRole;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service(CriticService.NAME)
public class CriticServiceBean implements CriticService {

    int NEEDED_RANG = 100;

    @Inject
    private DataManager dataManager;
    @Inject
    private UserSessionSource userSessionSource;
    @Inject
    private Metadata metadata;

    @Override
    public Critic getCurrentCritic() {
        User user = userSessionSource.getUserSession().getUser();
        Optional<Critic> optional = dataManager.load(Critic.class)
                .query("select c from filmrent_Critic c where c.user = :user")
                .parameter("user", user)
                .view("critic-view")
                .optional();
        return optional.orElse(null);
    }

    @Override
    public boolean addRang(Critic critic, int rang) {
        boolean result = false;
        if (critic == null) {
            critic = getCurrentCritic();
        }

        CommitContext commitContext = new CommitContext();

        critic.setUserRang(critic.getUserRang() + rang);
        commitContext.addInstanceToCommit(critic);

        if (critic.getUserRang() >= NEEDED_RANG) {
            result = true;
            // Добавим юзеру новую роль, которая будет давать доступ к чужим библиотекам
            com.haulmont.cuba.security.entity.UserRole userRole = metadata.create(com.haulmont.cuba.security.entity.UserRole.class);
            userRole.setUser(critic.getUser());
            userRole.setRoleName(TrueCriticRole.NAME);
            commitContext.addInstanceToCommit(userRole);
        }

        dataManager.commit(commitContext);

        return result;
    }

    @Override
    public int getNeededRang() {
        return NEEDED_RANG;
    }
}