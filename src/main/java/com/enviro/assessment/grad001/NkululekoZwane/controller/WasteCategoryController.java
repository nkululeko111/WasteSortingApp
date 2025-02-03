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


@RestController
@RequestMapping("/api/waste-categories")
@Validated
public class WasteCategoryController {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;


    @GetMapping
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }


    @GetMapping("/{id}")
    public WasteCategory getWasteCategoryById(@PathVariable Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory not found with id " + id));
    }


    @PostMapping
    public WasteCategory createWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }


    @PutMapping("/{id}")
    public WasteCategory updateWasteCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory wasteCategoryDetails) {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory not found with id " + id));
        wasteCategory.setName(wasteCategoryDetails.getName());
        wasteCategory.setDescription(wasteCategoryDetails.getDescription());
        return wasteCategoryRepository.save(wasteCategory);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWasteCategory(@PathVariable Long id) {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory not found with id " + id));
        wasteCategoryRepository.delete(wasteCategory);
        return ResponseEntity.ok().build();
    }
}
