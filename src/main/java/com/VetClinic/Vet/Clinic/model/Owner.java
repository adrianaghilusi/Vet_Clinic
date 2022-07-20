package com.VetClinic.Vet.Clinic.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
}
