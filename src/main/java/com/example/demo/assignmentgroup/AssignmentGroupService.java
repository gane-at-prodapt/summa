package com.example.demo.assignmentgroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentGroupService {
	private AssignmentGroupRepository assignmentgrouprepo;
	@Autowired
	public AssignmentGroupService(AssignmentGroupRepository assignmentgrouprepo) {
		this.assignmentgrouprepo=assignmentgrouprepo;
	}
	
	public AssignmentGroup add(AssignmentGroup A) {
		return assignmentgrouprepo.save(A);
	}
	public List<AssignmentGroup> getgroups() {
		return assignmentgrouprepo.findAll();
	}
	public List<AssignmentGroup> getGroupsByIssue(int IssueId) {
		return assignmentgrouprepo.findByIssue(IssueId);
	}
	public boolean deleteGroup(AssignmentGroup G) {
		try{
			assignmentgrouprepo.delete(G);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
