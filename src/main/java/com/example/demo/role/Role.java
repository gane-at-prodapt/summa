package com.example.demo.role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Role {
	@Id
	@SequenceGenerator(
			name="Role_sequence",
			sequenceName="Role_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "Role_sequence"
			
	)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private long createdOn;
	
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
	public long getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
}
