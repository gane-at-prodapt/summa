package com.example.demo.incident;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="api/v1/incident")
public class IncidentController {
	private IncidentService incidentservice;
	
	public IncidentController(IncidentService ins) {
		this.incidentservice=ins;
	}
	
	@PostMapping
	public ResponseEntity<Incident> add(@RequestBody Incident I) {
		Incident saved = incidentservice.addIncident(I);
		if(saved!=null) {
			return ResponseEntity.ok(saved);
		}else {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@PutMapping
	public ResponseEntity<Incident> update(@RequestBody Incident I) {
		Incident updated = incidentservice.updateIncident(I);
		if(updated!=null) {
			return ResponseEntity.ok(updated);
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestBody Incident I) {
		boolean status = incidentservice.delete(I);
		if(status) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping(value="/all")
	public ResponseEntity<List<Incident>> getall(){
		List<Incident> details = incidentservice.getAll();
		if(details!=null) {
			if(details.size()!=0) {
				return ResponseEntity.ok(details);
			}else {
				return ResponseEntity.noContent().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(value="/group/{id}")
	public ResponseEntity<List<Incident>> getincidentsByGroup(@PathVariable("id") int id){
		List<Incident> details = incidentservice.getByGroup(id);
		if(details!=null) {
			if(details.size()!=0) {
				return ResponseEntity.ok(details);
			}else {
				return ResponseEntity.noContent().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(value="/member/{id}")
	public ResponseEntity<List<Incident>> getincidentsByMember(@PathVariable("id") int id){
		List<Incident> details = incidentservice.getByMember(id);
		if(details!=null) {
			if(details.size()!=0) {
				return ResponseEntity.ok(details);
			}else {
				return ResponseEntity.noContent().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(value="/member/groups/{id}")
	public ResponseEntity<List<Incident>> getincidentsByMemberGroups(@PathVariable("id") int id){
		List<Incident> details = incidentservice.getByMembergroups(id);
		if(details!=null) {
			if(details.size()!=0) {
				return ResponseEntity.ok(details);
			}else {
				return ResponseEntity.noContent().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(value="issue/{id}")
	public ResponseEntity<List<Incident>> getincidentsByIssue(@PathVariable("id") int id){
		List<Incident> details = incidentservice.getByMembergroups(id);
		if(details!=null) {
			if(details.size()!=0) {
				return ResponseEntity.ok(details);
			}else {
				return ResponseEntity.noContent().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
