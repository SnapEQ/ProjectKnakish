package com.team1.projectknakish.mappers;

import com.team1.projectknakish.domain.entities.tasks.BudgetClassificationNode;
import com.team1.projectknakish.dto.responses.BudgetClassificationNodeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BudgetClassificationMapper {

    @Mapping(target = "parentNode", source = "parent.id")
    BudgetClassificationNodeResponse toResponse(BudgetClassificationNode entity);
}
