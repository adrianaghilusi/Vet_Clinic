package com.VetClinic.Vet.Clinic.controller;

import com.VetClinic.Vet.Clinic.model.HealthIssue;
import com.VetClinic.Vet.Clinic.model.Owner;
import com.VetClinic.Vet.Clinic.service.HealthIssueService;
import com.VetClinic.Vet.Clinic.service.OwnerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public List<Owner> getAllOwners(){
        return ownerService.getAllOwners();
    }
    @PostMapping("/createOwner")
    public Owner createOwner(@RequestBody Owner owner){
        return ownerService.createOwner(owner);
    }
}

