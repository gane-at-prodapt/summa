package com.example.demo.auth;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="api/v1/auth")
public class AuthController {
	
	private final AuthService authservice;
	
	public AuthController(AuthService authservice) {
		this.authservice = authservice;
	}
	
	
	@PostMapping(value="/login")
	public String login(@RequestBody String jsonstring){	
		JSONObject authJson = new JSONObject(jsonstring);
		Auth details = authservice.login(authJson.getString("token"));
		if(details!=null) {
			return details.toString();
		}else {
			JSONObject errorResponse = new JSONObject();
			errorResponse.put("status", 200);
			errorResponse.put("message", "authentication failed, invalid email or password");
			return errorResponse.toString();
		}
	}
	@PostMapping(value="/add")
	public String addAuth(@RequestBody Auth A){	
		Auth details = authservice.add(A);
		if(details!=null) {
			return details.toString();
		}else {
			JSONObject errorResponse = new JSONObject();
			errorResponse.put("status", 200);
			errorResponse.put("message", "authentication failed, invalid email or password");
			return errorResponse.toString();
		}
	}
	
	
	

}
