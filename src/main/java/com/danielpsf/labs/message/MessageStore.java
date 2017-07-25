package com.danielpsf.labs.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageStore {

    private static MessageStore instance = null;
    private List<Message> messages = new ArrayList<Message>();
    private AtomicInteger generatedIds = new AtomicInteger(1);

    public static MessageStore getInstance() {
        if (instance == null) {
            synchronized (MessageStore.class) {
                if (instance == null) {
                    instance = new MessageStore();
                }
            }
        }
        return instance;
    }

    public Optional<Message> getMessage(int id) {
        return this.messages.parallelStream().filter(message -> message.getId() == id).findFirst();
    }

    public Message addMessage(final Message originalMessage) {
        Message message = persistMessage(originalMessage);
        return message;
    }

    private Message persistMessage(final Message originalMessage) {
        Message message = getMessageToPersist(originalMessage);
        this.messages.add(message);
        return message;
    }

    private Message getMessageToPersist(final Message originalMessage) {
        Message message = new Message(generatedIds.getAndIncrement(), originalMessage.getContent());
        return message;
    }

}
