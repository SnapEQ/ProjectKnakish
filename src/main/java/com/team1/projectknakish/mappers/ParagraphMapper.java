package com.team1.projectknakish.mappers;

import com.team1.projectknakish.domain.entities.dict.Paragraph;
import com.team1.projectknakish.dto.responses.ParagraphResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ParagraphMapper {

    ParagraphResponse toResponse(Paragraph entity);
}
