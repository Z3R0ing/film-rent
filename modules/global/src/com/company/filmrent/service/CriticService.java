package com.company.filmrent.service;

import com.company.filmrent.entity.user.Critic;

public interface CriticService {
    String NAME = "filmrent_CriticService";

    Critic getCurrentCritic();
}