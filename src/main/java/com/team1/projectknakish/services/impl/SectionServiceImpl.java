package com.team1.projectknakish.services.impl;

import com.team1.projectknakish.domain.entities.dict.Section;
import com.team1.projectknakish.repositories.SectionRepository;
import com.team1.projectknakish.services.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }
}
