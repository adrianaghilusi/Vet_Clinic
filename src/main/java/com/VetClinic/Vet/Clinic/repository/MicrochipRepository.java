package com.VetClinic.Vet.Clinic.repository;

import com.VetClinic.Vet.Clinic.model.Microchip;
import com.VetClinic.Vet.Clinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicrochipRepository extends JpaRepository<Microchip,Long> {
}
