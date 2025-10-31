package com.automatch.interactions.application.service;

import com.automatch.interactions.application.dto.InteractionRequestDTO;
import com.automatch.interactions.domain.model.Interaction;
import com.automatch.interactions.domain.repository.InteractionRepository;
import com.automatch.interactions.domain.service.InteractionDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InteractionApplicationService {

    private final InteractionRepository repository;
    private final InteractionDomainService domainService;

    @Transactional
    public Interaction register(InteractionRequestDTO dto) {
        Interaction interaction = Interaction.builder()
                .userId(dto.userId())
                .vehicleId(dto.vehicleId())
                .type(dto.type())
                .description(dto.description())
                .build();

        domainService.validateInteraction(interaction);
        return repository.save(interaction);
    }

    @Transactional(readOnly = true)
    public List<Interaction> findByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}