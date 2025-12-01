package com.example.neighborhoodquest.dto;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class QuestDetailResponse {
    Long id;
    String title;
    String summary;
    String description;
    Integer estimatedDurationMin;
    Integer totalDistanceM;
    @Singular
    List<CheckpointResponse> checkpoints;
}
