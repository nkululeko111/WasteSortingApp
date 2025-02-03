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


@RestController
@RequestMapping("/api/disposal-guidelines")
@Validated
public class DisposalGuidelinesController {

    @Autowired
    private DisposalGuidelinesRepository disposalGuidelineRepository;


    @GetMapping
    public List<DisposalGuidelines> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll();
    }


    @GetMapping("/{id}")
    public DisposalGuidelines getDisposalGuidelineById(@PathVariable Long id) {
        return disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline not found with id " + id));
    }


    @PostMapping
    public DisposalGuidelines createDisposalGuideline(@Valid @RequestBody DisposalGuidelines guideline) {
        return disposalGuidelineRepository.save(guideline);
    }


    @PutMapping("/{id}")
    public DisposalGuidelines updateDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelines guidelineDetails) {
        DisposalGuidelines guideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline not found with id " + id));
        guideline.setTitle(guidelineDetails.getTitle());
        guideline.setGuideline(guidelineDetails.getGuideline());
        return disposalGuidelineRepository.save(guideline);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDisposalGuideline(@PathVariable Long id) {
        DisposalGuidelines guideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DisposalGuideline not found with id " + id));
        disposalGuidelineRepository.delete(guideline);
        return ResponseEntity.ok().build();
    }
}
