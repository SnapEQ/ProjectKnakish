package com.team1.projectknakish.services;

import com.team1.projectknakish.domain.entities.dict.ExpenseGroup;

import java.util.List;
import java.util.UUID;

public interface ExpenseGroupService {

    List<ExpenseGroup> getAllExpenseGroups();
    ExpenseGroup getExpenseGroupById(UUID id);
}
