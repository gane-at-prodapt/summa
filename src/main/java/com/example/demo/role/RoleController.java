package com.example.demo.role;

import java.util.List;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="api/v1/role")
public class RoleController {
	
	private RoleService roleservice;
	
	public RoleController(RoleService roleservice) {
		this.roleservice=roleservice;
	}
	
	@PostMapping()
	public ResponseEntity<Role> add(@RequestBody Role R) {
		Role savedRole = roleservice.addRole(R);
		if(savedRole!=null) {
			return ResponseEntity.ok(savedRole);
		}else {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@PutMapping
	public ResponseEntity<Role> update(@RequestBody Role R)
	{
		Role updateRole= roleservice.updateRole(R);
		if(updateRole!=null)
		{
			return ResponseEntity.ok(updateRole);
		}
		else
		{
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
	
	
	@GetMapping()
	public ResponseEntity<List<Role>> getAll()
	{
		List<Role> details= roleservice.getallRole();
		if( details!= null)
		{
			if(details.size()!=0)
			{
				return ResponseEntity.ok(details);
			}
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		
	}
}
	
