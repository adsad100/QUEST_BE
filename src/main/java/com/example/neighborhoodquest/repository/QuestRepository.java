package com.example.neighborhoodquest.repository;

import com.example.neighborhoodquest.domain.Quest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestRepository extends JpaRepository<Quest, Long> {

    @Override
    @EntityGraph(attributePaths = {"checkpoints"})
    Optional<Quest> findById(Long id);
}
