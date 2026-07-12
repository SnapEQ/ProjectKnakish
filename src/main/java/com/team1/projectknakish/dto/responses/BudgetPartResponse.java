package com.team1.projectknakish.dto.responses;

import java.util.UUID;

public record BudgetPartResponse (
        UUID id,
        String code,
        String name
) {
}
