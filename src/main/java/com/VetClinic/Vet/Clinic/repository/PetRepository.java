package com.VetClinic.Vet.Clinic.repository;

import com.VetClinic.Vet.Clinic.model.Owner;
import com.VetClinic.Vet.Clinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
}
