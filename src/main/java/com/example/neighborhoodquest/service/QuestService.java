package com.example.neighborhoodquest.service;

import com.example.neighborhoodquest.domain.Checkpoint;
import com.example.neighborhoodquest.domain.Quest;
import com.example.neighborhoodquest.dto.CheckpointResponse;
import com.example.neighborhoodquest.dto.QuestDetailResponse;
import com.example.neighborhoodquest.dto.QuestSummaryResponse;
import com.example.neighborhoodquest.exception.QuestNotFoundException;
import com.example.neighborhoodquest.repository.CheckpointRepository;
import com.example.neighborhoodquest.repository.QuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestService {

    private final QuestRepository questRepository;
    private final CheckpointRepository checkpointRepository;

    public List<QuestSummaryResponse> getAllQuests() {
        return questRepository.findAll().stream()
                .map(this::toSummaryResponse)
                .collect(Collectors.toList());
    }

    public QuestDetailResponse getQuestDetail(Long questId) {
        Quest quest = questRepository.findById(questId)
                .orElseThrow(() -> new QuestNotFoundException(questId));

        List<Checkpoint> checkpoints = checkpointRepository.findByQuestIdOrderByOrderIndexAsc(questId);

        List<CheckpointResponse> checkpointResponses = checkpoints.stream()
                .map(this::toCheckpointResponse)
                .collect(Collectors.toList());

        return QuestDetailResponse.builder()
                .id(quest.getId())
                .title(quest.getTitle())
                .summary(quest.getSummary())
                .description(quest.getDescription())
                .estimatedDurationMin(quest.getEstimatedDurationMin())
                .totalDistanceM(quest.getTotalDistanceM())
                .checkpoints(checkpointResponses)
                .build();
    }

    private QuestSummaryResponse toSummaryResponse(Quest quest) {
        int checkpointCount = quest.getCheckpoints() != null ? quest.getCheckpoints().size() : 0;
        return QuestSummaryResponse.builder()
                .id(quest.getId())
                .title(quest.getTitle())
                .summary(quest.getSummary())
                .estimatedDurationMin(quest.getEstimatedDurationMin())
                .totalDistanceM(quest.getTotalDistanceM())
                .checkpointCount(checkpointCount)
                .build();
    }

    private CheckpointResponse toCheckpointResponse(Checkpoint checkpoint) {
        return CheckpointResponse.builder()
                .id(checkpoint.getId())
                .name(checkpoint.getName())
                .description(checkpoint.getDescription())
                .latitude(checkpoint.getLatitude())
                .longitude(checkpoint.getLongitude())
                .orderIndex(checkpoint.getOrderIndex())
                .radiusM(checkpoint.getRadiusM())
                .build();
    }
}
