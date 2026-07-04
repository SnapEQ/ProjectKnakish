package com.team1.projectknakish.repositories;

import com.team1.projectknakish.domain.entities.dict.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, UUID> {
}
