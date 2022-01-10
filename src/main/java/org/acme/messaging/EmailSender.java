package org.acme.messaging;

public class EmailSender implements MessageSender {

    private String prefix;

    public EmailSender(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String sendMessage(String message) {
        System.out.println(prefix + " " + message);
        return message;
    }
}


