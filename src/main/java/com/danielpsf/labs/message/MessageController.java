package com.danielpsf.labs.message;

import java.net.URISyntaxException;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.danielpsf.labs.BaseController;

@Path("/message")
public class MessageController extends BaseController {

    MessageService messageService = null;

    public MessageController() {
        messageService = new MessageService();
    }

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Integer id) {
        return Response.ok(messageService.get(id))
                       .build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@HasDukesPreffix @Valid final Message message) throws URISyntaxException {
        Message savedMessage = messageService.save(message);
        return Response.created(getCreatedResourceUri("message", savedMessage.getId()))
                       .entity(savedMessage)
                       .build();
    }
}
