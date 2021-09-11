package com.company.filmrent.service;

import com.company.filmrent.entity.user.Critic;
import com.haulmont.cuba.security.entity.User;

public interface CriticService {
    String NAME = "filmrent_CriticService";

    Critic getCriticByUser(User user);
}