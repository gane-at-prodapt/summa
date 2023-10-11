package com.example.demo.assignmentgroup;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="api/v1/assignmentgroup")
public class AssignmentGroupController {
	
	private AssignmentGroupService assignmentgroupservice;
	public AssignmentGroupController(AssignmentGroupService assignmentgroupservice) {
		this.assignmentgroupservice=assignmentgroupservice;
	}
	
	@PostMapping
	public ResponseEntity<AssignmentGroup> add(@RequestBody AssignmentGroup A){
		AssignmentGroup saved = assignmentgroupservice.add(A);
		if(saved!=null) {
			return ResponseEntity.ok(saved);
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	@GetMapping(value="/all")
	public ResponseEntity<List<AssignmentGroup>> get(){
		List<AssignmentGroup> saved = assignmentgroupservice.getgroups();
		if(saved!=null && saved.size()!=0) {
			return ResponseEntity.ok(saved);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping(value="/issue/{id}")
	public ResponseEntity<List<AssignmentGroup>> getByIssue(@PathVariable("id") int id){
		List<AssignmentGroup> saved = assignmentgroupservice.getGroupsByIssue(id);
		if(saved!=null && saved.size()!=0) {
			return ResponseEntity.ok(saved);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestBody AssignmentGroup A){
		boolean status = assignmentgroupservice.deleteGroup(A);
		if(status) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
