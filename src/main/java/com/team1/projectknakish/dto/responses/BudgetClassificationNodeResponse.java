package com.team1.projectknakish.dto.responses;

import com.team1.projectknakish.domain.entities.tasks.ClassificationLevel;

import java.util.UUID;

public record BudgetClassificationNodeResponse(
        UUID id,
        String code,
        String name,
        ClassificationLevel classificationLevel,
        UUID parentNode
) {
}
