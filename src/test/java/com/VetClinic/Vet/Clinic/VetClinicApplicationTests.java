package com.VetClinic.Vet.Clinic;

import com.VetClinic.Vet.Clinic.model.Doctor;
import com.VetClinic.Vet.Clinic.model.HealthIssue;
import com.VetClinic.Vet.Clinic.repository.HealthIssueRepository;
import com.VetClinic.Vet.Clinic.service.HealthIssueService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class VetClinicApplicationTests {
	@Mock
	private HealthIssueRepository healthIssueRepository;
	@InjectMocks
	private HealthIssueService healthIssueService;

	@Test
	void contextLoads() {
	}
	@Test
	public void testAssignLeastBusyDoctor(){
		List<HealthIssue> healthIssueList = new ArrayList<>();
		Doctor doctor1 = new Doctor();
		Doctor doctor2 = new Doctor();
		HealthIssue healthIssue1 = new HealthIssue();
		healthIssue1.setDoctor(doctor1);
		HealthIssue healthIssue2 = new HealthIssue();
		healthIssue2.setDoctor(doctor1);
		HealthIssue healthIssue3 = new HealthIssue();
		healthIssue3.setDoctor(doctor2);
		healthIssueList.add(healthIssue1);
		healthIssueList.add(healthIssue2);
		healthIssueList.add(healthIssue3);
		when(healthIssueRepository.findAll()).thenReturn(healthIssueList);
		Assertions.assertEquals(healthIssueService.getLeastBusyDoctor(), doctor2);
	}
	@Test
	public void testAssignLeastBusyDoctorUnassignedDoctor(){
		List<HealthIssue> healthIssueList = new ArrayList<>();
		Doctor doctor1 = new Doctor();
		Doctor doctor2 = new Doctor();
		HealthIssue healthIssue1 = new HealthIssue();
		healthIssue1.setDoctor(doctor1);
		HealthIssue healthIssue2 = new HealthIssue();
		healthIssue2.setDoctor(doctor1);
		HealthIssue healthIssue3 = new HealthIssue();
		healthIssue3.setDoctor(doctor1);
		healthIssueList.add(healthIssue1);
		healthIssueList.add(healthIssue2);
		healthIssueList.add(healthIssue3);
		when(healthIssueRepository.findAll()).thenReturn(healthIssueList);
		Assertions.assertEquals(healthIssueService.getLeastBusyDoctor(), doctor2);
	}

}
