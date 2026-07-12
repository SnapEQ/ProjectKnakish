package com.team1.projectknakish.dto.responses;

import java.util.UUID;

public record ExpenseGroupResponse(
        UUID id,
        String name
) {
}
