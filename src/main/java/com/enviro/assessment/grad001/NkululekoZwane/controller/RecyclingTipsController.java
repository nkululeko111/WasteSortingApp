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


}
