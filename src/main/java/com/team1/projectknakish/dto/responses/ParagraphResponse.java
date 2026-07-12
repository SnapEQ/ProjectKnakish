package com.team1.projectknakish.dto.responses;

import java.util.UUID;

public record ParagraphResponse(
        UUID id,
        String code,
        String name
) {
}
