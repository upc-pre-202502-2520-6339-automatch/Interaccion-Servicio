package com.automatch.interactions.infrastructure.messaging.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class InteractionEventConsumer {

    @KafkaListener(topics = "interaction.created", groupId = "interactions-service-group")
    public void listenInteractionCreated(Object data) {
        System.out.println("EVENT RECEIVED => " + data);
    }
}