package com.VetClinic.Vet.Clinic.service;

import com.VetClinic.Vet.Clinic.model.Pet;
import com.VetClinic.Vet.Clinic.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }
}
