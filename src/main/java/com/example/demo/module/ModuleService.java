package com.example.demo.module;

import java.util.List;

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
	
	public Module updateModule(Module M) {
		return modulerepository.save(M);
	}
	
	public List<Module> getAll() {
		return modulerepository.findAll();
	}
	
	public boolean deleteModule(Module M) {
		try {
			modulerepository.delete(M);
			return true;
		}catch(Exception E) {
			return false;
		}
	}
	

}
