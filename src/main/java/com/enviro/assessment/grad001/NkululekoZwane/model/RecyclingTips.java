package com.enviro.assessment.grad001.NkululekoZwane.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class RecyclingTips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tip is mandatory")
    @Size(max = 500, message = "Tip must be at most 500 characters")
    private String tip;

    public RecyclingTips() {}


    public RecyclingTips(String tip) {
        this.tip = tip;
    }

    public Long getId() {
        return id;
    }


    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
