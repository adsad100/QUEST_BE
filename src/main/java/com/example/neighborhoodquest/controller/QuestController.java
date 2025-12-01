package com.example.neighborhoodquest.controller;

import com.example.neighborhoodquest.dto.QuestDetailResponse;
import com.example.neighborhoodquest.dto.QuestSummaryResponse;
import com.example.neighborhoodquest.service.QuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quests")
@RequiredArgsConstructor
public class QuestController {

    private final QuestService questService;

    @GetMapping
    public List<QuestSummaryResponse> getQuests() {
        return questService.getAllQuests();
    }

    @GetMapping("/{id}")
    public QuestDetailResponse getQuest(@PathVariable Long id) {
        return questService.getQuestDetail(id);
    }
}
