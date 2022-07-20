package com.VetClinic.Vet.Clinic.service;

import com.VetClinic.Vet.Clinic.model.Doctor;
import com.VetClinic.Vet.Clinic.model.Medication;
import com.VetClinic.Vet.Clinic.repository.MedicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {
    private final MedicationRepository medicationRepository;

    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public List<Medication> getAllMedication(){
        return medicationRepository.findAll();
    }
}
