package com.enviro.assessment.grad001.NkululekoZwane.controller;

import com.enviro.assessment.grad001.NkululekoZwane.model.DisposalGuidelines;
import com.enviro.assessment.grad001.NkululekoZwane.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.NkululekoZwane.repository.DisposalGuidelinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller class for managing disposal guidelines.
 * Provides endpoints for CRUD operations on disposal guidelines.
 */
@RestController
@RequestMapping("/api/disposal-guidelines")
@Validated
public class DisposalGuidelinesController {

    @Autowired
    private DisposalGuidelinesRepository disposalGuidelineRepository;

    /**
     * Retrieves all disposal guidelines.
     *
     * @return A list of all disposal guidelines.
     */
    @GetMapping
    public List<DisposalGuidelines> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    /**
     * Retrieves a disposal guideline by its ID.
     *
     * @param id The ID of the disposal guideline.
     * @return The disposal guideline with the specified ID.
     * @throws ResourceNotFoundException if the disposal guideline is not found.
     */
    @GetMapping("/{id}")
    public DisposalGuidelines getDisposalGuidelineById(@PathVariable Long id) {
        return disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline not found with id " + id));
    }

    /**
     * Creates a new disposal guideline.
     *
     * @param guideline The details of the new disposal guideline.
     * @return The created disposal guideline.
     */
    @PostMapping
    public DisposalGuidelines createDisposalGuideline(@Valid @RequestBody DisposalGuidelines guideline) {
        return disposalGuidelineRepository.save(guideline);
    }

    /**
     * Updates an existing disposal guideline.
     *
     * @param id The ID of the disposal guideline to update.
     * @param guidelineDetails The updated details of the disposal guideline.
     * @return The updated disposal guideline.
     * @throws ResourceNotFoundException if the disposal guideline is not found.
     */
    @PutMapping("/{id}")
    public DisposalGuidelines updateDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelines guidelineDetails) {
        DisposalGuidelines guideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline not found with id " + id));
        guideline.setTitle(guidelineDetails.getTitle());
        guideline.setGuideline(guidelineDetails.getGuideline());
        return disposalGuidelineRepository.save(guideline);
    }

    /**
     * Deletes a disposal guideline.
     *
     * @param id The ID of the disposal guideline to delete.
     * @return A ResponseEntity indicating the outcome.
     * @throws ResourceNotFoundException if the disposal guideline is not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDisposalGuideline(@PathVariable Long id) {
        DisposalGuidelines guideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline not found with id " + id));
        disposalGuidelineRepository.delete(guideline);
        return ResponseEntity.ok().build();
    }
}
