package com.danielpsf.labs.message;

import java.util.Optional;

import javax.ws.rs.NotFoundException;

public class MessageService {

    MessageStore messageStore = null;

    public MessageService() {
        messageStore = MessageStore.getInstance();
    }

    public Message save(final Message message) {
        return messageStore.addMessage(message);
    }

    public Message get(Integer id) {
        Optional<Message> message = messageStore.getMessage(id);
        if(!message.isPresent()) {
            throw new NotFoundException();
        }
        return message.get();
    }
}
