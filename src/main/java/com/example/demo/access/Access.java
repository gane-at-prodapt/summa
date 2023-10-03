package com.example.demo.access;

import com.example.demo.role.Role;
import com.example.demo.module.Module;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId", referencedColumnName = "id")
	private Role role;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "moduleId", referencedColumnName = "id")
	private Module module;
	@Column(nullable=false)
	private String status;
	@Column(nullable=false)
	private long modifiedOn;
	
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
	
	
	

}
