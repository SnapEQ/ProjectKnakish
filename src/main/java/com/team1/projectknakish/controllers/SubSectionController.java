package com.team1.projectknakish.controllers;

import com.team1.projectknakish.domain.entities.dict.SubSection;
import com.team1.projectknakish.dto.responses.SubSectionResponse;
import com.team1.projectknakish.mappers.SubSectionMapper;
import com.team1.projectknakish.services.SubSectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/sub-sections")
public class SubSectionController {

    private final SubSectionService subSectionService;
    private final SubSectionMapper subSectionMapper;

    public SubSectionController(SubSectionService subSectionService, SubSectionMapper subSectionMapper) {
        this.subSectionService = subSectionService;
        this.subSectionMapper = subSectionMapper;
    }

    @GetMapping
    ResponseEntity<List<SubSectionResponse>> getAllSubSections() {
        List<SubSection> subSections;
        subSections = subSectionService.getAllSubSections();
        List<SubSectionResponse> subSectionResponses = subSections.stream().map(subSectionMapper::toResponse).toList();
        return new ResponseEntity<>(subSectionResponses, HttpStatus.OK);
    }
}
