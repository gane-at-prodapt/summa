package com.example.demo.issue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class IssueConfig {

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
	private static String[][] descriptions = {
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
	
	
	@Bean("issue")
	CommandLineRunner commandLineRunner(IssueRepository repo) {
		return args->{
			List<Issue> issues = new ArrayList<Issue>();
			for(int i=0;i<network_family.length;i++) {
				for(int j=0;j<networkissues[i].length;j++) {
					Issue I = new Issue();
					I.setName(networkissues[i][j]);
					I.setNetwork_family(network_family[i]);
					I.setDescription(descriptions[i][j]+" in "+ network_family[i]);
					I.setModifiedOn(System.currentTimeMillis()/1000);
					issues.add(I);
				}
			}
			repo.saveAll(issues);
		};
	}
}
