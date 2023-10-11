package com.example.demo.access;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.role.Role;
import com.example.demo.module.Module;;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="api/v1/access")
public class AccessController {

	private final AccessService accessservice;
	
	public AccessController(AccessService accessservice) {
		this.accessservice=accessservice;
	}
	
	@PostMapping()
	public ResponseEntity<Access> addAccess(@RequestBody Access A) {
		Access saved = accessservice.add(A);
		if(saved!=null) {
			return ResponseEntity.ok(saved);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping(value="/bulk")
	public ResponseEntity<List<Access>> addAccessBulk(@RequestBody List<Access> accessList) {
		List<Access> saved = accessservice.addBulk(accessList);
		if(saved!=null) {
			return ResponseEntity.ok(saved);
		}else {			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping(value="/role/{id}")
	public ResponseEntity<List<Access>> getAccessByRole(@PathVariable("id") int id){
		List<Access> data = accessservice.getByRole(id);
		if(data!=null || data.size()!=0) {
			return ResponseEntity.ok(data);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@DeleteMapping
	public ResponseEntity<String> Delete(@RequestBody Access A) {
		boolean sts =  accessservice.delete(A);
		if(sts) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
