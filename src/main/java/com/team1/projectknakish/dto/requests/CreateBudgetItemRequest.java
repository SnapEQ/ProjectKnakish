package com.team1.projectknakish.dto.requests;

import java.util.UUID;

public record CreateBudgetItemRequest(
        UUID budgetPartId,
        UUID sectionId,
        UUID subSectionId,
        UUID paragraphId,
        UUID financeSourceId,
        UUID expenseGroupId,
        UUID budgetClassificationNodeId,
        String programName,
        UUID departmentId
) {
}