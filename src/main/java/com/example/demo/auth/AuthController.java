package com.example.demo.auth;

import java.security.NoSuchAlgorithmException;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.encryption.Encryption;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="api/v1/auth")
public class AuthController {
	
	private final AuthService authservice;
	
	public AuthController(AuthService authservice) {
		this.authservice = authservice;
	}
	
	
	@PostMapping(value="/login")
	public ResponseEntity<Auth> login(@RequestBody String jsonstring) throws NoSuchAlgorithmException{	
		JSONObject authJson = new JSONObject(jsonstring);
		String token = authJson.getString("token");
		String email = authJson.getString("email");
		String digest = Encryption.encrypt(token+email);
		Auth details = authservice.login(digest);
		if(details!=null) {
			return ResponseEntity.ok(details);
		}else {
			JSONObject errorResponse = new JSONObject();
			errorResponse.put("status", 200);
			errorResponse.put("message", "authentication failed, invalid email or password");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PostMapping(value="/add")
	public ResponseEntity<Auth> addAuth(@RequestBody Auth A) throws NoSuchAlgorithmException{	
		A.setAuthToken(Encryption.encrypt(A.getAuthToken()+A.getUser().getEmail()));
		Auth details = authservice.add(A);
		if(details!=null) {
			return ResponseEntity.ok(details);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Auth> changeAuth(@RequestBody Auth A) throws NoSuchAlgorithmException{
		A.setAuthToken(Encryption.encrypt(A.getAuthToken()+A.getUser().getEmail()));
		Auth details = authservice.add(A);
		if(details!=null) {
			return ResponseEntity.ok(details);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestBody Auth A){
		boolean status = authservice.delete(A);
		if(status) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
	

}
