package com.example.demo.incident;

import com.example.demo.assignmentgroup.AssignmentGroup;
import com.example.demo.issue.Issue;
import com.example.demo.networkelement.NetworkElement;
import com.example.demo.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Incident {
	@Id
	@SequenceGenerator(
			name="incident_sequence",
			sequenceName="user_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "incident_sequence"
	)
	private int id;
	@Column(nullable=false)
	private String name;
	@ManyToOne
	@JoinColumn(name = "network_element_Id", referencedColumnName = "id",nullable=false)
	private NetworkElement networkElement;
	@ManyToOne
	@JoinColumn(name = "issue_Id", referencedColumnName = "id",nullable=false)
	private Issue issue;
	@Column(nullable=false)
	private int severity;
	@Column(nullable=false)
	private int priority;
	@Column(nullable=false)
	private String resolution_comment;
	@Column(nullable=false)
	private String state;
	@ManyToOne
	@JoinColumn(name = "assignementGroup_Id", referencedColumnName = "id",nullable=false)
	private AssignmentGroup assignmentGroup;
	@ManyToOne
	@JoinColumn(name = "assignedTo_Id", referencedColumnName = "id",nullable=false)
	private User assignedTo;
	@ManyToOne
	@JoinColumn(name = "raisedBy_Id", referencedColumnName = "id",nullable=false)
	private User raisedBy;
	@Column(nullable=false)
	private long modifiedOn;
	
	public AssignmentGroup getAssignmentGroup() {
		return assignmentGroup;
	}
	public void setAssignmentGroup(AssignmentGroup assignmentGroup) {
		this.assignmentGroup = assignmentGroup;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public NetworkElement getNetworkElement() {
		return networkElement;
	}
	public void setNetworkElement(NetworkElement networkElement) {
		this.networkElement = networkElement;
	}
	public Issue getIssue() {
		return issue;
	}
	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getResolution_comment() {
		return resolution_comment;
	}
	public void setResolution_comment(String resolution_comment) {
		this.resolution_comment = resolution_comment;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public User getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}
	public User getRaisedBy() {
		return raisedBy;
	}
	public void setRaisedBy(User raisedBy) {
		this.raisedBy = raisedBy;
	}
	public long getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(long modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
	
	
	
}
