package org.acme.messaging;

import io.vertx.core.http.HttpServerRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class MessageSenderProducer {

    @Inject
    HttpServerRequest request;

    @Produces
    @RequestScoped
    MessageSender createMessageSender() {
        System.out.println("PRODUCES");
//        return new EmailSender("EMAIL");
        String messageType = request.getHeader("message-type");
        if (messageType == null || messageType.isEmpty() || messageType.equals("email")) {
            return new EmailSender("EMAIL");
        } else if (messageType.equals("sms")) {
            return new SMSSender("SMS");
        } else {
            return new EmailSender("EMAIL");
        }
    }
}


