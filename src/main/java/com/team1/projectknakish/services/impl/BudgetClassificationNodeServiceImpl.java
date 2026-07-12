package com.team1.projectknakish.services.impl;

import com.team1.projectknakish.domain.entities.tasks.BudgetClassificationNode;
import com.team1.projectknakish.repositories.BudgetClassificationNodeRepository;
import com.team1.projectknakish.services.BudgetClassificationNodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BudgetClassificationNodeServiceImpl implements BudgetClassificationNodeService {

    private final BudgetClassificationNodeRepository budgetClassificationNodeRepository;

    @Override
    public List<BudgetClassificationNode> getAllBudgetClassificationNodes() {
        return budgetClassificationNodeRepository.findAll();
    }

    @Override
    public BudgetClassificationNode getBudgetClassificationNodeById(UUID id) {
        return budgetClassificationNodeRepository.findById(id).orElse(null);
    }
}
