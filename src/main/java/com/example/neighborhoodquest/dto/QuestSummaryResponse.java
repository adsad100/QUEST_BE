package com.example.neighborhoodquest.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class QuestSummaryResponse {
    Long id;
    String title;
    String summary;
    Integer estimatedDurationMin;
    Integer totalDistanceM;
    Integer checkpointCount;
}
