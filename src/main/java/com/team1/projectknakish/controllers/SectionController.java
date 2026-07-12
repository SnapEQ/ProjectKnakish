package com.team1.projectknakish.controllers;

import com.team1.projectknakish.domain.entities.dict.Section;
import com.team1.projectknakish.dto.responses.SectionResponse;
import com.team1.projectknakish.mappers.SectionMapper;
import com.team1.projectknakish.services.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/sections")
public class SectionController {

    private final SectionService sectionService;
    private final SectionMapper sectionMapper;

    public SectionController(SectionService sectionService, SectionMapper sectionMapper) {
        this.sectionService = sectionService;
        this.sectionMapper = sectionMapper;
    }

    @GetMapping
    ResponseEntity<List<SectionResponse>> getAllSections() {
        List<Section>sections = sectionService.getAllSections();
        List<SectionResponse>sectionResponses = sections.stream().map(sectionMapper::toResponse).toList();
        return new ResponseEntity<>(sectionResponses, HttpStatus.OK);
    }
}
