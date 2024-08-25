package com.example.project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

@Entity
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    @Column(length = 1000)
    private String description;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Company is required")
    private String company;

    private String salaryRange;

    @ElementCollection
    private List<String> requiredSkills;

    @Future(message = "Application deadline must be in the future")
    @Temporal(TemporalType.DATE)
    private Date applicationDeadline;

    // Getters and setters
}