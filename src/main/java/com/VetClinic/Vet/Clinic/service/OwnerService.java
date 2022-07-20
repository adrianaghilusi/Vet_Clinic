package com.VetClinic.Vet.Clinic.service;

import com.VetClinic.Vet.Clinic.model.HealthIssue;
import com.VetClinic.Vet.Clinic.model.Owner;
import com.VetClinic.Vet.Clinic.repository.HealthIssueRepository;
import com.VetClinic.Vet.Clinic.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }
}
