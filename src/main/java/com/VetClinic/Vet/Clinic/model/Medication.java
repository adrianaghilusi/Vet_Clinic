package com.VetClinic.Vet.Clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private HealthIssue healthIssue;
}
