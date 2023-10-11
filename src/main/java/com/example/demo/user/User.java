package com.example.demo.user;

import org.json.JSONObject;

import com.example.demo.role.Role;

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
public class User {
	
	@Id
	@SequenceGenerator(
			name="user_sequence",
			sequenceName="user_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence"
			
	)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String email;
	@ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id",nullable=false)
	private Role role;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public long getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}
	
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("id",this.id);
		obj.put("name",this.name);
		obj.put("email",this.email);
		obj.put("role",this.role.toJson());
		obj.put("createdOn",this.createdOn);
		return obj;
	}
	
	@Override
	public String toString() {
		return this.toJson().toString();
	}
	
	
	
	
}
	
	
	
	



