package com.team1.projectknakish.domain.entities;

import com.team1.projectknakish.domain.entities.dict.*;
import com.team1.projectknakish.domain.entities.tasks.BudgetClassificationNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "budget_items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "budget_part_id", nullable = false)
    private BudgetPart budgetPart;


    @ManyToOne(optional = false)
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sub_section_id", nullable = false)
    private SubSection subSection;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paragraph_id", nullable = false)
    private Paragraph paragraph;

    @ManyToOne(optional = false)
    @JoinColumn(name = "finance_source_id", nullable = false)
    private FinanceSource financeSource;

    @ManyToOne(optional = false)
    @JoinColumn(name = "expense_group_id", nullable = false)
    private ExpenseGroup expenseGroup;

    @ManyToOne(optional = false)
    @JoinColumn(name = "budget_classification_node_id", nullable = false)
    private BudgetClassificationNode budgetClassificationNode;

    private String programName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

}
