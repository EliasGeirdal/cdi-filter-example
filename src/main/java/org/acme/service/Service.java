package org.acme.service;

import org.acme.interceptor.Cached;
import org.acme.messaging.MessageSender;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class Service {
    private final MessageSender messageSender;

    @Inject
    public Service(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

//    @Cached
    public String sendMessage(String message) {
        return messageSender.sendMessage(message);
    }
}
