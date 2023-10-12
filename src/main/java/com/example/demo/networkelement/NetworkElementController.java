package com.example.demo.networkelement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="api/v1/networkelement")

public class NetworkElementController {
	private NetworkElementService networkelementtservice;
	
	
	
	public NetworkElementController(NetworkElementService networkelementtservice)
	{
		this.networkelementtservice=networkelementtservice;
	}
	
	@PostMapping
	public ResponseEntity<NetworkElement> add(@RequestBody NetworkElement N ) {
		NetworkElement saved = networkelementtservice.add(N);
		if( saved!= null)
		{
			 return ResponseEntity.ok(N);
		}
		else
		{
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<NetworkElement>> getall()
	{
		List<NetworkElement> Elements= networkelementtservice.getall();
		if(Elements!=null) {
			if(Elements.size()!=0) {
				return ResponseEntity.ok(Elements);
				
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

	

}
