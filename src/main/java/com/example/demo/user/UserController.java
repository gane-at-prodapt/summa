package com.example.demo.user;

import java.util.List;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.criteria.Path;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="api/v1/users")
public class UserController {
	
	private final UserService userservice;
	
	public UserController(UserService userservice) {
		this.userservice=userservice;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getall(){
		List<User> all = userservice.getusers();
		if(all!=null && all.size()!=0) {
			return ResponseEntity.ok(all);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping(value="/role/{id}")
		public ResponseEntity<List<User>> getusers(@PathVariable("id") int id )
		{
			List<User> users= userservice.finduser(id);
			if( users!= null)
			{
				if(users.size()!= 0)
				{
					return ResponseEntity.ok(users);
				}
				else
				{
					return ResponseEntity.noContent().build();
				}
			
			}
			else
			{
				return ResponseEntity.notFound().build();
			}
		}
		
	
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User U) {
		User saved = userservice.add(U);
		if(saved!=null) {
			return ResponseEntity.ok(saved);
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User U )
	{
		User update= userservice.updateuser(U);
		if(update!=null)
		{
			return ResponseEntity.ok(update);
		}
		else
		{
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteUser(@RequestBody User U)
	{
		boolean status= userservice.deleteuser(U);
		if(status)
		{
			return ResponseEntity.ok().build();
		}
		else
		{
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
}
