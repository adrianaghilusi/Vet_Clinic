package com.VetClinic.Vet.Clinic.repository;

import com.VetClinic.Vet.Clinic.model.HealthIssue;
import com.VetClinic.Vet.Clinic.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Long> {
    @Query("select m from Medication m where m.name like :name")
    Medication findMedicationByName(String name);
}
