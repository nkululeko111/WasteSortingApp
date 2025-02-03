package com.enviro.assessment.grad001.NkululekoZwane.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class DisposalGuidelines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 40, message = "Title must be at most 40 characters")
    private String title;

    @NotBlank(message = "Guideline is mandatory")
    @Size(max = 500, message = "Guideline must be at most 500 characters")
    private String guideline;


    public DisposalGuidelines() {}

    public DisposalGuidelines(String title, String guideline) {
        this.title = title;
        this.guideline = guideline;
    }


    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getGuideline() {
        return guideline;
    }


    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }
}
