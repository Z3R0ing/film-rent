package com.company.filmrent.web.screens.register;

import com.company.filmrent.service.RegistrationService;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.validation.MethodParametersValidationException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.PasswordField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("filmrent_RegisterScreen")
@UiDescriptor("register-screen.xml")
public class RegisterScreen extends Screen {

    @Inject
    private RegistrationService registrationService;
    @Inject
    private Notifications notifications;
    @Inject
    private Messages messages;
    @Inject
    private TextField<String> loginField;
    @Inject
    private PasswordField passwordField;

    /**
     * @return entered login
     */
    public String getLogin() {
        return loginField.getValue();
    }

    /**
     * @return entered password
     */
    public String getPassword() {
        return passwordField.getValue();
    }

    @Subscribe("sendReportBtn")
    public void onSendReportBtnClick(Button.ClickEvent event) {
        try {
            registrationService.registerUser(getLogin(), getPassword());

            notifications.create(Notifications.NotificationType.TRAY)
                    .withCaption("Новый пользователь " + getLogin())
                    .show();

            close(WINDOW_COMMIT_AND_CLOSE_ACTION);
        } catch (MethodParametersValidationException e) {
            notifications.create(Notifications.NotificationType.TRAY)
                    .withCaption(
                            messages.getMessage(this.getClass(), "register.validationMessage"))
                    .show();
        }
    }

}