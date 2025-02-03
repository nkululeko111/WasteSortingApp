package com.enviro.assessment.grad001.NkululekoZwane.repository;

import com.enviro.assessment.grad001.NkululekoZwane.model.RecyclingTips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for RecyclingTips entities.
 * This interface provides CRUD operations for RecyclingTips using Spring Data JPA.
 */
@Repository
public interface RecyclingTipsRepository extends JpaRepository<RecyclingTips, Long> {
}
