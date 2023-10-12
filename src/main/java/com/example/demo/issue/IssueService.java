package com.example.demo.issue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {
	private IssueRepository issuerepo;
	
	@Autowired
	public IssueService(IssueRepository issuerepo) {
		this.issuerepo=issuerepo;
	}
	
	public Issue addIssue(Issue I) {
		return issuerepo.save(I);
	}
	public Issue updateIssue(Issue I) {
		return issuerepo.save(I);
	}
	public List<Issue> getAll(){
		return issuerepo.findAll();
	}
	public List<Issue> getIssueByNetworkDevice(String newtwork_family){
		return issuerepo.findIssuesByNetworkDevice(newtwork_family);
	}
	public boolean deleteIssue(Issue I){
		try {
			issuerepo.save(I);
			return true;
		}catch(Exception E) {
			return false;
		}
	}
	
}
