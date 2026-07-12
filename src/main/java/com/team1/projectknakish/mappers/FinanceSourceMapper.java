package com.team1.projectknakish.mappers;

import com.team1.projectknakish.domain.entities.dict.FinanceSource;
import com.team1.projectknakish.dto.responses.FinanceSourceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface FinanceSourceMapper {

    FinanceSourceResponse toResponse(FinanceSource entity);
}
