package com.VetClinic.Vet.Clinic.service;

import com.VetClinic.Vet.Clinic.model.Doctor;
import com.VetClinic.Vet.Clinic.model.HealthIssue;
import com.VetClinic.Vet.Clinic.model.Medication;
import com.VetClinic.Vet.Clinic.repository.DoctorRepository;
import com.VetClinic.Vet.Clinic.repository.HealthIssueRepository;
import com.VetClinic.Vet.Clinic.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HealthIssueService {
    HealthIssueRepository healthIssueRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    MedicationRepository medicationRepository;
    public HealthIssueService(HealthIssueRepository healthIssueRepository){
        this.healthIssueRepository = healthIssueRepository;
    }
    public List<HealthIssue> getAllHealthIssues(){
        return healthIssueRepository.findAll();
    }

    public HealthIssue addIssue(HealthIssue healthIssue) {
        if(healthIssue.getDoctor() == null){
            assignDoctor(healthIssue);
        }
        return healthIssueRepository.save(healthIssue);
    }

    private void assignDoctor(HealthIssue healthIssue) {
        Doctor doctor = getLeastBusyDoctor();
        healthIssue.setDoctor(doctor);
    }

    public Doctor getLeastBusyDoctor() {
        Map<Doctor,Integer> patientsPerDoctor = new HashMap<>();
        for(var issue: healthIssueRepository.findAll()){

            if(patientsPerDoctor.containsKey(issue.getDoctor())){
                patientsPerDoctor.put(issue.getDoctor(),patientsPerDoctor.get(issue.getDoctor())+1);
            }
            else
                patientsPerDoctor.putIfAbsent(issue.getDoctor(),1);
        }
        for(var doc: doctorRepository.findAll()){
            patientsPerDoctor.putIfAbsent(doc,0);
        }
        Integer min = Collections.min(patientsPerDoctor.values());
        return patientsPerDoctor.entrySet().stream().filter(e->min.equals(e.getValue())).map(Map.Entry::getKey).collect(Collectors.toList()).get(0);
    }

    public HealthIssue prescribeMedicationForHealthIssue(String medicationName, Long id) {
        var med = medicationRepository.findMedicationByName(medicationName);
        if(med == null){
            Medication newMedication = new Medication(medicationName);
            medicationRepository.save(newMedication);
           healthIssueRepository.findById(id).get().getMedicationList().add(newMedication);
        }
        else
            healthIssueRepository.findById(id).get().getMedicationList().add(med);

        return healthIssueRepository.findById(id).get();
    }
}
