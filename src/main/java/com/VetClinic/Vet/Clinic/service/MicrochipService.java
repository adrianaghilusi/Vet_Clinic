package com.VetClinic.Vet.Clinic.service;

import com.VetClinic.Vet.Clinic.model.Microchip;
import com.VetClinic.Vet.Clinic.model.Owner;
import com.VetClinic.Vet.Clinic.repository.MicrochipRepository;
import com.VetClinic.Vet.Clinic.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MicrochipService {
    private final MicrochipRepository microchipRepository;

    public List<Microchip> getAllMicrochips(){
        return microchipRepository.findAll();
    }
}
