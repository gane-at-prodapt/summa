package com.example.demo.module;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String addModule(@RequestBody Module M){	
		Module saved = moduleservice.addModule(M);
		if(saved!=null) {
			return M.toString();
		}else {
			JSONObject errorResponse = new JSONObject();
			errorResponse.put("status", 200);
			errorResponse.put("message", "failed to add module");
			return errorResponse.toString();
		}
		
	}
	
	

}
