package com.team1.projectknakish.controllers;

import com.team1.projectknakish.domain.entities.dict.FinanceSource;
import com.team1.projectknakish.dto.responses.FinanceSourceResponse;
import com.team1.projectknakish.mappers.FinanceSourceMapper;
import com.team1.projectknakish.services.FinanceSourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/finance-sources")
public class FinanceSourceController {

    private final FinanceSourceService financeSourceService;
    private final FinanceSourceMapper financeSourceMapper;

    public FinanceSourceController(FinanceSourceService financeSourceService, FinanceSourceMapper financeSourceMapper) {
        this.financeSourceService = financeSourceService;
        this.financeSourceMapper = financeSourceMapper;
    }

    @GetMapping
    public ResponseEntity<List<FinanceSourceResponse>> getAllFinanceSources() {
        List<FinanceSource> financeSources = financeSourceService.getAllFinanceSources();
        List<FinanceSourceResponse> financeSourceResponses = financeSources.stream().map(financeSourceMapper::toResponse).toList();
        return new ResponseEntity<>(financeSourceResponses, HttpStatus.OK);
    }
}
