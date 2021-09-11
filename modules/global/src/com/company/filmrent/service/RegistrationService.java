package com.company.filmrent.service;

import com.company.filmrent.validation.CheckUserExists;
import com.haulmont.cuba.security.entity.User;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.UUID;

public interface RegistrationService {
    String NAME = "filmrent_RegistrationService";

    @Validated
    RegistrationResult registerUser(@CheckUserExists String login, String password);

    public static class RegistrationResult implements Serializable {

        private UUID userId;

        public RegistrationResult(User user) {
            if (user != null) {
                this.userId = user.getId();
            }
        }

        public UUID getUserId() {
            return userId;
        }
    }
}