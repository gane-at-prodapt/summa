package com.example.demo.access;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	public String addAccess(@RequestBody Access A) {
		Access saved = accessservice.add(A);
		if(saved!=null) {
			return saved.toString();
		}else {
			JSONObject errorResponse = new JSONObject();
			errorResponse.put("status", 200);
			errorResponse.put("message", "failed to add access");
			return errorResponse.toString();
		}
	}
	
	@PostMapping(value="/bulk")
	public String addAccessBulk(@RequestBody List<Access> accessList) {
		List<Access> saved = accessservice.addBulk(accessList);
		if(saved!=null) {
			return saved.toString();
		}else {
			JSONObject errorResponse = new JSONObject();
			errorResponse.put("status", 200);
			errorResponse.put("message", "failed to add access");
			return errorResponse.toString();
		}
	}
	
}
