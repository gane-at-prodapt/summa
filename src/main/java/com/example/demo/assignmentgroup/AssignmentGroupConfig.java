package com.example.demo.assignmentgroup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.demo.issue.Issue;

@Configuration
public class AssignmentGroupConfig {
	
	private static String network_family[] = {
			"Broadband cable",
			"Wireless dongle",
			"Modem",
			"Router",
			"Ethernet Cable",
			"Wireless access point",
			"Opical Network terminal",
			"Splitter",
			"Fiber Optic cable",
			"Network switch"
	};
	
	private static String[][] networkissues = {
			{"Packet Loss","Reduced Data Transfer Rate","Installation error"},
			{"Signal Attenuation","Shorter range","Connectivity Issues","Delayed signal","Signal Deteriotation"},
			{"Installation error","No reponse","Dail-out issue"},
			{"Installation error","Loss of service"},
			{"Damaged cable","Loose connection","Loss of power"},
			{"Unauthorized access","Evil twin attacks","Piggybacking"},
			{"Heating issue","Installation error","Physical damage"},
			{"Drop in strength","Connector Damage"},
			{"Bending issue","Physical damage","Installation error"},
			{"Port Failure","Module failure","Improper configuration","power failure"}
	};
	
	String[] places = {"Chennai","Hyderabad"};
	@Bean("AssignmentGroup")
	CommandLineRunner commandLineRunner(AssignmentGroupRepository repo) {
		return args ->{
			int count =1;
			List<AssignmentGroup> groups = new ArrayList<AssignmentGroup>();
			for(int i=0;i<network_family.length;i++) {
				for(int j=0;j<networkissues[i].length;j++) {
					for(int k=0;k<places.length;k++) {
						AssignmentGroup G = new AssignmentGroup();
						G.setName(networkissues[i][j]+" Group-"+k+1);
						Issue I = new Issue();
						I.setId(count);
						G.setIssue(I);
						G.setDescription(networkissues[i][j]+" Group at "+places[k]);
						G.setCreatedOn(System.currentTimeMillis()/1000);
						groups.add(G);
					}
					count++;
				}
			}
			repo.saveAll(groups);
		};
	}
}
