package com.team1.projectknakish.controllers;

import com.team1.projectknakish.domain.entities.BudgetItem;
import com.team1.projectknakish.dto.requests.CreateBudgetItemRequest;
import com.team1.projectknakish.dto.responses.BudgetItemResponse;
import com.team1.projectknakish.mappers.BudgetItemMapper;
import com.team1.projectknakish.services.BudgetItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budget-items")
public class BudgetItemController {

    private final BudgetItemMapper budgetItemMapper;
    private final BudgetItemService budgetItemService;

    public BudgetItemController(BudgetItemMapper budgetItemMapper, BudgetItemService budgetItemService) {
        this.budgetItemMapper = budgetItemMapper;
        this.budgetItemService = budgetItemService;
    }

    @PostMapping
    public ResponseEntity<BudgetItemResponse> createBudgetItem(@RequestBody CreateBudgetItemRequest request) {
        BudgetItem budgetItem = budgetItemService.createBudgetItem(request);
        return new ResponseEntity<>(budgetItemMapper.toResponse(budgetItem), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BudgetItemResponse>> getAllBudgetItem() {
        List<BudgetItem> budgetItemList = budgetItemService.getAllBudgetItem();
        List<BudgetItemResponse> budgetItemResponseList = budgetItemList.stream().map(budgetItemMapper::toResponse).toList();
        return new ResponseEntity<>(budgetItemResponseList, HttpStatus.OK);
    }

}
