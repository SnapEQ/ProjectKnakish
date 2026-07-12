package com.team1.projectknakish.dto.responses;

import java.util.UUID;

public record FinanceSourceResponse(
        UUID id,
        String code,
        String name
) {
}
