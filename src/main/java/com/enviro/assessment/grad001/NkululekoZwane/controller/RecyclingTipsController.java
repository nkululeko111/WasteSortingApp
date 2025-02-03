package com.enviro.assessment.grad001.NkululekoZwane.controller;

import com.enviro.assessment.grad001.NkululekoZwane.model.RecyclingTips;
import com.enviro.assessment.grad001.NkululekoZwane.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.NkululekoZwane.repository.RecyclingTipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller class for managing recycling tips.
 * Provides endpoints for CRUD operations on recycling tips.
 */
@RestController
@RequestMapping("/api/recycling-tips")
@Validated
public class RecyclingTipsController {

    @Autowired
    private RecyclingTipsRepository recyclingTipRepository;

    /**
     * Retrieves all recycling tips.
     *
     * @return A list of all recycling tips.
     */
    @GetMapping
    public List<RecyclingTips> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }

    /**
     * Retrieves a recycling tip by its ID.
     *
     * @param id The ID of the recycling tip.
     * @return The recycling tip with the specified ID.
     * @throws ResourceNotFoundException if the recycling tip is not found.
     */
    @GetMapping("/{id}")
    public RecyclingTips getRecyclingTipById(@PathVariable Long id) {
        return recyclingTipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip not found with id " + id));
    }

    /**
     * Creates a new recycling tip.
     *
     * @param tip The details of the new recycling tip.
     * @return The created recycling tip.
     */
    @PostMapping
    public RecyclingTips createRecyclingTip(@Valid @RequestBody RecyclingTips tip) {
        return recyclingTipRepository.save(tip);
    }

    /**
     * Updates an existing recycling tip.
     *
     * @param id The ID of the recycling tip to update.
     * @param tipDetails The updated details of the recycling tip.
     * @return The updated recycling tip.
     * @throws ResourceNotFoundException if the recycling tip is not found.
     */
    @PutMapping("/{id}")
    public RecyclingTips updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTips tipDetails) {
        RecyclingTips tip = recyclingTipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip not found with id " + id));
        tip.setTip(tipDetails.getTip());
        return recyclingTipRepository.save(tip);
    }

    /**
     * Deletes a recycling tip.
     *
     * @param id The ID of the recycling tip to delete.
     * @return A ResponseEntity indicating the outcome.
     * @throws ResourceNotFoundException if the recycling tip is not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecyclingTip(@PathVariable Long id) {
        RecyclingTips tip = recyclingTipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip not found with id " + id));
        recyclingTipRepository.delete(tip);
        return ResponseEntity.ok().build();
    }
}
