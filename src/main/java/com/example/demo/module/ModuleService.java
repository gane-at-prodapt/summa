package com.example.demo.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {
	
	private ModuleRepository modulerepository;
	
	@Autowired
	public ModuleService(ModuleRepository modulerepository) {
		this.modulerepository = modulerepository;
	}
	
	public Module addModule(Module M){
		return modulerepository.save(M);
	}
	

}
