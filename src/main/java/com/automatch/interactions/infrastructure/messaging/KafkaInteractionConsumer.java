package com.automatch.interactions.infrastructure.messaging;

import com.automatch.interactions.domain.repository.InteractionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaInteractionConsumer {

    private final InteractionRepository repository;

    @KafkaListener(topics = "automatch.interactions", groupId = "interaction-service")
    public void consume(String message) {
        log.info("Evento recibido de Kafka: {}", message);
        // Simulación: en el futuro parseará el mensaje y guardará la interacción.
    }
}