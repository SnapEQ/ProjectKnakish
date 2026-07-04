package com.team1.projectknakish.services.impl;

import com.team1.projectknakish.domain.entities.dict.BudgetPart;
import com.team1.projectknakish.repositories.BudgetPartRepository;
import com.team1.projectknakish.services.BudgetPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetPartServiceImpl implements BudgetPartService {

    private final BudgetPartRepository budgetPartRepository;


    @Override
    public List<BudgetPart> getAllBudgetParts() {
        return budgetPartRepository.findAll();
    }

}
