package com.VetClinic.Vet.Clinic.controller;

import com.VetClinic.Vet.Clinic.model.Microchip;
import com.VetClinic.Vet.Clinic.model.Owner;
import com.VetClinic.Vet.Clinic.service.MicrochipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MicrochipController {
    private final MicrochipService microchipService;

    public MicrochipController(MicrochipService microchipService) {
        this.microchipService = microchipService;
    }


    @GetMapping("/microchips")
    public List<Microchip> getAllMicrochips(){
        return microchipService.getAllMicrochips();
    }
}
