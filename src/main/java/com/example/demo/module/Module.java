package com.example.demo.module;

import java.util.List;

import org.json.JSONObject;

import com.example.demo.access.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Module {
	@Id
	@SequenceGenerator(
			name="module_sequence",
			sequenceName="module_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "module_sequence"
			
	)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private long createdOn;
	
	@OneToMany
	private List<Access> accessList;
	
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
	
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("id", this.id);
		obj.put("name",this.name);
		obj.put("createdOn",this.createdOn);
		obj.put("access", this.accessList);
		obj.put("access", accessList);
		return obj;
	}

	@Override
	public String toString() {
		return this.toJson().toString();
	}
	
	
	
}
