package com.VetClinic.Vet.Clinic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

enum AnimalType {
    Unassigned,
    Cat,
    Dog,
    Reptile,
    Rodent
}

@Entity
@Data
@Table(name="pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String petName;
    @OneToOne
    @JoinColumn(name = "id")
    private Microchip microchip;
    private Integer age;
    private AnimalType petType;
    private String diet;
    @OneToOne
    @JoinColumn(name = "health_issue_id")
    private HealthIssue healthIssue;
    private String breed;
}
