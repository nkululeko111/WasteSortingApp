package com.enviro.assessment.grad001.NkululekoZwane.repository;

import com.enviro.assessment.grad001.NkululekoZwane.model.DisposalGuidelines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for DisposalGuidelines entities.
 * This interface provides CRUD operations for DisposalGuidelines using Spring Data JPA.
 */
@Repository
public interface DisposalGuidelinesRepository extends JpaRepository<DisposalGuidelines, Long> {
}
