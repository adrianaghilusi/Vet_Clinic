package com.VetClinic.Vet.Clinic.controller;

import com.VetClinic.Vet.Clinic.model.HealthIssue;
import com.VetClinic.Vet.Clinic.service.HealthIssueService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HealthIssueController {
    private final HealthIssueService healthIssueService;

    public HealthIssueController(HealthIssueService healthIssueService) {
        this.healthIssueService = healthIssueService;
    }

    @GetMapping("/issues")
   public List<HealthIssue> getAllHealthIssues(){
       return healthIssueService.getAllHealthIssues();
    }

    @PostMapping("/addIssue")
    public HealthIssue addHealthIssue(@RequestBody HealthIssue healthIssue){
        return healthIssueService.addIssue(healthIssue);
    }
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @GetMapping("/prescribeMedicationForHealthIssue/{id}/{medicationName}")
    public HealthIssue prescribeMedicationForHealthIssue(@PathVariable String medicationName, @PathVariable Long id){
        return healthIssueService.prescribeMedicationForHealthIssue(medicationName, id);

    }
}
