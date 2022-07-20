package com.VetClinic.Vet.Clinic.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="microchip")
public class Microchip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private String address;
    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;
}
