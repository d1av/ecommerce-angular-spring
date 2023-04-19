package com.davi.shop.exceptions;

import com.davi.shop.validation.Notification;

public class NotificationException extends DomainException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NotificationException(final String message, final Notification aNotification) {
        super(message, aNotification.getErrors());
    }
}