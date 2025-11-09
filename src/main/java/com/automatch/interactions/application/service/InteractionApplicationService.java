package com.automatch.interactions.application.service;

import com.automatch.interactions.application.dto.InteractionRequestDTO;
import com.automatch.interactions.domain.model.Interaction;
import com.automatch.interactions.domain.repository.InteractionRepository;
import com.automatch.interactions.domain.service.InteractionDomainService;
import com.automatch.interactions.infrastructure.messaging.kafka.producer.InteractionEventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InteractionApplicationService {

    private final InteractionRepository repository;
    private final InteractionDomainService domainService;
    private final InteractionEventProducer eventProducer;

    @Transactional
    public Interaction register(InteractionRequestDTO dto) {
        Interaction interaction = Interaction.builder()
                .userId(dto.userId())
                .vehicleId(dto.vehicleId())
                .type(dto.type())
                .description(dto.description())
                .build();

        domainService.validateInteraction(interaction);
        Interaction saved = repository.save(interaction);

        // SOLO enviar el evento desde el producer
        eventProducer.publishInteractionCreated(saved);

        return saved;
    }

    @Transactional(readOnly = true)
    public List<Interaction> findByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}