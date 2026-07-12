package com.team1.projectknakish.services.impl;

import com.team1.projectknakish.domain.entities.dict.Paragraph;
import com.team1.projectknakish.repositories.ParagraphRepository;
import com.team1.projectknakish.services.ParagraphService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParagraphServiceImpl implements ParagraphService {

    private final ParagraphRepository paragraphRepository;

    @Override
    public List<Paragraph> getAllParagraphs() {
        return paragraphRepository.findAll();
    }
}
