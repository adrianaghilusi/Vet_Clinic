package com.VetClinic.Vet.Clinic.config;

import ch.qos.logback.core.joran.event.StartEvent;
import com.VetClinic.Vet.Clinic.model.*;
import com.VetClinic.Vet.Clinic.repository.*;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

@Component
public class Setup implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    MicrochipRepository microchipRepository;

    @Autowired
    HealthIssueRepository healthIssueRepository;

    @Autowired
    MedicationRepository medicationRepository;

    @Autowired
    PetRepository petRepository;
    private void loadData() {
        Doctor doctor1 = new Doctor("Joe The Doctor", "Doctor Lane 13", "09043");
        Doctor doctor2 = new Doctor("Taylor Gold", "Doctor Lane 13", "06756");
        Doctor doctor3 = new Doctor("Hannah Martin", "Doctor Lane 13", "567353");
        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);
        doctorRepository.save(doctor3);
        Owner owner1 = new Owner("Taylor Higgs", "Wisteria Lane", "054435");
        Owner owner2 = new Owner("Kyle Higgs", "High Lane", "0544557635");
        Owner owner3 = new Owner("Taylor Bong", "Jump Lane", "8967");
        ownerRepository.save(owner1);
        ownerRepository.save(owner2);
        ownerRepository.save(owner3);
        Microchip microchip1 = new Microchip("Wisteria Lane", owner1);
        Microchip microchip2 = new Microchip("High Lane", owner2);
        Microchip microchip3 = new Microchip("Jump Lane", owner3);
        microchipRepository.save(microchip1);
        microchipRepository.save(microchip2);
        microchipRepository.save(microchip3);
        Medication medication1 = new Medication("twice daily", "ibuprofen");
        Medication medication2 = new Medication("once every 3 months", "anti-flea medicine");
        Medication medication3 = new Medication("twice daily", "biocalm");
        Medication medication4 = new Medication("before every meal", "maropitant");
        Medication medication5 = new Medication("once daily", "methimazole");
        medicationRepository.save(medication1);
        medicationRepository.save(medication2);
        medicationRepository.save(medication3);
        medicationRepository.save(medication4);
        medicationRepository.save(medication5);
        List<Medication> medicationList1 = new ArrayList<>();
        List<Medication> medicationList2 = new ArrayList<>();
        List<Medication> medicationList3 = new ArrayList<>();
        medicationList1.add(medication1);
        medicationList1.add(medication4);
        medicationList2.add(medication2);
        medicationList2.add(medication3);
        medicationList3.add(medication5);
        HealthIssue healthIssue1 = new HealthIssue(Diagnosed.Y, "Common cold", "antibiotics",doctor1);
        HealthIssue healthIssue2 = new HealthIssue(Diagnosed.Y, "Flea allergy", "anti-parasitic treatment; cone",doctor2);
        HealthIssue healthIssue3 = new HealthIssue(Diagnosed.N, "Suspicions of hypothyroidism", "keep under constant observation",doctor1);
        healthIssue1.setMedicationList(medicationList1);
        healthIssue2.setMedicationList(medicationList2);
        healthIssue3.setMedicationList(medicationList3);
        healthIssueRepository.save(healthIssue1);
        healthIssueRepository.save(healthIssue2);
        healthIssueRepository.save(healthIssue3);
        Pet pet1 = new Pet("Isabella", microchip1,1,AnimalType.Rodent,healthIssue1,"Dwarf Hamster");
        Pet pet2 = new Pet("Cory", microchip2,12,AnimalType.Cat,healthIssue2,"Persian");
        Pet pet3 = new Pet("Joy", microchip3,9,AnimalType.Dog,healthIssue3,"Cocker Spaniel");
        petRepository.save(pet1);
        petRepository.save(pet2);
        petRepository.save(pet3);


    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadData();
    }
}
