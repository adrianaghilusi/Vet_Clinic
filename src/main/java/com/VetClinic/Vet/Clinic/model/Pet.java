package com.VetClinic.Vet.Clinic.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String petName;
    @OneToOne
    @JoinColumn(name = "microchip_id")
    private Microchip microchip;
    private Integer age;
    @Column(columnDefinition = "ENUM('Unassigned','Cat','Dog','Reptile','Rodent')")
    @Enumerated(EnumType.STRING)
    private AnimalType petType;
    private String diet;
    @OneToOne
    @JoinColumn(name = "health_issue_id")
    private HealthIssue healthIssue;
    private String breed;

    public Pet(String petName, Microchip microchip, Integer age, AnimalType petType, HealthIssue healthIssue, String breed) {
        this.petName = petName;
        this.microchip = microchip;
        this.age = age;
        this.petType = petType;
        this.diet = diet;
        this.healthIssue = healthIssue;
        this.breed = breed;
    }

    public Pet() {

    }
}
