package com.example.demo.access;

import com.example.demo.role.Role;

import org.json.JSONObject;

import com.example.demo.module.Module;

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
public class Access {
	
	@Id
	@SequenceGenerator(
			name="access_sequence",
			sequenceName="access_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "access_sequence"
			
	)
	private int id;
	@ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id",nullable=false)
	private Role role;
	@ManyToOne
	@JoinColumn(name = "moduleId", referencedColumnName = "id",nullable=false)
	private Module module;
	@Column(nullable=false)
	private String status;
	@Column(nullable=false)
	private long modifiedOn;
	
//	public Access(Role role,Module module,String status,long modifiedOn) {
//		this.role = role;
//		this.module = module;
//		this.status = status;
//		this.modifiedOn = modifiedOn;
//	}
//	public Access(int id,Role role,Module module,String status,long modifiedOn) {
//		this.id=id;
//		this.role = role;
//		this.module = module;
//		this.status = status;
//		this.modifiedOn = modifiedOn;
//	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(long modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("id", this.id);
		obj.put("role",this.role.toJson());
		obj.put("module",this.module.toJson());
		obj.put("status",this.status);
		obj.put("modifiedOn", this.modifiedOn);
		return obj;
	}

	@Override
	public String toString() {
		return this.toJson().toString();
	}
	
	
	

}
