package com.example.demo.issue;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Issue {
	@Id
	@SequenceGenerator(
			name="issue_sequence",
			sequenceName="issue_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "issue_sequence"
			
	)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String network_family;
	@Column(nullable=false)
	private String description;
	@Column(nullable=false)
	private int severity;
	@Column(nullable=false)
	private int priority;
	@Column(nullable=false)
	private long modifiedOn;
	
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
	public String getNetwork_family() {
		return network_family;
	}
	public void setNetwork_family(String network_family) {
		this.network_family = network_family;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public long getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(long modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
	
	
	
	
}
