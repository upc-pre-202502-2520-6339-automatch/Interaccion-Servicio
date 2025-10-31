package com.automatch.interactions.domain.service;

import com.automatch.interactions.domain.model.Interaction;
import org.springframework.stereotype.Service;

@Service
public class InteractionDomainService {

    public void validateInteraction(Interaction interaction) {
        if (interaction.getType() == null || interaction.getType().isBlank()) {
            throw new IllegalArgumentException("El tipo de interacción no puede ser vacío.");
        }
        if (interaction.getUserId() == null || interaction.getVehicleId() == null) {
            throw new IllegalArgumentException("Los IDs de usuario y vehículo son obligatorios.");
        }
    }
}