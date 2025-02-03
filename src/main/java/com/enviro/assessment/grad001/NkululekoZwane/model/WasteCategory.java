package com.enviro.assessment.grad001.NkululekoZwane.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Entity class representing a waste category.
 * This class is mapped to a database table using JPA annotations.
 * It includes validation constraints to ensure data integrity.
 */
@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name is mandatory")
    @Size(max = 54, message = "Category name must be at most 54 characters")
    private String name;

    @Size(max = 255, message = "Description must be at most 255 characters")
    private String description;


    public WasteCategory() {}


    public WasteCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
