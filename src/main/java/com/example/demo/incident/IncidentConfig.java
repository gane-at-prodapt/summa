package com.example.demo.incident;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.assignmentgroup.AssignmentGroup;
import com.example.demo.issue.Issue;
import com.example.demo.networkelement.NetworkElement;
import com.example.demo.user.User;

@Configuration
public class IncidentConfig {

	@Bean
	CommandLineRunner commandLineRunner(IncidentRepository repo) {
		return args ->{
			Incident I1 = new Incident();
			NetworkElement N1 = new NetworkElement();
			N1.setId(4);
			I1.setNetworkElement(N1);
			I1.setName("Signal attenuation error");
			Issue Iss = new Issue();
			Iss.setId(4);
			I1.setIssue(Iss);
			I1.setPriority(2);
			I1.setSeverity(2);
			I1.setState("Open");
			AssignmentGroup G = new AssignmentGroup();
			G.setId(7);
			I1.setAssignmentGroup(G);
			User U = new User();
			U.setId(1);
			I1.setRaisedBy(U);
			I1.setModifiedOn(System.currentTimeMillis()/1000);
			
			Incident I2 = new Incident();
			NetworkElement N2 = new NetworkElement();
			N2.setId(6);
			I2.setNetworkElement(N2);
			I2.setName("Signal attenuation error");
			Issue Iss2 = new Issue();
			Iss2.setId(6);
			I2.setIssue(Iss2);
			I2.setPriority(2);
			I2.setSeverity(2);
			I2.setState("Open");
			AssignmentGroup G2 = new AssignmentGroup();
			G2.setId(12);
			I2.setAssignmentGroup(G2);
			User U2 = new User();
			U2.setId(6);
			I2.setRaisedBy(U2);
			I2.setModifiedOn(System.currentTimeMillis()/1000);
			
			repo.saveAll(List.of(
					I1,I2
					));
		};
	}
}
