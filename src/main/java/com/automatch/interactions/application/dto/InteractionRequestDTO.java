package com.automatch.interactions.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InteractionRequestDTO(
        @Schema(example = "1") @NotNull Long userId,
        @Schema(example = "25") @NotNull Long vehicleId,
        @Schema(example = "LIKE") @NotBlank String type,
        @Schema(example = "El usuario marcó como favorito el vehículo") String description) {
}