package com.team1.projectknakish.services.impl;

import com.team1.projectknakish.domain.entities.dict.SubSection;
import com.team1.projectknakish.repositories.SubSectionRepository;
import com.team1.projectknakish.services.SubSectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubSectionServiceImpl implements SubSectionService {

    private final SubSectionRepository subSectionRepository;

    @Override
    public List<SubSection> getAllSubSections() {
        return subSectionRepository.findAll();
    }
}
