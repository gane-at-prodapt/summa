package com.example.demo.auth;

import com.example.demo.user.User;

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
public class Auth {
	
	@Id
	@SequenceGenerator(
			name="auth_sequence",
			sequenceName="auth_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "auth_sequence"
			
	)
	private int id;
	@Column(nullable=false)
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(nullable=false)
	private String authToken;
	@Column(nullable=false)
	private long modifiedOn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public long getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(long modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	

}
