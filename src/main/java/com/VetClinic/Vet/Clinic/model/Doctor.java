package com.VetClinic.Vet.Clinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String address;
    @Column(name = "Phone_Number")
    private String phoneNumber;

    public Doctor(String name, String address, String phoneNumber){
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
    }


}
