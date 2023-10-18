package com.example.demo.groupmembers;

import java.security.NoSuchAlgorithmException;
import java.util.List;

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



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="api/v1/groupmembers")
public class GroupMembersController {
	
	private GroupMembersService groupmemberservice;
	
	public GroupMembersController(GroupMembersService groupmembersservice) {
		this.groupmemberservice=groupmembersservice;
	}
	
	@PostMapping
	public ResponseEntity<GroupMembers> addAuth(@RequestBody GroupMembers G) {	
		
		GroupMembers saved = groupmemberservice.add(G);
		if(saved!=null) {
			return ResponseEntity.ok(saved);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping(value="/member/{id}")
	public ResponseEntity<List<GroupMembers>> getGroups(@PathVariable("id") int id){
		List<GroupMembers> details = groupmemberservice.getGroupsByMember(id);
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
	public ResponseEntity<List<GroupMembers>> getMembers(@PathVariable("id") int id){
		List<GroupMembers> details = groupmemberservice.getMembersByGroup(id);
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
	
	@DeleteMapping
	public ResponseEntity<String> deleteMemberFromGroup(@RequestBody GroupMembers G){
		boolean status = groupmemberservice.removeMemberFromGroup(G);
		if(status) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
