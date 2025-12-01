package com.example.neighborhoodquest.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CheckpointResponse {
    Long id;
    String name;
    String description;
    Double latitude;
    Double longitude;
    Integer orderIndex;
    Integer radiusM;
}
