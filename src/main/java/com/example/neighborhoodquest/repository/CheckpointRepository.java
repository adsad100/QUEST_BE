package com.example.neighborhoodquest.repository;

import com.example.neighborhoodquest.domain.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckpointRepository extends JpaRepository<Checkpoint, Long> {

    List<Checkpoint> findByQuestIdOrderByOrderIndexAsc(Long questId);
}
