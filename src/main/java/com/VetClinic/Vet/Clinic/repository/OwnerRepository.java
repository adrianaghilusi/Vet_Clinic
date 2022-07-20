package com.VetClinic.Vet.Clinic.repository;

import com.VetClinic.Vet.Clinic.model.HealthIssue;
import com.VetClinic.Vet.Clinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
