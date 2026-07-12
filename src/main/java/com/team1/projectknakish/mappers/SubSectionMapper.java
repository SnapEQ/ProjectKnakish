package com.team1.projectknakish.mappers;

import com.team1.projectknakish.domain.entities.dict.SubSection;
import com.team1.projectknakish.dto.responses.SubSectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SubSectionMapper {

    SubSectionResponse toResponse(SubSection entity);
}
