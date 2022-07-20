package com.VetClinic.Vet.Clinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="microchip")
public class Microchip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private String address;
    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    public Microchip(String address, Owner owner) {
        this.address = address;
        this.owner = owner;
    }


}
