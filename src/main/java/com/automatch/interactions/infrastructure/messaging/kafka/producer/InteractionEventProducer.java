package com.automatch.interactions.infrastructure.messaging.kafka.producer;

import com.automatch.interactions.domain.model.Interaction;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class InteractionEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public InteractionEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishInteractionCreated(Interaction interaction) {
        String payload = String.format(
                "{\"interactionId\": %d, \"userId\": %d, \"vehicleId\": %d, \"type\": \"%s\"}",
                interaction.getId(), interaction.getUserId(), interaction.getVehicleId(), interaction.getType());

        kafkaTemplate.send("interaction.created", payload);
    }
}