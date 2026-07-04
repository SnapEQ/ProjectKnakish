package com.team1.projectknakish.controllers;

import com.team1.projectknakish.domain.entities.dict.BudgetPart;
import com.team1.projectknakish.dto.BudgetPartDto;
import com.team1.projectknakish.mappers.BudgetPartMapper;
import com.team1.projectknakish.services.BudgetPartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/budget-parts")
public class BudgetPartController {

    private final BudgetPartService budgetPartService;
    private final BudgetPartMapper budgetPartMapper;

    public BudgetPartController(BudgetPartService budgetPartService, BudgetPartMapper budgetPartMapper) {
        this.budgetPartService = budgetPartService;
        this.budgetPartMapper = budgetPartMapper;
    }


    @GetMapping
    public ResponseEntity<List<BudgetPartDto>> getAllBudgetParts() {
        List<BudgetPart> budgetParts = budgetPartService.getAllBudgetParts();
        List<BudgetPartDto>budgetPartsDto = budgetParts.stream().map(budgetPartMapper::toDto).toList();
        return new ResponseEntity<>(budgetPartsDto,HttpStatus.OK);
    }
}
