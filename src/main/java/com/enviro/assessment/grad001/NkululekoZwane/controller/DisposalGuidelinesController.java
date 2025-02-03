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







}
