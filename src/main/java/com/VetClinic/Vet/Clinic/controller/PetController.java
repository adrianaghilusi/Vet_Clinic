package com.VetClinic.Vet.Clinic.controller;

import com.VetClinic.Vet.Clinic.model.Pet;
import com.VetClinic.Vet.Clinic.service.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }
    @GetMapping("/pets")
    public List<Pet> getAllPets(){
        return petService.getAllPets();
    }


}
