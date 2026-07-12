package com.team1.projectknakish.dto.responses;

import java.util.UUID;

public record SubSectionResponse(
        UUID id,
        String code,
        String name
) {
}
