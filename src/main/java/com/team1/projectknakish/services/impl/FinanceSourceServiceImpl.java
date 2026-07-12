package com.team1.projectknakish.services.impl;

import com.team1.projectknakish.domain.entities.dict.FinanceSource;
import com.team1.projectknakish.repositories.FinanceSourceRepository;
import com.team1.projectknakish.services.FinanceSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceSourceServiceImpl implements FinanceSourceService {

    private final FinanceSourceRepository financeSourceRepository;

    @Override
    public List<FinanceSource> getAllFinanceSources() {
        return financeSourceRepository.findAll();
    }
}
