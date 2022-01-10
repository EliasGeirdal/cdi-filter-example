package org.acme.messaging;

public class SMSSender implements MessageSender {

    private final String prefix;

    public SMSSender(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String sendMessage(String message) {
        System.out.println(prefix + " " + message);
        return message;
    }
}
