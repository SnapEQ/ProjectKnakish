package com.team1.projectknakish.mappers;

import com.team1.projectknakish.domain.entities.dict.BudgetPart;
import com.team1.projectknakish.dto.responses.BudgetPartResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BudgetPartMapper {

    BudgetPartResponse toResponse(BudgetPart entity);
}
