package com.team1.projectknakish.mappers;

import com.team1.projectknakish.domain.entities.dict.ExpenseGroup;
import com.team1.projectknakish.dto.responses.ExpenseGroupResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ExpenseGroupMapper {

    ExpenseGroupResponse toResponse(ExpenseGroup entity);
}
