package com.VetClinic.Vet.Clinic.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

enum Diagnosed {
    Y,
    N
}
@Entity
@Data
@Table(name = "healthissue")
public class HealthIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(columnDefinition = "ENUM('Y', 'N')")
    @Enumerated(EnumType.STRING)
    private Diagnosed diagnosed;
    private String name;
    private String recommendations;
    @OneToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    Doctor doctor;
    @OneToMany(cascade = CascadeType.ALL)
    List<Medication> medicationList;
}
