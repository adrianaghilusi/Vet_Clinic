package com.VetClinic.Vet.Clinic.controller;

import com.VetClinic.Vet.Clinic.model.HealthIssue;
import com.VetClinic.Vet.Clinic.service.HealthIssueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
