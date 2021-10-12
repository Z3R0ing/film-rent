package com.company.filmrent.service;

import com.company.filmrent.entity.user.Critic;

public interface CriticService {
    String NAME = "filmrent_CriticService";

    Critic getCurrentCritic();

    /**
     * Add rang to critic
     * @param critic - use null for current Critic
     * @param rang - rang amount for add
     * @return true, if new Critic rang more than needed rating
     */
    boolean addRang(Critic critic, int rang);

    /**
     * @return needed rang for critic
     */
    int getNeededRang();
}