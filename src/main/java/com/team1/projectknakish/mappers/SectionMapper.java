package com.team1.projectknakish.mappers;

import com.team1.projectknakish.domain.entities.dict.Section;
import com.team1.projectknakish.dto.responses.SectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SectionMapper {

    SectionResponse toResponse(Section entity);
}
