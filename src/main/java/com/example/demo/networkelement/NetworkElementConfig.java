package com.example.demo.networkelement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class NetworkElementConfig {
	
	//name: router-1
	//device: router
	//ipv4: 192.0.8.1
	//mac: 00-B0-D0-01-26
	private static String network_family[] = {"Broadband cable","Wireless dongle", "Modem", "Router", "Ethernet Cable", "Wireless access point", "Opical Network terminal", "Splitter", "Fiber Optic cable","Network switch"};
	
	@Bean("networkelement")
	CommandLineRunner commandLineRunner(
			NetworkElementRepository repo) {
		return args -> {
			List<NetworkElement> elements = new ArrayList<NetworkElement>();
			for(int i=0;i<network_family.length;i++) {
				for(int j=0;j<3;j++) {
					NetworkElement N = new NetworkElement();
					N.setDeviceFamily(network_family[i]);
					N.setName(network_family[i]+j);
					N.setIpv4Address("192.0."+Integer.toString(i+1)+"."+Integer.toString(20+j));
					N.setMacAddress("00-B0-D0-"+Integer.toString(40+i)+"-"+Integer.toString(10+j));
					N.setModifiedOn(System.currentTimeMillis()/1000);
					elements.add(N);
				}
			}
			repo.saveAll(elements);
		};
	}

}
