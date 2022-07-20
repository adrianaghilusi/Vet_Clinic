package com.VetClinic.Vet.Clinic.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String use;
    private String name;
//    @ManyToOne
//    @JoinColumn(name = "Medication_id")
//    private HealthIssue healthIssue;
}
