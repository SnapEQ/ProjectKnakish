package com.team1.projectknakish.controllers;

import com.team1.projectknakish.domain.entities.dict.ExpenseGroup;
import com.team1.projectknakish.dto.responses.ExpenseGroupResponse;
import com.team1.projectknakish.mappers.ExpenseGroupMapper;
import com.team1.projectknakish.services.ExpenseGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/expense-groups")
public class ExpenseGroupController {

    private final ExpenseGroupService expenseGroupService;
    private final ExpenseGroupMapper expenseGroupMapper;

    ExpenseGroupController(ExpenseGroupService expenseGroupService, ExpenseGroupMapper expenseGroupMapper) {
        this.expenseGroupService = expenseGroupService;
        this.expenseGroupMapper = expenseGroupMapper;
    }

    @GetMapping
    public ResponseEntity<List<ExpenseGroupResponse>> getAllExpenseGroups() {
        List<ExpenseGroup> expenseGroups = expenseGroupService.getAllExpenseGroups();
        List<ExpenseGroupResponse>expenseGroupResponses = expenseGroups.stream().map(expenseGroupMapper::toResponse).toList();
        return new ResponseEntity<>(expenseGroupResponses, HttpStatus.OK);
    }
}
