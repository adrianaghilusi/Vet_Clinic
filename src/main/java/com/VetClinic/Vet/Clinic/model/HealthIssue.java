package com.VetClinic.Vet.Clinic.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToMany(cascade = CascadeType.MERGE)
    List<Medication> medicationList;

    public HealthIssue(Diagnosed diagnosed, String name, String recommendations, Doctor doctor) {
        this.diagnosed = diagnosed;
        this.name = name;
        this.recommendations = recommendations;
        this.doctor = doctor;
    }


}
