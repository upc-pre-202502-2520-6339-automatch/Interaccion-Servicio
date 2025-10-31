package com.automatch.interactions.infrastructure.repository;

import com.automatch.interactions.domain.model.Interaction;
import com.automatch.interactions.domain.repository.InteractionRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface JpaInteractionRepository extends InteractionRepository {
}