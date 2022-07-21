package com.VetClinic.Vet.Clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String prescription;
    private String name;
    @ManyToOne
    @JsonIgnore
    //@JoinColumn(name = "id", insertable = false, updatable = false)
    private HealthIssue healthIssue;

    public Medication(String prescription, String name) {
        this.prescription = prescription;
        this.name = name;
    }

    public Medication(String medicationName) {
        this.name = medicationName;
    }
}
