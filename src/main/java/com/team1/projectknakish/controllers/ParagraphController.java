package com.team1.projectknakish.controllers;

import com.team1.projectknakish.domain.entities.dict.Paragraph;
import com.team1.projectknakish.dto.responses.ParagraphResponse;
import com.team1.projectknakish.mappers.ParagraphMapper;
import com.team1.projectknakish.services.ParagraphService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/paragraphs")
public class ParagraphController {

    private final ParagraphService paragraphService;
    private final ParagraphMapper paragraphMapper;

    public ParagraphController(ParagraphService paragraphService, ParagraphMapper paragraphMapper) {
        this.paragraphService = paragraphService;
        this.paragraphMapper = paragraphMapper;
    }

    @GetMapping
    ResponseEntity<List<ParagraphResponse>> getAllParagraphs() {
        List<Paragraph> paragraphs = paragraphService.getAllParagraphs();
        List<ParagraphResponse> paragraphResponses = paragraphs.stream().map(paragraphMapper::toResponse).toList();

        return new ResponseEntity<>(paragraphResponses, HttpStatus.OK);
    }


}
