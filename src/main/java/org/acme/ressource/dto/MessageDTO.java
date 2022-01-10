package org.acme.ressource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDTO {
    private final String message;

    @JsonCreator
    public MessageDTO(@JsonProperty("message") String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

}
