package com.example.demo.module;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="api/v1/module")
public class ModuleController {
	
	private final ModuleService moduleservice;
	
	public ModuleController(ModuleService moduleservice){
		this.moduleservice = moduleservice;
	}

	@PostMapping
	public ResponseEntity<Module> addModule(@RequestBody Module M){	
		Module saved = moduleservice.addModule(M);
		if(saved!=null) {
			return ResponseEntity.ok(saved);
		}else {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@PutMapping
	public ResponseEntity<Module> updateModule(@RequestBody Module M){	
		Module updated = moduleservice.addModule(M);
		if(updated!=null) {
			return ResponseEntity.ok(updated);
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteModule(@RequestBody Module M){
		boolean status = moduleservice.deleteModule(M);
		if(status) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	

}
