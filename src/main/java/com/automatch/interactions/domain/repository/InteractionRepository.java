package com.automatch.interactions.domain.repository;

import com.automatch.interactions.domain.model.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Long> {

    // Método personalizado para buscar interacciones por userId
    List<Interaction> findByUserId(Long userId);
}