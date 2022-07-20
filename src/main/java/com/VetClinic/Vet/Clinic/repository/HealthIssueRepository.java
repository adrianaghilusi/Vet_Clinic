package com.VetClinic.Vet.Clinic.repository;

import com.VetClinic.Vet.Clinic.model.Doctor;
import com.VetClinic.Vet.Clinic.model.HealthIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthIssueRepository extends JpaRepository<HealthIssue,Long> {
}
