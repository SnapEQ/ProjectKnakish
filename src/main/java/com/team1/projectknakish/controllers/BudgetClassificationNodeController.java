package com.team1.projectknakish.controllers;

import com.team1.projectknakish.domain.entities.tasks.BudgetClassificationNode;
import com.team1.projectknakish.dto.responses.BudgetClassificationNodeResponse;
import com.team1.projectknakish.mappers.BudgetClassificationMapper;
import com.team1.projectknakish.services.BudgetClassificationNodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/budget-classification-nodes")
public class BudgetClassificationNodeController {

    private final BudgetClassificationNodeService budgetClassificationNodeService;
    private final BudgetClassificationMapper budgetClassificationMapper;

    public BudgetClassificationNodeController(BudgetClassificationNodeService budgetClassificationNodeService, BudgetClassificationMapper budgetClassificationMapper) {
        this.budgetClassificationNodeService = budgetClassificationNodeService;
        this.budgetClassificationMapper = budgetClassificationMapper;
    }

    @GetMapping
    public ResponseEntity<List<BudgetClassificationNodeResponse>> getAllBudgetCLassificationNodes() {
        List<BudgetClassificationNode> budgetClassificationNodes = budgetClassificationNodeService.getAllBudgetClassificationNodes();
        List<BudgetClassificationNodeResponse> budgetClassificationNodeResponses = budgetClassificationNodes.stream()
                .map(budgetClassificationMapper::toResponse)
                .toList();
        return new ResponseEntity<>(budgetClassificationNodeResponses, HttpStatus.OK);
    }

}
