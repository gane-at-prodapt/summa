package com.example.demo.module;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModuleConfig {
	
	private static String modules[] = {"Network", "Component", "Incident", "Group","Issue","Role","User", "Module"};
	
	@Bean
	CommandLineRunner commandlinerunner(
			ModuleRepository repo) {
		return args -> {
			List<Module> moduleElement= new ArrayList<Module>();
			for( int i=0; i< modules.length; i++)
			{
				Module M= new Module();
				M.setName(modules[i]);
				M.setCreatedOn(System.currentTimeMillis()/1000);
				moduleElement.add(M);
			}
			repo.saveAll(moduleElement);
		};
	}
	
}
