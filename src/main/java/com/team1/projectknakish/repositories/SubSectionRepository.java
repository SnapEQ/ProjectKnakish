package com.team1.projectknakish.repositories;

import com.team1.projectknakish.domain.entities.dict.SubSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubSectionRepository extends JpaRepository<SubSection, UUID> {
}
