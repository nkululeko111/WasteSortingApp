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

}
