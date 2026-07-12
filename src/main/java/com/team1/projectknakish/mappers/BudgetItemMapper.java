package com.team1.projectknakish.mappers;

import com.team1.projectknakish.domain.entities.Department;
import com.team1.projectknakish.domain.entities.dict.*;
import com.team1.projectknakish.domain.entities.tasks.BudgetClassificationNode;
import com.team1.projectknakish.dto.BudgetItemDto;
import com.team1.projectknakish.domain.entities.BudgetItem;
import com.team1.projectknakish.dto.NamedRefrenceDto;
import com.team1.projectknakish.dto.RefrenceDto;
import com.team1.projectknakish.dto.responses.BudgetItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BudgetItemMapper {
    @Mapping(target = "budgetPartId", source = "budgetPart.id")
    @Mapping(target = "sectionId", source = "section.id")
    @Mapping(target = "subSectionId", source = "subSection.id")
    @Mapping(target = "paragraphId", source = "paragraph.id")
    @Mapping(target = "financeSourceId", source = "financeSource.id")
    @Mapping(target = "expenseGroupId", source = "expenseGroup.id")
    @Mapping(target = "budgetClassificationNodeId", source = "budgetClassificationNode.id")
    @Mapping(target = "departmentId", source = "department.id")
    BudgetItemDto toDto(BudgetItem entity);

    @Mapping(target = "budgetPart", source = "budgetPart")
    @Mapping(target = "section", source = "section")
    @Mapping(target = "subSection", source = "subSection")
    @Mapping(target = "paragraph", source = "paragraph")
    @Mapping(target = "financeSource", source = "financeSource")
    @Mapping(target = "expenseGroup", source = "expenseGroup")
    @Mapping(target = "budgetClassificationNode", source = "budgetClassificationNode")
    @Mapping(target = "programName", source = "programName")
    @Mapping(target = "department", source = "department")
    BudgetItemResponse toResponse(BudgetItem entity);

    default RefrenceDto toRefrenceDto(BudgetPart entity){
        return new RefrenceDto(entity.getId(), entity.getCode(), entity.getName());
    }

    default RefrenceDto toRefrenceDto(Section entity){
        return new RefrenceDto(entity.getId(), entity.getCode(), entity.getName());
    }

    default RefrenceDto toRefrenceDto(SubSection entity){
        return new RefrenceDto(entity.getId(), entity.getCode(), entity.getName());
    }

    default RefrenceDto toRefrenceDto(Paragraph entity){
        return new RefrenceDto(entity.getId(), entity.getCode(), entity.getName());
    }

    default RefrenceDto toRefrenceDto(FinanceSource entity){
        return new RefrenceDto(entity.getId(), entity.getCode(), entity.getName());
    }

    default RefrenceDto toRefrenceDto(BudgetClassificationNode entity){
        return new RefrenceDto(entity.getId(), entity.getCode(), entity.getName());
    }

    default NamedRefrenceDto toNamedRefrenceDto(Department entity){
        return new NamedRefrenceDto(entity.getId(), entity.getName());
    }

    default NamedRefrenceDto toNamedRefrenceDto(ExpenseGroup entity){
        return new NamedRefrenceDto(entity.getId(), entity.getName());
    }
}

