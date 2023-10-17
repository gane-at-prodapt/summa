package com.example.demo.incident;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.groupmembers.GroupMembers;
import com.example.demo.groupmembers.GroupMembersService;

@Service
public class IncidentService {
	private IncidentRepository incidentrepo;
	private GroupMembersService grpmemservice;
	
	@Autowired
	public IncidentService(IncidentRepository incidentRepository, GroupMembersService grpmemservice ) {
		this.incidentrepo=incidentRepository;
		this.grpmemservice= grpmemservice;
	}
	
	public Incident addIncident(Incident I) {
		return incidentrepo.save(I);
	}
	public Incident updateIncident(Incident I) {
		return incidentrepo.save(I);
	}
	public boolean delete(Incident I) {
		try {
			incidentrepo.delete(I);
			return true;
		}catch(Exception E) {
			return false;
		}
	}
	public List<Incident> getAll(){
		return incidentrepo.findAll();
	}
	public List<Incident> getByGroup(int groupId){
		return incidentrepo.findIncidentsbyGroup(groupId);
	}
	public List<Incident> getByMember(int memberId){
		return incidentrepo.findIncidentsbyMember(memberId);
	}
	public List<Incident> getByIssue(int issueId){
		return incidentrepo.findIncidentsbyIssue(issueId);
	}
	public List<Incident> getByMembergroups(int memberId){
		List<Incident> incidents = new ArrayList<Incident>();
		List<GroupMembers> groups = grpmemservice.getGroupsByMember(memberId);
		for(GroupMembers group : groups) {
			incidents.addAll(this.getByGroup(group.getGroup().getId()));
		}
		return incidents;
	}
}
