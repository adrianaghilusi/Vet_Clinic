package com.VetClinic.Vet.Clinic.controller;

import com.VetClinic.Vet.Clinic.model.Medication;
import com.VetClinic.Vet.Clinic.service.MedicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicationController {
    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }
    @GetMapping("/meds")
    public List<Medication> getAllMeds(){
        return medicationService.getAllMedication();
    }
}
