package com.team1.projectknakish.dto.responses;

import java.util.UUID;

public record SectionResponse(
        UUID id,
        String code,
        String name
) {
}
