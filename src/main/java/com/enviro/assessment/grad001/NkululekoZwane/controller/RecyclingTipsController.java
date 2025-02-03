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

@RestController
@RequestMapping("/api/recycling-tips")
@Validated
public class RecyclingTipsController {

    @Autowired
    private RecyclingTipsRepository recyclingTipRepository;


    @GetMapping
    public List<RecyclingTips> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }


    @GetMapping("/{id}")
    public RecyclingTips getRecyclingTipById(@PathVariable Long id) {
        return recyclingTipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip not found with id " + id));
    }


    @PostMapping
    public RecyclingTips createRecyclingTip(@Valid @RequestBody RecyclingTips tip) {
        return recyclingTipRepository.save(tip);
    }


    @PutMapping("/{id}")
    public RecyclingTips updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTips tipDetails) {
        RecyclingTips tip = recyclingTipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip not found with id " + id));
        tip.setTip(tipDetails.getTip());
        return recyclingTipRepository.save(tip);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecyclingTip(@PathVariable Long id) {
        RecyclingTips tip = recyclingTipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecyclingTip not found with id " + id));
        recyclingTipRepository.delete(tip);
        return ResponseEntity.ok().build();
    }
}
