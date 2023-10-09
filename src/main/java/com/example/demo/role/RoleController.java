package com.example.demo.role;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="api/v1/role")
public class RoleController {
	
	private final RoleService roleservice;
	
	public RoleController(RoleService roleservice) {
		this.roleservice=roleservice;
	}
	
	@PostMapping()
	public String add(@RequestBody Role R) {
		Role savedRole = roleservice.addRole(R);
		if(savedRole!=null) {
			return R.toString();
		}else {
			JSONObject errorResponse = new JSONObject();
			errorResponse.put("status", 200);
			errorResponse.put("message", "failed to add module");
			return errorResponse.toString();
		}
		
	}
}
