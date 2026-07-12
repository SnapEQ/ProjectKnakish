package com.team1.projectknakish.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BudgetItemDto {
    private UUID id;
    private UUID budgetPartId;
    private UUID sectionId;
    private UUID subSectionId;
    private UUID paragraphId;
    private UUID financeSourceId;
    private UUID expenseGroupId;
    private UUID budgetClassificationNodeId;
    private String programName;
    private UUID departmentId;
}
