package com.example.demo.user;

import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="api/v1/users")
public class UserController {
	
	private final UserService userservice;
	
	public UserController(UserService userservice) {
		this.userservice=userservice;
	}
	
	@GetMapping("/all")
	public String getall(){
		return userservice.getusers().toString();
	}
	
	@PostMapping
	public String addUser(@RequestBody User U) {
		User saved = userservice.add(U);
		if(saved!=null) {
			return saved.toString();
		}else {
			JSONObject errorResponse = new JSONObject();
			errorResponse.put("status", 200);
			errorResponse.put("message", "failed to add module");
			return errorResponse.toString();
		}
	}
	
}
