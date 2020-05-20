package com.example.taskmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Subtask {
    @Id
    @GeneratedValue()
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return name;
    }

    public void setNaam(String naam) {
        this.name = naam;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descriptie) {
        this.description = descriptie;
    }
}
