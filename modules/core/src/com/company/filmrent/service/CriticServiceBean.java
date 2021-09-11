package com.company.filmrent.service;

import com.company.filmrent.entity.user.Critic;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.security.entity.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service(CriticService.NAME)
public class CriticServiceBean implements CriticService {

    @Inject
    private DataManager dataManager;

    @Override
    public Critic getCriticByUser(User user) {
        Optional<Critic> optional = dataManager.load(Critic.class)
                .query("select c from filmrent_Critic c where c.user = :user")
                .parameter("user", user)
                .optional();
        return optional.orElse(null);
    }
}