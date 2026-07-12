package com.team1.projectknakish.mappers;

import com.team1.projectknakish.domain.entities.Department;
import com.team1.projectknakish.dto.responses.DepartmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DepartmentMapper {

    DepartmentResponse toResponse(Department entity);
}
