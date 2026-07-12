package com.team1.projectknakish.services;

import com.team1.projectknakish.domain.entities.tasks.BudgetClassificationNode;

import java.util.List;
import java.util.UUID;

public interface BudgetClassificationNodeService {

    List<BudgetClassificationNode> getAllBudgetClassificationNodes();
    BudgetClassificationNode getBudgetClassificationNodeById(UUID id);
}
