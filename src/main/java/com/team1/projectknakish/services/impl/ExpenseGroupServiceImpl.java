package com.team1.projectknakish.services.impl;

import com.team1.projectknakish.domain.entities.dict.ExpenseGroup;
import com.team1.projectknakish.repositories.ExpenseGroupRepository;
import com.team1.projectknakish.services.ExpenseGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpenseGroupServiceImpl implements ExpenseGroupService {

    private final ExpenseGroupRepository expenseGroupRepository;


    @Override
    public List<ExpenseGroup> getAllExpenseGroups() {
        return expenseGroupRepository.findAll();
    }

    @Override
    public ExpenseGroup getExpenseGroupById(UUID id) {
        return expenseGroupRepository.getById(id);
    }
}
