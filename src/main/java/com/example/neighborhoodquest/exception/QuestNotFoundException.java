package com.example.neighborhoodquest.exception;

public class QuestNotFoundException extends RuntimeException {
    public QuestNotFoundException(Long questId) {
        super("Quest with id " + questId + " not found");
    }
}
