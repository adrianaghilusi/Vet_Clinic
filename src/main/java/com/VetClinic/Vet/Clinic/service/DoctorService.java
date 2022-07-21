package com.VetClinic.Vet.Clinic.service;

import com.VetClinic.Vet.Clinic.model.Doctor;
import com.VetClinic.Vet.Clinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
