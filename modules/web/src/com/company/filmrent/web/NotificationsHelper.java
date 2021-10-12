package com.company.filmrent.web;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.ComponentsHelper;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Window;
import com.haulmont.cuba.gui.screen.ScreenContext;

public class NotificationsHelper {

    private static final Messages messages = AppBeans.get(Messages.NAME);
    
    public static Notifications.NotificationBuilder getUnauthNotification(Window window) {
        ScreenContext screenContext = ComponentsHelper.getScreenContext(window);
        Notifications notifications = screenContext.getNotifications();
        return notifications.create(Notifications.NotificationType.HUMANIZED)
                .withCaption(messages.getMainMessage("unauthHead"))
                .withDescription(messages.getMainMessage("unauthDesc"));
    }

    public static Notifications.NotificationBuilder getDBFailNotification(Window window) {
        ScreenContext screenContext = ComponentsHelper.getScreenContext(window);
        Notifications notifications = screenContext.getNotifications();
        return notifications.create(Notifications.NotificationType.ERROR)
                .withCaption(messages.getMainMessage("DBfailHead"))
                .withDescription(messages.getMainMessage("DBfailDesc"));
    }
    public static Notifications.NotificationBuilder getWarningNotification(Window window, String caption) {
        ScreenContext screenContext = ComponentsHelper.getScreenContext(window);
        Notifications notifications = screenContext.getNotifications();
        return notifications.create(Notifications.NotificationType.WARNING)
                .withCaption(caption);
    }
}
