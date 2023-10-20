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
			
			
			
			
			Incident I3 = new Incident();
			NetworkElement N3 = new NetworkElement();
			N3.setId(8);
			I3.setNetworkElement(N3);
			I3.setName("Trouble Installing");
			Issue Iss3 = new Issue();
			Iss3.setId(9);
			I3.setIssue(Iss3);
			I3.setPriority(1);
			I3.setSeverity(2);
			I3.setState("Open");
			AssignmentGroup G3 = new AssignmentGroup();
			G3.setId(17);
			I3.setAssignmentGroup(G3);
			User U3 = new User();
			U3.setId(4);
			I3.setRaisedBy(U3);
			I3.setModifiedOn(System.currentTimeMillis()/1000);
			

			Incident I4 = new Incident();
			NetworkElement N4 = new NetworkElement();
			N4.setId(19);
			I4.setNetworkElement(N4);
			I4.setName("Over heating");
			Issue Iss4 = new Issue();
			Iss4.setId(20);
			I4.setIssue(Iss4);
			I4.setPriority(3);
			I4.setSeverity(2);
			I4.setState("Open");
			AssignmentGroup G4 = new AssignmentGroup();
			G4.setId(39);
			I4.setAssignmentGroup(G4);
			User U4 = new User();
			U4.setId(9);
			I4.setRaisedBy(U4);
			I4.setModifiedOn(System.currentTimeMillis()/1000);
			
			Incident I5 = new Incident();
			NetworkElement N5 = new NetworkElement();
			N5.setId(11);
			I5.setNetworkElement(N5);
			I5.setName("Dial-out issue");
			Issue Iss5 = new Issue();
			Iss5.setId(11);
			I5.setIssue(Iss5);
			I5.setPriority(1);
			I5.setSeverity(3);
			I5.setState("Open");
			AssignmentGroup G5 = new AssignmentGroup();
			G5.setId(21);
			I5.setAssignmentGroup(G5);
			User U5 = new User();
			U5.setId(12);
			I5.setRaisedBy(U5);
			I5.setModifiedOn(System.currentTimeMillis()/1000);
			
			repo.saveAll(List.of(
					I1,I2,I3,I4,I5
					));
		};
	}
}
