package com.example.demo.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleConfig {
	
	private static String roles[]= {"Super Admin", "Network Admin","Network Engineer","Support Analyst","Observer"};
	
	@Bean
	CommandLineRunner commandLineRunner(
	RoleRepository repo	){
		return args -> {
			List<Role> roleElements= new ArrayList<Role>();
			for(int i=0; i< roles.length; i++)
			{
				Role R= new Role();
				R.setName(roles[i]);
				R.setCreatedOn(System.currentTimeMillis()/1000);
				roleElements.add(R);
			}
			repo.saveAll(roleElements);
		};
	}

}
