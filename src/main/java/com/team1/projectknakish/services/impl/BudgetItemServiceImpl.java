package com.team1.projectknakish.services.impl;

import com.team1.projectknakish.domain.entities.Department;
import com.team1.projectknakish.domain.entities.dict.*;
import com.team1.projectknakish.domain.entities.tasks.BudgetClassificationNode;
import com.team1.projectknakish.dto.requests.CreateBudgetItemRequest;
import com.team1.projectknakish.domain.entities.BudgetItem;
import com.team1.projectknakish.repositories.*;
import com.team1.projectknakish.services.BudgetItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BudgetItemServiceImpl implements BudgetItemService {
    private final BudgetItemRepository budgetItemRepository;
    private final BudgetPartRepository budgetPartRepository;
    private final SectionRepository sectionRepository;
    private final SubSectionRepository subSectionRepository;
    private final ParagraphRepository paragraphRepository;
    private final FinanceSourceRepository financeSourceRepository;
    private final BudgetClassificationNodeRepository budgetClassificationNodeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public BudgetItem createBudgetItem(CreateBudgetItemRequest request) {
        BudgetPart budgetPart = budgetPartRepository.findById(request.budgetPartId())
                .orElseThrow(() -> new IllegalArgumentException("Budget Part not found"));

        Section section = sectionRepository.findById(request.sectionId())
                .orElseThrow(() -> new IllegalArgumentException("Section not found"));

        SubSection subSection = subSectionRepository.findById(request.subSectionId())
                .orElseThrow(() -> new IllegalArgumentException("Sub Section not found"));

        Paragraph paragraph = paragraphRepository.findById(request.paragraphId())
                .orElseThrow(() -> new IllegalArgumentException("Paragraph not found"));

        FinanceSource financeSource = financeSourceRepository.findById(request.financeSourceId())
                .orElseThrow(() -> new IllegalArgumentException("Finance Source not found"));

        BudgetClassificationNode budgetClassificationNode = budgetClassificationNodeRepository.findById(request.budgetClassificationNodeId())
                .orElseThrow(() -> new IllegalArgumentException("BudgetClassificationNode not found"));

        Department department = departmentRepository.findById(request.departmentId())
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        BudgetItem budgetItem = BudgetItem.builder()
                .budgetPart(budgetPart)
                .section(section)
                .subSection(subSection)
                .paragraph(paragraph)
                .financeSource(financeSource)
                .expenseGroup(paragraph.getExpenseGroup())
                .budgetClassificationNode(budgetClassificationNode)
                .programName(request.programName())
                .department(department)
                .build();

        return budgetItemRepository.save(budgetItem);
    }


    @Override
    public List<BudgetItem> getAllBudgetItem() {
        return List.of();
    }

    @Override
    public BudgetItem getBudgetItemById(UUID id) {
        return null;
    }

}
