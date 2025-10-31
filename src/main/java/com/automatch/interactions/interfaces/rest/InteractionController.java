package com.automatch.interactions.interfaces.rest;

import com.automatch.interactions.application.dto.InteractionRequestDTO;
import com.automatch.interactions.application.service.InteractionApplicationService;
import com.automatch.interactions.domain.model.Interaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/interactions")
@RequiredArgsConstructor
@Tag(name = "Interaction Controller", description = "Gestión de interacciones entre usuarios y vehículos")
public class InteractionController {

    private final InteractionApplicationService service;

    @PostMapping("/register")
    @Operation(summary = "Registrar una interacción", description = "Guarda una nueva interacción en el sistema.", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
            {
              "userId": 1,
              "vehicleId": 25,
              "type": "LIKE",
              "description": "El usuario marcó como favorito el vehículo"
            }
            """))))
    public ResponseEntity<Interaction> register(@Valid @RequestBody InteractionRequestDTO dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @GetMapping
    @Operation(summary = "Listar interacciones por usuario")
    public ResponseEntity<List<Interaction>> getByUser(@RequestParam Long userId) {
        return ResponseEntity.ok(service.findByUser(userId));
    }
}