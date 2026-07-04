package com.team1.projectknakish.services;

import com.team1.projectknakish.dto.requests.CreateBudgetItemRequest;
import com.team1.projectknakish.domain.entities.BudgetItem;


import java.util.List;
import java.util.UUID;


public interface BudgetItemService {
    BudgetItem createBudgetItem(CreateBudgetItemRequest createBudgetItemRequest);
    List<BudgetItem> getAllBudgetItem();
    BudgetItem getBudgetItemById(UUID id);
}
