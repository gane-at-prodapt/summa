package com.example.demo.issue;

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
@RequestMapping(path="api/v1/issue")
public class IssueController {
	private IssueService issueservice;
	public IssueController(IssueService issueservice) {
		this.issueservice=issueservice;
	}
	
	@PostMapping
	public ResponseEntity<Issue> add(@RequestBody Issue I) {
		Issue saved = issueservice.addIssue(I);
		if(saved!=null) {
			return ResponseEntity.ok(saved);
		}else {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@PutMapping
	public ResponseEntity<Issue> update(@RequestBody Issue I) {
		Issue saved = issueservice.updateIssue(I);
		if(saved!=null) {
			return ResponseEntity.ok(saved);
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestBody Issue I) {
		boolean status = issueservice.deleteIssue(I);
		if(status) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Issue>> getAll(){
		List<Issue> details = issueservice.getAll();
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
	
	@GetMapping(value="/network/{family}")
	public ResponseEntity<List<Issue>> getIssuesByNetworkDevice(@PathVariable("family") String family){
		List<Issue> details = issueservice.getIssueByNetworkDevice(family);
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
