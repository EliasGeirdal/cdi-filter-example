package org.acme.ressource;

import org.acme.ressource.dto.MessageDTO;
import org.acme.service.Service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/messages")
public class MessageResource {
    private final Service service;

    @Inject
    public MessageResource(Service service) {
        this.service = service;
    }

    @POST
    public void postMessage(MessageDTO messageDTO) {
        String res = service.sendMessage(messageDTO.getMessage());
        System.out.println("Result after interceptor: " + res);
    }

}
