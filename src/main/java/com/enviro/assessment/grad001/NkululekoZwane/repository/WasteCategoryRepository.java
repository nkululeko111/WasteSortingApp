package com.enviro.assessment.grad001.NkululekoZwane.repository;

import com.enviro.assessment.grad001.NkululekoZwane.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for WasteCategory entities.
 * This interface provides CRUD operations for WasteCategory using Spring Data JPA.
 */
@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}
