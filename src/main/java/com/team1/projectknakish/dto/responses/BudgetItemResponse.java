package com.team1.projectknakish.dto.responses;



import com.team1.projectknakish.dto.NamedRefrenceDto;
import com.team1.projectknakish.dto.RefrenceDto;

import java.util.UUID;

public record BudgetItemResponse(
        UUID id,
        RefrenceDto budgetPart,
        RefrenceDto section,
        RefrenceDto subSection,
        RefrenceDto paragraph,
        RefrenceDto financeSource,
        NamedRefrenceDto expenseGroup,
        RefrenceDto budgetClassificationNode,
        String programName,
        NamedRefrenceDto department
) {

}
