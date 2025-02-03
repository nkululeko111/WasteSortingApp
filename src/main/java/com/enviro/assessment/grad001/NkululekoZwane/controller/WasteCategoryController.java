package com.enviro.assessment.grad001.NkululekoZwane.controller;

import com.enviro.assessment.grad001.NkululekoZwane.model.WasteCategory;
import com.enviro.assessment.grad001.NkululekoZwane.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.NkululekoZwane.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller class for managing waste categories.
 * Provides endpoints for CRUD operations on waste categories.
 */
@RestController
@RequestMapping("/api/waste-categories")
@Validated
public class WasteCategoryController {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    /**
     * Retrieves all waste categories.
     *
     * @return A list of all waste categories.
     */
    @GetMapping
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    /**
     * Retrieves a waste category by its ID.
     *
     * @param id The ID of the waste category.
     * @return The waste category with the specified ID.
     * @throws ResourceNotFoundException if the waste category is not found.
     */
    @GetMapping("/{id}")
    public WasteCategory getWasteCategoryById(@PathVariable Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory not found with id " + id));
    }

    /**
     * Creates a new waste category.
     *
     * @param wasteCategory The details of the new waste category.
     * @return The created waste category.
     */
    @PostMapping
    public WasteCategory createWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    /**
     * Updates an existing waste category.
     *
     * @param id The ID of the waste category to update.
     * @param wasteCategoryDetails The updated details of the waste category.
     * @return The updated waste category.
     * @throws ResourceNotFoundException if the waste category is not found.
     */
    @PutMapping("/{id}")
    public WasteCategory updateWasteCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory wasteCategoryDetails) {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory not found with id " + id));
        wasteCategory.setName(wasteCategoryDetails.getName());
        wasteCategory.setDescription(wasteCategoryDetails.getDescription());
        return wasteCategoryRepository.save(wasteCategory);
    }

    /**
     * Deletes a waste category.
     *
     * @param id The ID of the waste category to delete.
     * @return A ResponseEntity indicating the outcome.
     * @throws ResourceNotFoundException if the waste category is not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWasteCategory(@PathVariable Long id) {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory not found with id " + id));
        wasteCategoryRepository.delete(wasteCategory);
        return ResponseEntity.ok().build();
    }
}
