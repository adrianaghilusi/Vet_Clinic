package com.VetClinic.Vet.Clinic.service;

import com.VetClinic.Vet.Clinic.model.HealthIssue;
import com.VetClinic.Vet.Clinic.repository.HealthIssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthIssueService {
    HealthIssueRepository healthIssueRepository;
    public HealthIssueService(HealthIssueRepository healthIssueRepository){
        this.healthIssueRepository = healthIssueRepository;
    }
    public List<HealthIssue> getAllHealthIssues(){
        return healthIssueRepository.findAll();
    }
}
