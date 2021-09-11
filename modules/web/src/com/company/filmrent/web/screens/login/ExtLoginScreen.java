package com.company.filmrent.web.screens.login;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.login.LoginScreen;
import com.company.filmrent.web.screens.register.RegisterScreen;

import javax.inject.Inject;


@UiController("login")
@UiDescriptor("ext-login-screen.xml")
public class ExtLoginScreen extends LoginScreen {

    /**
     * Injected component from the base screen.
     */
    @Inject
    private Button loginButton;

    /**
     * "Register" link click handler.
     */
    @Subscribe("registerBtn")
    public void onRegisterBtnClick(Button.ClickEvent event) {
        // Create "Register" screen with dialog mode
        RegisterScreen registerScreen = screens.create(RegisterScreen.class, OpenMode.DIALOG);

        // Add a listener to be notified when the "Register" screen is closed with COMMIT_ACTION_ID
        registerScreen.addAfterCloseListener(afterCloseEvent -> {
            CloseAction closeAction = afterCloseEvent.getCloseAction();
            if (closeAction == WINDOW_COMMIT_AND_CLOSE_ACTION) {
                // Set the new registered user credentials to login and password fields
                loginField.setValue(registerScreen.getLogin());
                passwordField.setValue(registerScreen.getPassword());
                // Set focus on "Submit" button
                loginButton.focus();
            }
        });

        // Show "Register" screen
        registerScreen.show();
    }

}